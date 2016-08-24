package dhbk.android.materialtemplate.activities.events;

import com.byoutline.ottocachedfield.events.ResponseEventWithArgImpl;

import dhbk.android.appjava.model.ProjectIdAndSignature;

/**
 * Created by Sebastian Kacprzak <sebastian.kacprzak at byoutline.com> on 26.03.15.
 */
public class ProjectDetailsFetchingFailedEvent extends ResponseEventWithArgImpl<Exception, ProjectIdAndSignature> {
}