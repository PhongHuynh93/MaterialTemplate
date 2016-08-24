package dhbk.android.appjava.model;


import java.util.List;
import java.util.Map;

import dhbk.android.appjava.utils.QueryParamsExtractor;

/**
 * Created by Sebastian Kacprzak on 24.03.15.
 */
public class DiscoverResponse {
    public List<Project> projects;
    public DiscoverUrls urls;

    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"NP_UNWRITTEN_PUBLIC_OR_PROTECTED_FIELD"})
    public Map<String, String> getMoreProjectsUrl() {
        // Values are written by retrofit.
        return QueryParamsExtractor.getQueryParams(urls.api.moreProjects);
    }

}
