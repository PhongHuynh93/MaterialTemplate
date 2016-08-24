package dhbk.android.materialtemplate.activities.fragments;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.byoutline.cachedfield.FieldState;
import com.byoutline.cachedfield.FieldStateListener;

import org.parceler.Parcels;

import javax.annotation.Nullable;

import dhbk.android.appjava.model.Category;
import dhbk.android.materialtemplate.activities.activities.CategoriesListActivity;
import dhbk.android.materialtemplate.activities.adapters.ProjectClickListener;
import dhbk.android.materialtemplate.activities.adapters.SharedViews;
import dhbk.android.materialtemplate.activities.views.EndlessRecyclerView;

/**
 * Created by huynhducthanhphong on 8/23/16.
 */
public class ProjectsListFragment  extends KickMaterialFragment implements ProjectClickListener, FieldStateListener, EndlessRecyclerView.EndlessScrollListener {
    /**
     * Endless scroll variables *
     */
    private GridLayoutManager layoutManager;

    public static ProjectsListFragment newInstance(@Nullable Category category) {
        ProjectsListFragment instance = new ProjectsListFragment();
        Bundle args = new Bundle();
        args.putParcelable(CategoriesListActivity.ARG_CATEGORY, Parcels.wrap(category));
        instance.setArguments(args);
        return instance;
    }

    @Override
    public int getLastVisibleItemPosition() {
        return layoutManager.findLastVisibleItemPosition();
    }

    @Override
    public void loadMoreData() {

    }

    @Override
    public boolean hasMoreDataAndNotLoading() {
        return false;
    }

    @Override
    public void fieldStateChanged(FieldState newState) {

    }

    @Override
    public void projectClicked(int position, SharedViews views) {

    }
}
