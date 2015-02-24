/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.flurry;

/**
 *
 * @author Chen
 */
public class Callback {
    
    private static FlurryAdsListener l;
    
    public static void onClicked(){
        if(l != null){
            l.onClicked();
        }
    }

    public static void onClose(){
        if(l != null){
            l.onClose();
        }    
    }

    public static void onDisplay(){
        if(l != null){
            l.onDisplay();
        }        
    }

    public static void onAppExit(){
        if(l != null){
            l.onAppExit();
        }            
    }

    public static void onRendered(){
        if(l != null){
            l.onRendered();
        }                
    }

    public static void onError(String err){
        if(l != null){
            l.onError(err);
        }                    
    }

    public static void onFetched(){
        if(l != null){
            l.onFetched();
        }                        
    }
    
    static void setListener(FlurryAdsListener listener){
        l = listener;
    }
    
}
