package com.alissoncipriano.festafimdeano.data;

import android.content.Context;
import android.content.SharedPreferences;

public class Data {
    private SharedPreferences mSharedPreferences;

    public Data(Context mContext) {
        //  nome da minha shared preference / se outros apps podem ter acesso a ela ou não
        this.mSharedPreferences = mContext.getSharedPreferences("FestaFimAno", Context.MODE_PRIVATE);
    }

    public void storeString(String key, String value) {
        this.mSharedPreferences.edit().putString(key, value).apply();
    }

    public String getStoredString(String key) {
        return this.mSharedPreferences.getString(key, "");
    }
}
