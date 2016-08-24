package dhbk.android.materialtemplate.activities.dagger;

import com.squareup.otto.Bus;

import dagger.Component;
import dhbk.android.materialtemplate.activities.KickMaterialApp;
import dhbk.android.materialtemplate.activities.activities.CategoriesListActivity;
import dhbk.android.materialtemplate.activities.activities.ProjectDetailsActivity;
import dhbk.android.materialtemplate.activities.activities.RewardsListActivity;
import dhbk.android.materialtemplate.activities.fragments.ProjectsListFragment;
import dhbk.android.materialtemplate.activities.fragments.SearchListFragment;

/**
 * Created by Sebastian Kacprzak <sebastian.kacprzak at byoutline.com> on 27.03.15.
 */
@GlobalScope
@Component(modules = GlobalModule.class)
public interface GlobalComponent {
    void inject(CategoriesListActivity fragment);

    void inject(SearchListFragment fragment);

    void inject(ProjectsListFragment fragment);

    void inject(ProjectDetailsActivity activity);

    void inject(RewardsListActivity rewardsListActivity);

    Bus getBus();

    KickMaterialApp getApp();
}
