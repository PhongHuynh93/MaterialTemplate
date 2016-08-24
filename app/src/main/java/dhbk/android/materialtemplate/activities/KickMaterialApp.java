package dhbk.android.materialtemplate.activities;

import com.byoutline.secretsauce.BaseApp;
import com.byoutline.secretsauce.utils.ViewUtils;

import dhbk.android.materialtemplate.BuildConfig;
import timber.log.Timber;

/**
 * Created by huynhducthanhphong on 8/24/16.
 */
public class KickMaterialApp extends BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        AndroidStubServer.start(this, NetworkType.UMTS);
        RetrofitHelper.MSG_DISPLAYER = msg -> ViewUtils.showToast(msg, true);
        resetComponents();
    }

    @Override
    protected boolean isDebug() {
        return BuildConfig.DEBUG;
    }

}
