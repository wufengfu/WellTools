package com.example.myapplication.application;

import android.app.Activity;
import android.app.Application;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/2/24.
 */
public class MyApplication extends Application {

    public static boolean isRelease = false;

    /**
     * MyApplication 实例
     */
    public static MyApplication mApplication;
    /**
     * activity 实例集合
     */
    public static List<Activity> listactivity = new ArrayList<Activity>();


    public void finish() {
        if (listactivity != null && listactivity.size() > 0) {
            for (int i = 0; i < listactivity.size(); i++) {
                if (listactivity.get(i) != null) {
                    listactivity.get(i).finish();
                }
            }
        }

    }


    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;

        x.Ext.init(this);
        x.Ext.setDebug(true);

    }
}
