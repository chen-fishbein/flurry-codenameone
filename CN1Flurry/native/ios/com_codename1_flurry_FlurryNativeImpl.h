#import <Foundation/Foundation.h>

@interface com_codename1_flurry_FlurryNativeImpl : NSObject {
}

-(void)logEvent:(NSString*)param param1:(BOOL)param1;
-(void)initFlurry:(NSString*)param;
-(void)setAge:(int)param;
-(void)onPageView;
-(void)setLogEvents:(BOOL)param;
-(void)setGender:(NSString*)param;
-(void)setUserID:(NSString*)param;
-(void)setCrashReportingEnabled:(BOOL)param;
-(void)endTimedEvent:(NSString*)param;
-(BOOL)isSupported;
@end
