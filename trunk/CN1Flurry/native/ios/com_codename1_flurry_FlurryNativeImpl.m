#import "com_codename1_flurry_FlurryNativeImpl.h"
#import "Flurry.h"
#import "FlurryAdInterstitial.h"
#import "FlurryAdInterstitialDelegate.h"
#import "CodenameOne_GLViewController.h"
#import "com_codename1_flurry_Callback.h"

@implementation com_codename1_flurry_FlurryNativeImpl

FlurryAdInterstitial *adInterstitial = nil;

-(void)onPageView{
    [Flurry logPageView];
}

-(void)setCrashReportingEnabled:(BOOL)param{
    [Flurry setCrashReportingEnabled:(BOOL)param];
}

-(void)setLogEvents:(BOOL)param{
    [Flurry setDebugLogEnabled:param];
}

-(void)initFlurry:(NSString*)param{
    adID = param;
    
}

-(void)startSession{
    dispatch_sync(dispatch_get_main_queue(), ^{
        [Flurry startSession:adID];
    });
}

-(void)endSession{
//ios handles this once the app goes to background
}

-(void)endTimedEvent:(NSString*)param{
    [Flurry endTimedEvent:param withParameters:nil]; 
}

-(void)logEvent:(NSString*)param param1:(BOOL)param1{
    [Flurry logEvent:param timed:param1];
}

-(void)setGender:(NSString*)param{
    [Flurry setGender:param];
}

-(void)setUserID:(NSString*)param{
    [Flurry setUserID:param];
}

-(void)setAge:(int)param{
    [Flurry setAge:param];
}

-(BOOL)isAdReady{
    if (adInterstitial == nil){
        return NO;
    }
    return [adInterstitial ready];
}

-(void)setAdSpaceName:(NSString*)param{
    id del = self;
    dispatch_sync(dispatch_get_main_queue(), ^{
        adInterstitial = [[FlurryAdInterstitial alloc]  initWithSpace:param];
        adInterstitial.adDelegate = del;
    });
}

-(void)fetchAd{
    dispatch_sync(dispatch_get_main_queue(), ^{
        [adInterstitial fetchAd];
    });
}

-(void)displayAd{
    dispatch_sync(dispatch_get_main_queue(), ^{
        @try{
            [adInterstitial presentWithViewController: [CodenameOne_GLViewController instance]];
        } @catch (NSException *e){
            //NSLog(@"Exception %@ %@", [e reason], [e callStackSymbols]);
        }

    });
}

-(void)destroyAd{
//no ios method in the API
}



-(BOOL)isSupported{
    return YES;
}


/*!
 *  @brief Invoked when an ad is received for the specified @c interstitialAd object.
 *  @since 6.0.0
 *
 *  This method informs the app that an ad has been received and is available for display.
 *
 *  @see FlurryAdInterstitial#fetchAd for details on the method that will invoke this delegate.
 *
 *  @param interstitialAd The ad object that has successfully fetched an ad.
 */
- (void) adInterstitialDidFetchAd:(FlurryAdInterstitial*)interstitialAd{
    com_codename1_flurry_Callback_onFetched__(CN1_THREAD_GET_STATE_PASS_SINGLE_ARG);
}

/*!
 *  @brief Invoked when the interstitial ad is rendered.
 *  @since 6.0.0
 *
 *  This method informs the user an ad was retrieved, and successful in displaying to the user.
 *
 *  @see \n
 *  FlurryAdInterstitial#presentWithViewController: for details on the method that will invoke this delegate. \n
 *
 *  @param interstitialAd The ad object that rendered successfully.
 *
 */
- (void) adInterstitialDidRender:(FlurryAdInterstitial*)interstitialAd{
    com_codename1_flurry_Callback_onRendered__(CN1_THREAD_GET_STATE_PASS_SINGLE_ARG);
}

/*!
 *  @brief Invoked when a fullscreen associated with the specified ad will present on the screen.
 *  @since 6.0.0
 *
 *  @param interstitialAd The interstitial ad object that is associated with the full screen that will present.
 *
 */
- (void) adInterstitialWillPresent:(FlurryAdInterstitial*)interstitialAd{
    com_codename1_flurry_Callback_onDisplay__(CN1_THREAD_GET_STATE_PASS_SINGLE_ARG);
}


/*!
 *  @brief Invoked when the ad has been selected that will take the user out of the app.
 *  @since 6.0.0
 *
 *  This method informs the app that an ad has been clicked and the user is about to be taken outside the app.
 *
 *  @param interstitialAd The ad object that received the click.
 *
 */
- (void) adInterstitialWillLeaveApplication:(FlurryAdInterstitial*)interstitialAd{
    com_codename1_flurry_Callback_onAppExit__(CN1_THREAD_GET_STATE_PASS_SINGLE_ARG);
}

/*!
 *  @brief Invoked when a fullscreen associated with the specified ad will be removed.
 *  @since 6.0.0
 *
 *  @param interstitialAd The interstitial ad object that is associated with the full screen that will be dismissed.
 *
 */
- (void) adInterstitialWillDismiss:(FlurryAdInterstitial*)interstitialAd{}

/*!
 *  @brief Invoked when a fullscreen associated with the specified ad has been removed.
 *  @since 6.0.0
 *
 *  @param interstitialAd The interstitial ad object that is associated with the full screen that has been dismissed.
 *
 */
- (void) adInterstitialDidDismiss:(FlurryAdInterstitial*)interstitialAd{
    com_codename1_flurry_Callback_onClose__(CN1_THREAD_GET_STATE_PASS_SINGLE_ARG);
}

/*!
 *  @brief Informational callback invoked when an ad is clicked for the specified @c interstitialAd object.
 *  @since 6.0.0
 *
 *  This method informs the app that an ad has been clicked. This should not be used to adjust state of an app. It is only intended for informational purposes.
 *
 *  @param interstitialAd The ad object that received the click.
 *
 */
- (void) adInterstitialDidReceiveClick:(FlurryAdInterstitial*)interstitialAd{
    com_codename1_flurry_Callback_onClicked__(CN1_THREAD_GET_STATE_PASS_SINGLE_ARG);
}

/*!
 *  @brief Invoked when a video finishes playing
 *  @since 6.0.0
 *
 *  This method informs the app that a video associated with this ad has finished playing.
 *
 *  @param interstitialAd The interstitial ad object that played the video and finished playing the video.
 *
 */
- (void) adInterstitialVideoDidFinish:(FlurryAdInterstitial*)interstitialAd{
    com_codename1_flurry_Callback_onVideoCompleted__(CN1_THREAD_GET_STATE_PASS_SINGLE_ARG);
}

/*!
 *  @brief Informational callback invoked when there is an ad error
 *  @since 6.0
 *
 *  @see FlurryAdError for the possible error reasons.
 *
 *  @param interstitialAd The interstitial ad object associated with the error
 *  @param adError an enum that gives the reason for the error.
 *  @param errorDescription An error object that gives additional information on the cause of the ad error.
 *
 */
- (void) adInterstitial:(FlurryAdInterstitial*) interstitialAd adError:(FlurryAdError) adError errorDescription:(NSError*) errorDescription{
    com_codename1_flurry_Callback_onError___java_lang_String(CN1_THREAD_GET_STATE_PASS_ARG fromNSString(CN1_THREAD_GET_STATE_PASS_ARG [errorDescription localizedDescription]));
}


@end
