package dhbk.android.materialtemplate.activities.activities;

import android.os.Bundle;

import dhbk.android.materialtemplate.R;

public class MainActivity extends KickMaterialBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        injectViewsAndSetUpToolbar();
//        setUpDrawer(true);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, ProjectsListFragment.newInstance(DataManager.getCategoryAll()))
                    .commit();
        }
    }

    /**
     * change alpha of a view
     * @param alpha
     */
    @Override
    public void setToolbarAlpha(float alpha) {
        toolbar.getBackground().setAlpha((int) (alpha * 255));
    }

}
