package com.example.myapplication.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Acer on 2016/4/10.
 */
public class ListData<T> implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * 显示信息条数
     */
    private String Total;
    /**
     * 在线
     */
    private String InLine;
    /**
     *开泵
     */
    private String PumpOn;
    /**
     * 显示信息集合
     */
    private List<T> List;
    /**
     * 提示信息
     */
    private String Message;
    /**
     * 提示信息代码
     */
    private String Status;

    public ListData(String total, String inLine, String pumpOn, List<T> List, String message, String status) {
        this.Total = total;
        this.InLine = inLine;
        this.PumpOn = pumpOn;
        this.List = List;
        this.Message = message;
        this.Status = status;
    }

    public ListData() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    public String getInLine() {
        return InLine;
    }

    public void setInLine(String inLine) {
        InLine = inLine;
    }

    public String getPumpOn() {
        return PumpOn;
    }

    public void setPumpOn(String pumpOn) {
        PumpOn = pumpOn;
    }

    public List<T> getList() {
        return List;
    }

    public void setList(List<T> List) {
        this.List = List;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "ListData{" +
                "Total='" + Total + '\'' +
                ", InLine='" + InLine + '\'' +
                ", PumpOn='" + PumpOn + '\'' +
                ", List=" + List +
                ", Message='" + Message + '\'' +
                ", Status='" + Status + '\'' +
                '}';
    }
}
