#import <Foundation/Foundation.h>
#import "FlurryAdInterstitialDelegate.h"

@interface com_codename1_flurry_FlurryNativeImpl : NSObject<FlurryAdInterstitialDelegate> {
    NSString *adID;
}

-(void)logEvent:(NSString*)param param1:(BOOL)param1;
-(void)setAge:(int)param;
-(void)setUserID:(NSString*)param;
-(void)endSession;
-(void)initFlurry:(NSString*)param;
-(BOOL)isAdReady;
-(void)setLogEvents:(BOOL)param;
-(void)displayAd;
-(void)onPageView;
-(void)setGender:(NSString*)param;
-(void)destroyAd;
-(void)fetchAd;
-(void)startSession;
-(void)setAdSpaceName:(NSString*)param;
-(void)endTimedEvent:(NSString*)param;
-(void)setCrashReportingEnabled:(BOOL)param;
-(BOOL)isSupported;
@end
