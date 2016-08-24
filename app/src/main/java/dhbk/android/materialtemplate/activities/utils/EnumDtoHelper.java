package dhbk.android.materialtemplate.activities.utils;


import dhbk.android.materialtemplate.activities.KickMaterialApp;

/**
 * @author Sebastian Kacprzak <nait at naitbit.com> on 11.03.2014
 */
public final class EnumDtoHelper {
    private EnumDtoHelper() {
    }

    public static String getDisplayName(int nameResId, String fallbackName) {
        KickMaterialApp instance = KickMaterialApp.component.getApp();
        if (instance == null) {
            return fallbackName;
        } else {
            return instance.getApplicationContext().getString(nameResId);
        }
    }
}
