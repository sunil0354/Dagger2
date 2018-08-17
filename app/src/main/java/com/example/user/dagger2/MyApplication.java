package com.example.user.dagger2;

import android.app.Application;

import com.example.user.dagger2.dagger.ApiComponent;
import com.example.user.dagger2.dagger.ApiModule;
import com.example.user.dagger2.dagger.AppModule;
import com.example.user.dagger2.dagger.DaggerApiComponent;

public class MyApplication extends Application {
    private ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApiComponent = DaggerApiComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule("https://simplifiedcoding.net/demos/"))
                .build();
    }

    public ApiComponent getNetComponent() {
        return mApiComponent;
    }
}
