package com.example.myapplication.entity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.AdapterGetView;

import java.io.Serializable;

/**
 * Created by Lenovo on 2016/4/11.
 */
public class Well extends AdapterGetView implements Serializable{
    /**
     *
     */
    private int Row;

    private String STCD;

    private String Well_Name;

    private String UserCard;

    private String Time;

    private Double UseElectricity;

    private Double UseWater;

    private String ZT;

    private String InLine;

    private String xx;

    private String orderzt;

    public Well() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Well(int row, String STCD, String well_Name, String userCard, String time, Double useElectricity, Double useWater, String ZT, String inLine, String xx, String orderzt) {
        this.Row = row;
        this.STCD = STCD;
        this.Well_Name = well_Name;
        this.UserCard = userCard;
        this.Time = time;
        this.UseElectricity = useElectricity;
        this.UseWater = useWater;
        this.ZT = ZT;
        this.InLine = inLine;
        this.xx = xx;
        this.orderzt = orderzt;
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

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
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

    public String getInLine() {
        return InLine;
    }

    public void setInLine(String inLine) {
        InLine = inLine;
    }

    public String getXx() {
        return xx;
    }

    public void setXx(String xx) {
        this.xx = xx;
    }

    public String getOrderzt() {
        return orderzt;
    }

    public void setOrderzt(String orderzt) {
        this.orderzt = orderzt;
    }

    @Override
    public String toString() {
        return "Well{" +
                "Row=" + Row +
                ", STCD='" + STCD + '\'' +
                ", Well_Name='" + Well_Name + '\'' +
                ", UserCard='" + UserCard + '\'' +
                ", Time='" + Time + '\'' +
                ", UseElectricity=" + UseElectricity +
                ", UseWater=" + UseWater +
                ", ZT='" + ZT + '\'' +
                ", InLine='" + InLine + '\'' +
                ", xx='" + xx + '\'' +
                ", orderzt='" + orderzt + '\'' +
                '}';
    }

    @Override
    public View getStringView(Object object, int position, View convertView, LayoutInflater inflater, Context context) {
        ViewStringHolder vh;
        if (convertView == null) {
            vh = new ViewStringHolder();
            convertView = inflater.inflate(R.layout.layout_left_item, null);
            vh.ltv = (TextView) convertView.findViewById(R.id.left_container_textview0);
            convertView.setTag(vh);
        } else {
            vh = (ViewStringHolder) convertView.getTag();
        }
        Well well = (Well) object;
        vh.ltv.setText(well.getWell_Name());

        return convertView;
    }

    @Override
    public View getView(Object object, int position, View convertView, LayoutInflater inflater, Context context) {
        ViewHolder vh;
        if (convertView == null) {
            vh = new ViewHolder();
            convertView = inflater.inflate(R.layout.layout_pump_right_item, null);
            vh.tv1 = (TextView) convertView.findViewById(R.id.ri1);
            vh.tv2 = (TextView) convertView.findViewById(R.id.ri2);
            vh.tv3 = (TextView) convertView.findViewById(R.id.ri3);
            vh.tv4 = (TextView) convertView.findViewById(R.id.ri4);
            vh.tv5 = (TextView) convertView.findViewById(R.id.ri5);
            vh.tv6 = (TextView) convertView.findViewById(R.id.ri6);
            vh.tv7 = (TextView) convertView.findViewById(R.id.ri7);
            vh.tv8 = (TextView) convertView.findViewById(R.id.ri8);
            vh.tv9 = (TextView) convertView.findViewById(R.id.ri9);
            vh.tv10 = (TextView) convertView.findViewById(R.id.ri10);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        Well well = (Well) object;
        vh.tv1.setText(well.getSTCD());
        vh.tv2.setText(well.getRow()+"");
        vh.tv3.setText(well.getUserCard());
        vh.tv4.setText(well.getTime());
        vh.tv5.setText(well.getUseElectricity()+"");
        vh.tv6.setText(well.getUseWater()+"");
        vh.tv7.setText(well.getZT());
        vh.tv8.setText(well.getInLine());
        vh.tv9.setText(well.getXx());
        vh.tv10.setText(well.getOrderzt());
        vh.tv1.setVisibility(View.VISIBLE);
        vh.tv2.setVisibility(View.VISIBLE);
        vh.tv3.setVisibility(View.VISIBLE);
        vh.tv4.setVisibility(View.VISIBLE);
        vh.tv5.setVisibility(View.VISIBLE);
        vh.tv6.setVisibility(View.VISIBLE);
        vh.tv7.setVisibility(View.VISIBLE);
        vh.tv8.setVisibility(View.VISIBLE);
        vh.tv9.setVisibility(View.VISIBLE);
        vh.tv10.setVisibility(View.VISIBLE);
        return convertView;
    }
    static class ViewStringHolder {
        TextView ltv;
    }

    static class ViewHolder {
        TextView tv1;
        TextView tv2;
        TextView tv3;
        TextView tv4;
        TextView tv5;
        TextView tv6;
        TextView tv7;
        TextView tv8;
        TextView tv9;
        TextView tv10;
    }
}
