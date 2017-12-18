# flurry-codenameone

Library extension of Flurry(https://developer.yahoo.com/analytics/) for the Codename One platform.(http://www.codenameone.com)

This plugin supports flurry analytics and Interstitial Ads (Full Screen Ads)

The library is implemented for Android and iOS.

# Usage

## analytics
        //init the Flurry Manager
        FlurryManager manager = new FlurryManager();
        manager.setCrashReportingEnabled(true);
        if(Display.getInstance().getPlatformName().equals("and")){
            manager.init(android_api_key);
        }else{
            manager.init(ios_api_key);        
        }
        manager.startSession();
## When you need to track events use:

        //regular events
        manager.logEvent(event_id);

        //true if this is a timed event
        manager.logEvent(event_id, true);
        //end the timed event
        manager.endTimedEvent(event_id);
## Ads
        //init the Flurry Manager
        FlurryManager manager = new FlurryManager();
        manager.setCrashReportingEnabled(true);
        if(Display.getInstance().getPlatformName().equals("and")){
            manager.init(android_api_key);
        }else{
            manager.init(ios_api_key);        
        }
        manager.setAdSpaceName(<your-ad-space-name>);
        manager.startSession();

## When you want to display an Ad use the below utility methods:

        //fetch an Ad async and prepare it
        manager.fetchAd();

        //after fetch asks if the Ad is ready for display
        manager.isAdReady();

        //show the fetched Ad if ready
        manager.displayAd();

        //destory the Ad
        manager.destroyAd();

## Integration
1)Build the project <br/>
2)Place the CN1Flurry.cn1lib file in your CN1 project lib. <br/>
3)Right click on your CN1 project and select "Refresh Libs" then clean build your project.

### Android

Include google play services - add `android.includeGPlayServices=true`
build hint to your project.

Include v4 support library - add `android.supportV4=true` build hint to your project.

Add the flurry activity to your manifest - add

~~~~
android.xapplication=\<activity android:name="com.flurry.android.FlurryFullscreenTakeoverActivity" android:configChanges="keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize"> \</activity>
~~~~

 build hint to your project

Disable proguard or mark relevant classes with the keep hints `android.enableProguard=false`

or

~~~~
android.proguardKeep=keep
class com.flurry.** { *; }
dontwarn
com.flurry.**
keepattributes
*Annotation*,EnclosingMethod
keepclasseswithmembers
class * {
public <init>(android.content.Context, android.util.AttributeSet, int);
}
keep
class * extends java.util.ListResourceBundle {
protected Object[][] getContents();
}
keep
public class
com.google.android.gms.common.internal.safeparcel.SafeParcelable {
public static final *** NULL;
}
keepnames
@com.google.android.gms.common.annotation.KeepName class *
keepclassmembernames
class * {
@com.google.android.gms.common.annotation.KeepName *;
}
keepnames
class * implements android.os.Parcelable {
public static final ** CREATOR;
}
~~~~

### iOS

No configuration necessary.
