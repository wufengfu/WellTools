package com.example.myapplication.entity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.example.myapplication.adapter.AdapterGetView;

import java.io.Serializable;

/**
 * Created by Lenovo on 2016/4/11.
 */
public class Pump extends AdapterGetView implements Serializable {

    private int Row;
    private String STCD;
    private String Well_Name;
    private String UserCard;
    private String USER_BEGINTIME;
    private String USER_ENDTIME;
    private Double UseElectricity;
    private Double UseWater;
    private String ZT;
    private String Cun_No;
    private String Cun_Name;

    public Pump() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Pump(int row, String STCD, String well_Name, String userCard, String USER_BEGINTIME, String USER_ENDTIME, Double useElectricity, Double useWater, String ZT, String cun_No, String cun_Name) {
        this.Row = row;
        this.STCD = STCD;
        this.Well_Name = well_Name;
        this.UserCard = userCard;
        this.USER_BEGINTIME = USER_BEGINTIME;
        this.USER_ENDTIME = USER_ENDTIME;
        this.UseElectricity = useElectricity;
        this.UseWater = useWater;
        this.ZT = ZT;
        this. Cun_No = cun_No;
        this.Cun_Name = cun_Name;
    }

    public int getRow() {
        return Row;
    }

    public void setRow(int row) {
        Row = row;
    }

    public String getSTCD() {
        return STCD;
    }

    public void setSTCD(String STCD) {
        this.STCD = STCD;
    }

    public String getWell_Name() {
        return Well_Name;
    }

    public void setWell_Name(String well_Name) {
        Well_Name = well_Name;
    }

    public String getUserCard() {
        return UserCard;
    }

    public void setUserCard(String userCard) {
        UserCard = userCard;
    }

    public String getUSER_BEGINTIME() {
        return USER_BEGINTIME;
    }

    public void setUSER_BEGINTIME(String USER_BEGINTIME) {
        this.USER_BEGINTIME = USER_BEGINTIME;
    }

    public String getUSER_ENDTIME() {
        return USER_ENDTIME;
    }

    public void setUSER_ENDTIME(String USER_ENDTIME) {
        this.USER_ENDTIME = USER_ENDTIME;
    }

    public Double getUseElectricity() {
        return UseElectricity;
    }

    public void setUseElectricity(Double useElectricity) {
        UseElectricity = useElectricity;
    }

    public Double getUseWater() {
        return UseWater;
    }

    public void setUseWater(Double useWater) {
        UseWater = useWater;
    }

    public String getZT() {
        return ZT;
    }

    public void setZT(String ZT) {
        this.ZT = ZT;
    }

    public String getCun_No() {
        return Cun_No;
    }

    public void setCun_No(String cun_No) {
        Cun_No = cun_No;
    }

    public String getCun_Name() {
        return Cun_Name;
    }

    public void setCun_Name(String cun_Name) {
        Cun_Name = cun_Name;
    }

    @Override
    public String toString() {
        return "Pump{" +
                "Row=" + Row +
                ", STCD='" + STCD + '\'' +
                ", Well_Name='" + Well_Name + '\'' +
                ", UserCard='" + UserCard + '\'' +
                ", USER_BEGINTIME='" + USER_BEGINTIME + '\'' +
                ", USER_ENDTIME='" + USER_ENDTIME + '\'' +
                ", UseElectricity=" + UseElectricity +
                ", UseWater=" + UseWater +
                ", ZT='" + ZT + '\'' +
                ", Cun_No='" + Cun_No + '\'' +
                ", Cun_Name='" + Cun_Name + '\'' +
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
