/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.flurry;

import com.codename1.ui.Display;

/**
 *
 * @author Chen
 */
public class Callback {
    
    private static FlurryAdsListener l;
    
    public static void onClicked(){
        if(l != null){
            Display.getInstance().callSerially(new Runnable(){

                public void run() {
                    l.onClicked();
                }
            });
        }
    }

    public static void onClose(){
        if(l != null){
            Display.getInstance().callSerially(new Runnable(){

                public void run() {
                    l.onClose();
                }
            });
        }    
    }

    public static void onDisplay(){
        if(l != null){
            Display.getInstance().callSerially(new Runnable(){

                public void run() {
                    l.onDisplay();
                }
            });
        }        
    }

    public static void onAppExit(){
        if(l != null){
            Display.getInstance().callSerially(new Runnable(){

                public void run() {
                    l.onAppExit();
                }
            });
        }            
    }

    public static void onRendered(){
        if(l != null){
            Display.getInstance().callSerially(new Runnable(){

                public void run() {
                    l.onRendered();
                }
            });
        }                
    }

    public static void onError(final String err){
        if(l != null){
            Display.getInstance().callSerially(new Runnable(){

                public void run() {
                    l.onError(err);
                }
            });
        }                    
    }

    public static void onFetched(){
        if(l != null){
            Display.getInstance().callSerially(new Runnable(){

                public void run() {
                    l.onFetched();
                }
            });
        }                        
    }
    
    public static void onVideoCompleted(){
        if(l != null){
            Display.getInstance().callSerially(new Runnable(){

                public void run() {
                    l.onVideoCompleted();
                }
            });
        }                        
    }

    static void setListener(FlurryAdsListener listener){
        l = listener;
    }
    
}
