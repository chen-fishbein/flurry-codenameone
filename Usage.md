# Usage #

## analytics ##
```
        //init the Flurry Manager
        FlurryManager manager = new FlurryManager();
        manager.setCrashReportingEnabled(true);
        if(Display.getInstance().getPlatformName().equals("and")){
            manager.init(android_api_key);
        }else{
            manager.init(ios_api_key);        
        }
        manager.startSession();

```

When you need to track events use:
```
        //regular events
        manager.logEvent(event_id);
        
        //true if this is a timed event
        manager.logEvent(event_id, true);
        //end the timed event
        manager.endTimedEvent(event_id);
```


## Ads ##
```
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

```

When you want to display an Ad use the below utility methods:
```
	//fetch an Ad async and prepare it
        manager.fetchAd();

	//after fetch asks if the Ad is ready for display
	manager.isAdReady();

	//show the fetched Ad if ready
	manager.displayAd();

        //destory the Ad
	manager.destroyAd();

```



# Integration #
1)Build the project <br>
2)Place the CN1Flurry.cn1lib file in your CN1 project lib. <br>
3)Right click on your CN1 project and select "Refresh Libs" then clean build your project.<br>

<h1>Android</h1>
1)Include google play services - add<br>
<pre><code>android.includeGPlayServices=true<br>
</code></pre>
build hint to your project.<br>
2)Include v4 support library - add<br>
<pre><code>android.supportV4=true<br>
</code></pre>
build hint to your project.<br>
3)Add the flurry activity to your manifest - add<br>
<pre><code>android.xapplication=&lt;activity android:name="com.flurry.android.FlurryFullscreenTakeoverActivity" android:configChanges="keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize"&gt; &lt;/activity&gt;<br>
</code></pre>
build hint to your project<br>
<br>

4)Disable proguard or mark relevant classes with the keep hints<br>
<br>
<pre><code><br>
android.enableProguard=false<br>
 <br>
or <br>
<br>
android.proguardKeep=keep<br>
class com.flurry.** { *; }<br>
dontwarn<br>
com.flurry.**<br>
keepattributes<br>
*Annotation*,EnclosingMethod<br>
keepclasseswithmembers<br>
class * {<br>
public &lt;init&gt;(android.content.Context, android.util.AttributeSet, int);<br>
}<br>
keep<br>
class * extends java.util.ListResourceBundle {<br>
protected Object[][] getContents();<br>
}<br>
keep<br>
public class<br>
com.google.android.gms.common.internal.safeparcel.SafeParcelable {<br>
public static final *** NULL;<br>
}<br>
keepnames<br>
@com.google.android.gms.common.annotation.KeepName class *<br>
keepclassmembernames<br>
class * {<br>
@com.google.android.gms.common.annotation.KeepName *;<br>
}<br>
keepnames<br>
class * implements android.os.Parcelable {<br>
public static final ** CREATOR;<br>
}<br>
<br>
</code></pre>

<h1>iOS</h1>
<pre><code>1)Add ios.add_libs=SystemConfiguration.framework;Security.framework<br>
build hint to your project<br>
</code></pre>