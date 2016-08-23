package dhbk.android.materialtemplate.activities.activities;

import android.os.Bundle;

import dhbk.android.materialtemplate.R;

public class MainActivity extends KickMaterialBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
