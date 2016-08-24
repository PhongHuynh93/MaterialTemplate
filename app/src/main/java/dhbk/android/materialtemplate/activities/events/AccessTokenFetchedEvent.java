package dhbk.android.materialtemplate.activities.events;

import com.byoutline.ottocachedfield.events.ResponseEventWithArgImpl;

import dhbk.android.appjava.model.AccessToken;
import dhbk.android.appjava.model.EmailAndPass;

/**
 * Created by Sebastian Kacprzak <sebastian.kacprzak at byoutline.com> on 31.03.15.
 */
public class AccessTokenFetchedEvent extends ResponseEventWithArgImpl<AccessToken, EmailAndPass> {
}
