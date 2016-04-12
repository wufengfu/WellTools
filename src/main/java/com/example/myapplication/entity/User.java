package com.example.myapplication.entity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.example.myapplication.adapter.AdapterGetView;

import java.io.Serializable;

/**
 * Created by Acer on 2016/4/9.
 */
public class User extends AdapterGetView implements Serializable {

    /**
     * 姓名
     */
    private String username;
    /**
     * 联系方式
     */
    private String telephone;
    /**
     * 服务器地址代码号
     */
    private String addvcd;
    /**
     * 项目ID
     */
    private String project;

    public User(String username, String telephone, String addvcd, String project) {
        this.username = username;
        this.telephone = telephone;
        this.addvcd = addvcd;
        this.project = project;
    }

    public User() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddvcd() {
        return addvcd;
    }

    public void setAddvcd(String addvcd) {
        this.addvcd = addvcd;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", telephone='" + telephone + '\'' +
                ", addvcd='" + addvcd + '\'' +
                ", project='" + project + '\'' +
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
