#import "com_codename1_flurry_FlurryNativeImpl.h"
#import "Flurry.h"
#import "FlurryAdInterstitial.h"
#import "FlurryAdInterstitialDelegate.h"
#import "CodenameOne_GLViewController.h"

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
    [Flurry startSession:adID];
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
    return [adInterstitial ready];
}

-(void)setAdSpaceName:(NSString*)param{
    adInterstitial = [[FlurryAdInterstitial alloc]  initWithSpace:param];
}

-(void)fetchAd{
    [adInterstitial fetchAd];
}

-(void)displayAd{
    [adInterstitial presentWithViewControler:[CodenameOne_GLViewController instance]];
}

-(void)destroyAd{
//no ios method in the API
}


-(BOOL)isSupported{
    return YES;
}

@end
