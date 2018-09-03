package hms.com.loginformwithmvp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import hms.com.loginformwithmvp.LoginFormApp;

public class ConfigUtils {

    private static final String KEY_EMAIL = "KEY_EMAIL";

    private static ConfigUtils mObjInstance;

    private SharedPreferences mSharedPreferences;

    private ConfigUtils() {
        mSharedPreferences = LoginFormApp.getContext().getSharedPreferences("ConfigUtils", Context.MODE_PRIVATE);
    }

    public static ConfigUtils getInstance() {
        if (mObjInstance == null) {
            mObjInstance = new ConfigUtils();
        }
        return mObjInstance;
    }

    public void saveCurrentUser(String email) {
        mSharedPreferences.edit().putString(KEY_EMAIL, email).apply();
    }

    public String loadCurrentUser() {
        return mSharedPreferences.getString(KEY_EMAIL, "");
    }


}
