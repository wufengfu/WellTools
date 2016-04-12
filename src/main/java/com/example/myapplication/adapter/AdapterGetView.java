package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by YangLingZhi on 2016/2/22.
 */
public abstract class AdapterGetView {
    public abstract View getStringView(Object object, int position,View convertView, LayoutInflater inflater,Context context) ;
    public abstract View getView(Object object, int position,View convertView, LayoutInflater inflater,Context context);
}
