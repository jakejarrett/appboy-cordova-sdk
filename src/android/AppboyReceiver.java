package com.appboy.cordova;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.os.Bundle;
import android.content.pm.PackageManager;

public class AppboyReceiver extends BroadcastReceiver {

  private static final String TAG = AppboyReceiver.class.getSimpleName();

  @Override
  public void onReceive(Context context, Intent intent) {
    String action = intent.getAction();

    if ( action.equals("com.appboy.ui.intent.APPBOY_NOTIFICATION_OPENED") ) {
        Log.v(TAG, "intent : "+intent);

        PackageManager pm = context.getPackageManager();
        Intent launchIntent = pm.getLaunchIntentForPackage(context.getPackageName());

        Bundle extras = intent.getExtras();
        if (extras != null) {
            launchIntent.putExtras(extras);
        }
        launchIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        launchIntent.addFlags(Intent.FLAG_FROM_BACKGROUND);

        context.startActivity(launchIntent);

    }

  }
} 