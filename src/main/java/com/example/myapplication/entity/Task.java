package com.example.myapplication.entity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.example.myapplication.adapter.AdapterGetView;

import java.io.Serializable;

/**
 * Created by Lenovo on 2016/4/11.
 */
public class Task extends AdapterGetView implements Serializable {

    private int Row;
    private float theSer;
    private String STCD;
    private String Well_Name;
    private String TaskType;
    private String Project;
    private String PhoneGUID;
    private String Status;
    private String InDate;

    public Task() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Task(int row, float theSer, String STCD, String well_Name, String taskType, String project, String phoneGUID, String status, String inDate) {
        this.Row = row;
        this.theSer = theSer;
        this.STCD = STCD;
        this.Well_Name = well_Name;
        this.TaskType = taskType;
        this.Project = project;
        this.PhoneGUID = phoneGUID;
        this.Status = status;
        this.InDate = inDate;
    }

    public int getRow() {
        return Row;
    }

    public void setRow(int row) {
        Row = row;
    }

    public float getTheSer() {
        return theSer;
    }

    public void setTheSer(float theSer) {
        this.theSer = theSer;
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

    public String getTaskType() {
        return TaskType;
    }

    public void setTaskType(String taskType) {
        TaskType = taskType;
    }

    public String getProject() {
        return Project;
    }

    public void setProject(String project) {
        Project = project;
    }

    public String getPhoneGUID() {
        return PhoneGUID;
    }

    public void setPhoneGUID(String phoneGUID) {
        PhoneGUID = phoneGUID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getInDate() {
        return InDate;
    }

    public void setInDate(String inDate) {
        InDate = inDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "Row=" + Row +
                ", theSer=" + theSer +
                ", STCD='" + STCD + '\'' +
                ", Well_Name='" + Well_Name + '\'' +
                ", TaskType='" + TaskType + '\'' +
                ", Project='" + Project + '\'' +
                ", PhoneGUID='" + PhoneGUID + '\'' +
                ", Status='" + Status + '\'' +
                ", InDate='" + InDate + '\'' +
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
