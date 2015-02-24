#import "com_codename1_flurry_FlurryNativeImpl.h"
#import "Flurry.h"

@implementation com_codename1_flurry_FlurryNativeImpl

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
    [Flurry startSession:param];
}

-(void)endTimedEvent:(NSString*)param{
    [Flurry endTimedEvent:param withParameters:nil]; 
}

-(void)logEvent:(NSString*)param param1:(BOOL)param1{
    [Flurry logEvent:param timed:param1];
}

-(void)setGender:(NSString*)param{
    [Flurry setGender:param]?
}

-(void)setUserID:(NSString*)param{
    [Flurry setUserID:param];
}

-(void)setAge:(int)param{
    [Flurry setAge:param]?
}

-(BOOL)isSupported{
    return YES;
}

@end
