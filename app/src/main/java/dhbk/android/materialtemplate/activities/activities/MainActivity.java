package dhbk.android.materialtemplate.activities.activities;

import android.os.Bundle;

import dhbk.android.materialtemplate.R;
import dhbk.android.materialtemplate.activities.fragments.ProjectsListFragment;

public class MainActivity extends KickMaterialBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // fixme - add toolbar for this view
        injectViewsAndSetUpToolbar();
//        setUpDrawer(true);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, ProjectsListFragment.newInstance(DataManager.getCategoryAll()))
                    .commit();
        }
    }

    /**
     * fixme - change alpha of a view (when we scroll, it's will opacity so we can see the content underneath)
     * @param alpha
     */
    @Override
    public void setToolbarAlpha(float alpha) {
        toolbar.getBackground().setAlpha((int) (alpha * 255));
    }

}
