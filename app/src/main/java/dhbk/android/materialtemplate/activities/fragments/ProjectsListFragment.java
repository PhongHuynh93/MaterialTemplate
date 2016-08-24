package dhbk.android.materialtemplate.activities.fragments;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.byoutline.cachedfield.FieldState;
import com.byoutline.cachedfield.FieldStateListener;
import com.byoutline.secretsauce.utils.ViewUtils;

import org.parceler.Parcels;

import javax.annotation.Nullable;

import butterknife.ButterKnife;
import dhbk.android.appjava.model.Category;
import dhbk.android.materialtemplate.R;
import dhbk.android.materialtemplate.activities.KickMaterialApp;
import dhbk.android.materialtemplate.activities.activities.CategoriesListActivity;
import dhbk.android.materialtemplate.activities.adapters.ProjectClickListener;
import dhbk.android.materialtemplate.activities.adapters.SharedViews;
import dhbk.android.materialtemplate.activities.views.EndlessRecyclerView;
import timber.log.Timber;

/**
 * Created by huynhducthanhphong on 8/23/16.
 */
public class ProjectsListFragment  extends KickMaterialFragment implements ProjectClickListener, FieldStateListener, EndlessRecyclerView.EndlessScrollListener {
    private GridLayoutManager layoutManager;

    // the category which user has chosen
    private Category category;

//    root view after inflate
    private View rootView;

//     endless recyclerview
    private EndlessRecyclerView projectListRv;

    // max scroll
    private float maxScroll;

    //
    private float actionbarScrollPoint;

    public static ProjectsListFragment newInstance(@Nullable Category category) {
        ProjectsListFragment instance = new ProjectsListFragment();
        Bundle args = new Bundle();
        args.putParcelable(CategoriesListActivity.ARG_CATEGORY, Parcels.wrap(category));
        instance.setArguments(args);
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_projects, container, false);
        KickMaterialApp.component.inject(this);
        ButterKnife.bind(this, rootView);
        hostActivity.enableActionBarAutoHide(projectListRv);
        maxScroll = 2 * getResources().getDimensionPixelSize(R.dimen.project_header_padding_top) + ViewUtils.dpToPx(48, getActivity());
        actionbarScrollPoint = ViewUtils.dpToPx(24, getActivity());
        getArgs();
        setHasOptionsMenu(true);
        return rootView;
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

    /**
     * get the name of the choosen category
     * @return name of the choose category
     */
    @Override
    public String getFragmentActionbarName() {
        if (category != null) {
            return getString(category.nameResId);
        } else {
            return "Projects";
        }
    }

    private void getArgs() {
        Bundle args = getArguments();
        if (args != null && args.containsKey(CategoriesListActivity.ARG_CATEGORY)) {
            category = Parcels.unwrap(args.getParcelable(CategoriesListActivity.ARG_CATEGORY));
        } else {
            Timber.e("Category not passed");
        }
    }
}
