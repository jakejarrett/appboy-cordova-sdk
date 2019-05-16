package com.appboy.cordova;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.content.pm.PackageManager;

import com.appboy.Constants;
import com.appboy.IAppboyNavigator;
import com.appboy.support.StringUtils;
import com.appboy.ui.AppboyNavigator;
import com.appboy.ui.actions.NewsfeedAction;
import com.appboy.ui.actions.UriAction;

/**
 * TODO:
 * 	This needs to mutate the gotoUri method so that it ACTUALLY USES INTENTS!
 * Currently this just opens the current context if no deep link is present, or just restarts the app with new intents if there are intents.
 */
public class CustomAppboyNavigator implements IAppboyNavigator {

	@Override
	public void gotoUri(Context context, UriAction uriAction) {
		PackageManager pm = context.getPackageManager();
		Intent launchIntent = pm.getLaunchIntentForPackage(context.getPackageName());
		Bundle extras = intent.getExtras();

			// String uri = uriAction.getUri().toString();
			// if (!StringUtils.isNullOrBlank(uri) && uri.matches(context.getString(R.string.youtube_regex))) {
			//   uriAction.setUseWebView(false);
			// }
		// AppboyNavigator.executeUriAction(context, uriAction);

		if (extras != null) {
			launchIntent.putExtras(extras);
		}

		launchIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_FROM_BACKGROUND);

		if (launchIntent.resolveActivity(context.getPackageManager()) != null) {
		context.startActivity(launchIntent);
		}
	}
}
