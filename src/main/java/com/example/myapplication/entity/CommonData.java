package com.example.myapplication.entity;

import java.io.Serializable;

public class CommonData<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private T data;
    private String Message;
    private int Status;

    public CommonData() {
        super();
        // TODO Auto-generated constructor stub
    }

    public CommonData(T data, String message, int status) {
        this.data = data;
        this.Message = message;
        this.Status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "CommonData{" +
                "data=" + data +
                ", Message='" + Message + '\'' +
                ", Status=" + Status +
                '}';
    }
}
