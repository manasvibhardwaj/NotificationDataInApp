package com.example.manasvi.notificationdatainapp;

import android.content.Context;
import android.content.SharedPreferences;

public class YourPreference {

    private static YourPreference yourPreference;
    private SharedPreferences sharedPreferences;

    public static YourPreference getInstance(Context context) {
        if (yourPreference == null) {
            yourPreference = new YourPreference(context);

        }
        return yourPreference;
    }

    private YourPreference(Context context) {
       sharedPreferences = context.getSharedPreferences("YourPreference",Context.MODE_PRIVATE);
        //sharedPreferences=context.get
    }

    public void saveData(String key,String value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.clear();
//        prefsEditor.commit();
        prefsEditor .putString(key, value.toString()).apply();
        prefsEditor.commit();
    }

    public String getData(String key) {
        if (sharedPreferences!= null) {
            return sharedPreferences.getString(key, "default value");
        }
        return "no value found";
    }
}
