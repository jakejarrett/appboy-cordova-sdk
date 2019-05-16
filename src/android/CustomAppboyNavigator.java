package com.appboy.cordova;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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

	/**
	 * Use similar intent based approach here to the below.
	 */
	@Override
	public void gotoNewsFeed(Context context, NewsfeedAction newsfeedAction) {
		// UNTESTED
		// Intent intent = new Intent(context, DroidBoyActivity.class);
		// intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
		// intent.putExtras(newsfeedAction.getExtras());
		// intent.putExtra(context.getResources().getString(R.string.source_key), Constants.APPBOY);
		// intent.putExtra(context.getResources().getString(R.string.destination_view), context.getResources().getString(R.string.feed_key));
		// context.startActivity(intent);
	}

	@Override
	public void gotoUri(Context context, UriAction uriAction) {
		// PackageManager pm = context.getPackageManager();
		// Intent launchIntent = pm.getLaunchIntentForPackage(context.getPackageName());
		// Bundle extras = launchIntent.getExtras();

		String uri = uriAction.getUri().toString();
		Log.v(CustomAppboyNavigator.class.getSimpleName(), "\n\n\nintent : "+ launchIntent + "\n\n\n");
		Log.v(CustomAppboyNavigator.class.getSimpleName(), "\n\n\nuri : "+ uri + "\n\n\n");

		// if (extras != null) {
		// 	launchIntent.putExtras(extras);
		// }

		launchIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_FROM_BACKGROUND);

		if (!StringUtils.isNullOrBlank(uri) && uri.matches(context.getString(R.string.youtube_regex))) {
			uriAction.setUseWebView(false);
		}
		AppboyNavigator.executeUriAction(context, uriAction);

		// if (launchIntent.resolveActivity(context.getPackageManager()) != null) {
		// 	context.startActivity(launchIntent);
		// }
	}
}
