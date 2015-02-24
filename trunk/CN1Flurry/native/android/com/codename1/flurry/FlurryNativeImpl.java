package com.codename1.flurry;

import android.os.Bundle;
import com.codename1.impl.android.AndroidNativeUtil;
import com.codename1.impl.android.LifecycleListener;
import com.flurry.android.*;

public class FlurryNativeImpl {
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
        FlurryAgent.onStartSession(AndroidNativeUtil.getActivity());
        com.codename1.impl.android.AndroidNativeUtil.addLifecycleListener(new LifecycleListener() {

            public void onCreate(Bundle savedInstanceState) {
            }

            public void onResume() {
            }

            public void onPause() {
            }

            public void onDestroy() {
                com.codename1.impl.android.AndroidNativeUtil.removeLifecycleListener(this);
                FlurryAgent.onEndSession(AndroidNativeUtil.getActivity());
            }

            public void onSaveInstanceState(Bundle b) {
            }

            public void onLowMemory() {
            }
        });
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
        FlurryAgent.setUserID(param);
    }

    
    public boolean isSupported() {
        return true;
    }

}
