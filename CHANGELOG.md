## 2.9.0

#### Changed
- Updated Braze iOS version to 3.14.0.
- Updated Braze Android version to 3.2.2.
- Changed the iOS plugin to use Cocoapods instead of a framework integration.
- Improved the look and feel of in-app messages to adhere to the latest UX and UI best practices. Changes affect font sizes, padding, and responsiveness across all message types. Now supports button border styling.

#### Fixed
- Fixed the Android plugin not respecting decimal purchase prices.
  - Fixes https://github.com/Appboy/appboy-cordova-sdk/issues/36.

## 2.8.0
- Changed the iOS frameworks to be automatically embedded in the `plugin.xml`.
  - This fixes the "dyld: Library not loaded" issue raised in XCode if the frameworks were not manually embedded.
- Adds method to immediately flush any pending data via `requestImmediateDataFlush()`.

## 2.7.1
- Fixes an issue where sending push on Android resulted in a crash in version 2.7.0. Past versions (before 2.7.0) are unaffected.

## 2.7.0
- Updates Braze Android version to 3.0.0+
  - Removes GCM push registration methods. In your config.xml `com.appboy.android_automatic_push_registration_enabled` and `com.appboy.android_gcm_sender_id` , now have no effect on push registration.
- Updates Braze iOS version to 3.9.0.

## 2.6.0
- Fixes an issue where the Cordova 8.0.0+ build system would convert numeric preferences in the `config.xml` to be floating point numbers.
  - Numeric preferences, such as sender ids, now should be prefixed with `str_` for correct parsing. I.e. `<preference name="com.appboy.android_fcm_sender_id" value="str_64422926741" />`.
- Updates Braze Android version to 2.6.0+

## 2.5.1
- Updates Braze Android version to 2.4.0+.
- Adds Firebase Cloud Messaging automatic registration support. GCM automatic registration should be disabled by setting the config value "com.appboy.android_automatic_push_registration_enabled" to "false". See the Android sample-project's `config.xml` for an example. FCM `config.xml` keys below.
    - "com.appboy.firebase_cloud_messaging_registration_enabled" ("true"/"false")
    - "com.appboy.android_fcm_sender_id" (String)
    - The Firebase dependencies `firebase-messaging` and `firebase-core` are now included automatically as part of the plugin.

## 2.5.0
- Updates Braze Android version to 2.2.5+.
- Updates Braze iOS version to 3.3.4.
- Adds `wipeData()`, `enableSdk()`, and `disableSdk()` methods to the plugin.

## 2.4.0
- Fixes a subdirectory incompatibility issue with Cordova 7.1.0

## 2.3.2
- Adds configuration for custom API endpoints on iOS and Android using the config.xml.
    - Android preference: "com.appboy.android_api_endpoint"
    - iOS preference: "com.appboy.ios_api_endpoint"

## 2.3.1
- Adds getter for all News Feed cards. Thanks to @cwelk for contributing.
- Adds a git branch `geofence-branch` for registering geofences with Google Play Services and messaging on geofence events. Please reach out to success@appboy.com for more information about this feature. The branch has geofences integrated for both Android and iOS.

## 2.3.0
- Fixes in-app messages display issue on iOS.
- Updates Appboy iOS version to 2.29.0
- Updates Appboy Android version to 2.0+
- Fixes original in-app messages not being requested on Android.

## 2.2.0
- Updates Appboy Android version to 1.18+
- Updates Appboy iOS version to 2.25.0
- Adds the ability to configure the Android Cordova SDK using the config.xml. See the Android sample-project's `config.xml` for an example.
    - Supported keys below, see [the AppboyConfig.Builder javadoc](http://appboy.github.io/appboy-android-sdk/javadocs/com/appboy/configuration/AppboyConfig.Builder.html) for more details
    - "com.appboy.api_key" (String)
    - "com.appboy.android_automatic_push_registration_enabled" ("true"/"false")
    - "com.appboy.android_gcm_sender_id" (String)
    - "com.appboy.android_small_notification_icon" (String)
    - "com.appboy.android_large_notification_icon" (String)
    - "com.appboy.android_notification_accent_color" (Integer)
    - "com.appboy.android_default_session_timeout" (String)
    - "com.appboy.android_handle_push_deep_links_automatically" ("true"/"false")
    - "com.appboy.android_log_level" (Integer) can also be configured here, for obtaining debug logs from the Appboy Android SDK
- Updates the Android Cordova SDK to use the [Appboy Lifecycle listener](http://appboy.github.io/appboy-android-sdk/javadocs/com/appboy/AppboyLifecycleCallbackListener.html) to handle session and in-app message registration

## 2.1.0
- Adds support for iOS 10 push registration and handling using the UNUserNotificationCenter.
- Adds functionality for turning off automatic push registration on iOS. To disable, add the preference `com.appboy.ios_disable_automatic_push_handling` with a value of `YES`.

## 2.0.0
- Updates to add functionality for turning off automatic push registration on iOS.  If you want to turn off iOS default push registration, add the preference `com.appboy.ios_disable_automatic_push_registration` with a value of `YES`.
- Includes patch for iOS 10 push open bug.  See https://github.com/Appboy/appboy-ios-sdk/releases/tag/2.24.0 for more information.
- Updates Appboy iOS version to 2.24.2.
- Updates Appboy Android version to 1.15+.
- Updates plugin to configure Android via parameters to eliminate need for post-install modifications on Android. Ported from https://github.com/Appboy/appboy-cordova-sdk/tree/feature/android-variable-integration.

## 0.1
- Initial release. Adds support for Appboy Android version 1.12+ and Appboy iOS version 2.18.1.
