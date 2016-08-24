package dhbk.android.materialtemplate.activities.events;

import com.byoutline.ottocachedfield.events.ResponseEventWithArgImpl;

import dhbk.android.appjava.model.ProjectDetails;
import dhbk.android.appjava.model.ProjectIdAndSignature;

/**
 * Created by Sebastian Kacprzak <sebastian.kacprzak at byoutline.com> on 26.03.15.
 */
public class ProjectDetailsFetchedEvent extends ResponseEventWithArgImpl<ProjectDetails, ProjectIdAndSignature> {
}