package hms.com.loginformwithmvp;

import android.app.Application;
import android.content.Context;

public class LoginFormApp extends Application {

    public static final String TAG = LoginFormApp.class.getName();
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }

}
