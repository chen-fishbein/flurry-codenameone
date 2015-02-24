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
public interface FlurryAdsListener {

    public void onClicked();

    public void onClose();

    public void onDisplay();

    public void onAppExit();

    public void onRendered();

    public void onError(String err);

    public void onFetched();
}
