package com.example.myapplication.entity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.example.myapplication.adapter.AdapterGetView;

import java.io.Serializable;

/**
 * Created by Acer on 2016/4/9.
 */
public class Project extends AdapterGetView implements Serializable {

    /**
     * 项目ID
     */
    private int ID;
    /**
     * 项目名称
     */
    private String Name;

    public Project() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Project(int ID, String name) {
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
        return "Project{" +
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
