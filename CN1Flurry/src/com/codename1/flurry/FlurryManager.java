/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.flurry;

import com.codename1.system.NativeLookup;
import com.codename1.ui.Display;

/**
 * Utility class to use the Flurry API
 *
 * @author Chen
 */
public class FlurryManager {
    
    public static enum SDK {
        ANDROID,
        IPHONE
    }
    
    private FlurryNative flurry = null;

    /**
     * Creates a FlurryManager instance
     *
     * @param apiKey flurry api key
     */
    public FlurryManager() {
        flurry = (FlurryNative) NativeLookup.create(FlurryNative.class);
    }

    /**
     * Init the flurry with the api key
     *
     * @param apiKey
     */    
    public void init(String apiKey) {
        if (flurry != null) {
            flurry.initFlurry(apiKey);
        }        
    }
    
    /**
     * An initializer that takes into account the SDK that is in use.  This 
     * allows init() to be called multiple times, and only the one for the
     * current platform will be effectual.  This is required because
     * the Android app will need a different API key than the IOS app.
     * @param apiKey The unique flurry API key.
     * @param sdk The SDK that this key corresponds to.
     */
    public void init(String apiKey, SDK sdk){
        String platformName = Display.getInstance().getPlatformName();
        if (sdk==SDK.ANDROID && "and".equals(platformName)){
            init(apiKey);
        } else if (sdk==SDK.IPHONE && "ios".equals(platformName)){
            init(apiKey);
        }
    }
    
    public void startSession(){
        if (flurry != null) {
            flurry.startSession();
        }            
    }
    
    public void endSession(){
        if (flurry != null) {
            flurry.endSession();
        }            
    }

    /**
     * Should be called before initFlurry
     */
    public void setCrashReportingEnabled(boolean enable) {
        flurry.setCrashReportingEnabled(enable);
    }

    /**
     * Should be called before initFlurry
     */
    public void setLogEvents(boolean enable) {
        flurry.setLogEvents(enable);
    }

    /**
     * Use logEvent to track user events that happen during a session.
     *
     * @param eventId event id
     */
    public void logEvent(String eventId) {
        flurry.logEvent(eventId, false);
    }

    /**
     * Use logEvent to track timed user events that happen during a session.
     *
     * @param eventId event id
     * @param timed if timed true call endTimedEvent once the event ended
     */
    public void logEvent(String eventId, boolean timed) {
        flurry.logEvent(eventId, timed);
    }

    /**
     * Use endTimedEvent to end the timed event
     *
     * @param eventId event id
     */
    public void endTimedEvent(String eventId) {
        flurry.endTimedEvent(eventId);
    }

    /**
     * Use onPageView to report page view count
     */
    public void onPageView() {
        flurry.onPageView();
    }

    /**
     * Flurry Ads
     */
    
    /**
     * This should be called before fetchAd or displayAd
     */    
    public void setAdSpaceName(String adSpace) {
        flurry.setAdSpaceName(adSpace);
    }

    public boolean isAdReady() {
        return flurry.isAdReady();
    }
    
    public void fetchAd() {
        flurry.fetchAd();
    }

    public void displayAd() {
        flurry.displayAd();
    }

    public void destroyAd() {
        flurry.destroyAd();
    }
    
    public void setAdsListener(FlurryAdsListener l) {
        Callback.setListener(l);
    }
    
}
