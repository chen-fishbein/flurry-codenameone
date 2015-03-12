package com.codename1.flurry;

import com.codename1.impl.android.AndroidNativeUtil;
import com.flurry.android.*;
import com.flurry.android.ads.*;

public class FlurryNativeImpl {
    
    private FlurryAdInterstitial mFlurryAdInterstitial = null;
    
    private String adSpace;
    
    public void onPageView() {
        FlurryAgent.onPageView();
    }

    
    public void setCrashReportingEnabled(boolean param) {
        FlurryAgent.setCaptureUncaughtExceptions(param);
    }
            
    public void setLogEvents(boolean param) {
        FlurryAgent.setLogEvents(param);
    }

    public void initFlurry(String apiKey) {
        FlurryAgent.init(AndroidNativeUtil.getActivity(), apiKey);
    }

    public void endTimedEvent(String param) {
        FlurryAgent.endTimedEvent(param);
    }

    public void logEvent(String param, boolean param1) {
        FlurryAgent.logEvent(param, param1);
    }

    
    public void setAge(int param) {
        FlurryAgent.setAge(param);
    }
    
    public void setGender(String param) {
        if(param.equalsIgnoreCase("m")){
            FlurryAgent.setGender(Constants.MALE);        
        }else if(param.equalsIgnoreCase("f")){
            FlurryAgent.setGender(Constants.FEMALE);                
        }
    }

    public void setUserID(String param) {
        FlurryAgent.setUserId(param);
    }

    
    public void setAdSpaceName(String adSpace){    
        this.adSpace = adSpace;
        mFlurryAdInterstitial = new FlurryAdInterstitial(AndroidNativeUtil.getActivity(), adSpace);
        mFlurryAdInterstitial.setListener(new FlurryAdInterstitialListener() {

            public void onFetched(FlurryAdInterstitial fai) {
                Callback.onFetched();
            }

            public void onRendered(FlurryAdInterstitial fai) {
                Callback.onRendered();
            }

            public void onDisplay(FlurryAdInterstitial fai) {
                Callback.onDisplay();
            }

            public void onClose(FlurryAdInterstitial fai) {
                Callback.onClose();
                mFlurryAdInterstitial = null;
            }

            public void onAppExit(FlurryAdInterstitial fai) {
                Callback.onAppExit();
            }

            public void onClicked(FlurryAdInterstitial fai) {
                Callback.onClicked();
            }

            public void onVideoCompleted(FlurryAdInterstitial fai) {
                Callback.onVideoCompleted();
                mFlurryAdInterstitial = null;
            }

            public void onError(FlurryAdInterstitial fai, FlurryAdErrorType faet, int i) {
                Callback.onError("err");
            }
        });
    }
    
    public void destroyAd() {
        if(mFlurryAdInterstitial != null){
            mFlurryAdInterstitial.destroy();
        }
    }

    public void displayAd() {
        if(mFlurryAdInterstitial != null){
            mFlurryAdInterstitial.displayAd();
        }
    }

    public void fetchAd() {
        if(mFlurryAdInterstitial != null){
            mFlurryAdInterstitial.fetchAd();
        }else{
            if(adSpace != null){
                setAdSpaceName(adSpace);
                fetchAd();
            }
        }
    }


    public void startSession() {
        FlurryAgent.onStartSession(AndroidNativeUtil.getActivity());
    }

    public void endSession() {
        FlurryAgent.onEndSession(AndroidNativeUtil.getActivity());
    }
    
    public boolean isAdReady() {
        if(mFlurryAdInterstitial != null){
            return mFlurryAdInterstitial.isReady();
        }
        return false;
    }
    
    public boolean isSupported() {
        return true;
    }

}
