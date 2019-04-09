package k.xy.myaspectj;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

public class MyApplication extends Application {

    private static final String TAG = MyApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {


            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

                Log.e(TAG, "onActivityCreated: 浏览页面 "+activity.getLocalClassName() );

            }

            @Override
            public void onActivityPaused(Activity activity) {
                Log.e(TAG, "onActivityPaused: 关闭页面 "+activity.getLocalClassName() );

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }
}
