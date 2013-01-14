package edu.cornell.atd7.netflixcm101fix;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class CM101NetflixPatcher implements IXposedHookLoadPackage {
	public static final String MY_PACKAGE_NAME = CM101NetflixPatcher.class.getPackage()
			.getName();
	public static final String TAG = "EntropyCM101NetflixPatch";

	@Override
	public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
		// TODO Auto-generated method stub
		if (lpparam.packageName.equals("com.netflix.mediaclient")) {
			ClassLoader classLoader = lpparam.classLoader;
			
			XC_MethodReplacement versioncheckreplacer = new XC_MethodReplacement() {
				protected Object replaceHookedMethod(
						XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
						throws Throwable {
					return Integer.valueOf("15");
					
				}
			};
			
			XposedHelpers.findAndHookMethod("com.netflix.mediaclient.util.AndroidUtils",
					classLoader, "getAndroidVersion", versioncheckreplacer);
		}

	}

}
