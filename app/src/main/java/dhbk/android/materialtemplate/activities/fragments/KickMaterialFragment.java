package dhbk.android.materialtemplate.activities.fragments;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;

/**
 * Created by huynhducthanhphong on 8/23/16.
 */
public abstract class KickMaterialFragment extends Fragment {
    /**
     * add interface to communicate with activity
     */
    public interface HostActivity extends com.byoutline.secretsauce.activities.HostActivityV4 {
        void enableActionBarAutoHide(final RecyclerView listView);

        void showActionbar(boolean show, boolean animate);

        void setToolbarAlpha(float alpha);

    }
}
