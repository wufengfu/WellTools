package com.example.myapplication.entity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.example.myapplication.adapter.AdapterGetView;

import java.io.Serializable;

/**
 * Created by Lenovo on 2016/4/12.
 */
public class Server extends AdapterGetView implements Serializable {

    /**
     * 项目ID
     */
    private int ID;
    /**
     * 项目名称
     */
    private String Name;

    public Server() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Server(int ID, String name) {
        this.ID = ID;
        this.Name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Server{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                '}';
    }

    @Override
    public View getStringView(Object object, int position, View convertView, LayoutInflater inflater, Context context) {
        return null;
    }

    @Override
    public View getView(Object object, int position, View convertView, LayoutInflater inflater, Context context) {
        return null;
    }
}
