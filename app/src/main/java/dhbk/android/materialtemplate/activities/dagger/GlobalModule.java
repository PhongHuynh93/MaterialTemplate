package dhbk.android.materialtemplate.activities.dagger;

import android.content.SharedPreferences;

import com.squareup.otto.Bus;
import com.squareup.picasso.Picasso;

import org.joda.time.DateTime;

import java.util.List;

import javax.annotation.Nullable;

import dagger.Module;
import dagger.Provides;
import dhbk.android.materialtemplate.activities.KickMaterialApp;
import dhbk.android.materialtemplate.activities.managers.AccessTokenProvider;
import dhbk.android.materialtemplate.activities.utils.LruCacheWithPlaceholders;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import static com.byoutline.ibuscachedfield.util.RetrofitHelper.apiValueProv;


@Module
public class GlobalModule {

    private final KickMaterialApp app;
    private final Bus bus;
    private final AccessTokenProvider accessTokenProvider;
    private LruCacheWithPlaceholders picassoCache;

    public GlobalModule(KickMaterialApp app, Bus bus, AccessTokenProvider accessTokenProvider) {
        this.app = app;
        this.bus = bus;
        this.accessTokenProvider = accessTokenProvider;
        picassoCache = new LruCacheWithPlaceholders(app);
        try {
            Picasso.setSingletonInstance(new Picasso.Builder(app).memoryCache(picassoCache).build());
        } catch (IllegalStateException ex) {
            // singleton was already set
        }
    }

    @GlobalScope
    @Provides
    Bus providesOttoBus() {
        return bus;
    }

    @Provides
    KickMaterialApp providesApp() {
        return app;
    }

    @Provides
    LruCacheWithPlaceholders providesPicassoCache() {
        return picassoCache;
    }

    @Provides
    Gson providesGson() {
        GsonBuilder builder = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        JsonDeserializer<DateTime> deserializer = (json, typeOfT, context) -> new DateTime(json.getAsJsonPrimitive().getAsLong() * 1000);
        builder.registerTypeAdapter(DateTime.class, deserializer);
        return builder.create();
    }

    @Provides
    @GlobalScope
    public KickMaterialService providesKickMaterialService(KickMaterialRequestInterceptor requestInterceptor, Gson gson) {
        return createService("http://localhost:8099", KickMaterialService.class, requestInterceptor, gson);
    }

    private <T> T createService(String endpoint, Class<T> serviceClass, @Nullable KickMaterialRequestInterceptor requestInterceptor, Gson gson) {

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        if (requestInterceptor != null) {
            clientBuilder.addInterceptor(requestInterceptor);
        }


        Retrofit.Builder builder = new Retrofit.Builder();

        builder.baseUrl(endpoint)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(clientBuilder.build());


        return builder.build().create(serviceClass);
    }

    @Provides
    @GlobalScope
    public AccessTokenProvider provideATP() {
        return new AccessTokenProvider();
    }

    @Provides
    @GlobalScope
    public LoginManager providesLoginManager(Bus bus, KickMaterialService service, AccessTokenProvider accessTokenProvider) {
        LoginManager instance = new LoginManager(service, accessTokenProvider);
        bus.register(instance);
        return instance;
    }

    @Provides
    @GlobalScope
    public SharedPreferences providesSharedPreferences() {
        return app.getSharedPrefs();
    }

    @Provides
    @GlobalScope
    public CachedField<List<Category>> provideCategories(KickMaterialService service) {
        return new OttoCachedFieldBuilder<List<Category>>()
                .withValueProvider(apiValueProv(service::getCategories))
                .withSuccessEvent(new CategoriesFetchedEvent())
                .build();
    }

    @Provides
    @GlobalScope
    public CachedFieldWithArg<DiscoverResponse, DiscoverQuery> provideDiscover(KickMaterialService service) {
        return new OttoCachedFieldWithArgBuilder<DiscoverResponse, DiscoverQuery>()
                .withValueProvider(apiValueProv(query -> service.getDiscover(query.queryMap)))
                .withSuccessEvent(new DiscoverProjectsFetchedEvent())
                .withResponseErrorEvent(new DiscoverProjectsFetchedErrorEvent())
                .build();
    }

    @Provides
    @GlobalScope
    public ObservableCachedFieldWithArg<ProjectDetails, ProjectIdAndSignature>
    provideProjectDetails(KickMaterialService service) {
        return new OttoObservableCachedFieldWithArgBuilder<ProjectDetails, ProjectIdAndSignature>()
                .withValueProvider(apiValueProv(input -> service.getProjectDetails(input.id(), input.queryParams())))
                .withSuccessEvent(new ProjectDetailsFetchedEvent())
                .withResponseErrorEvent(new ProjectDetailsFetchingFailedEvent())
                .build();
    }
}