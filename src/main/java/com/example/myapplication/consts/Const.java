package com.example.myapplication.consts;

/**
 * Created by ylz on 2015/11/26.
 */
public class Const {
    /**
     *主机
     */
          public static final String host="http://192.168.3.10:80/Tool/ashx/HttpHandlerApp.ashx?";

    /**
     * 获取服务器
     */
    public static final String getServer_url=host+"Server.do";
    /**
     * 获取项目
     */
    public static final String getProject_url=host+"Project.do";

    /**
     * 用户登记
     */
    public static final String register_url=host+"Register.do";
    /**
     * 机井信息
     */
    public static final String well_url=host+"WeLLList.do";
    /**
     * 开停泵信息
     */
    public static final String switchPump_url=host+"SwitchPump.do";
    /**
     * 刷卡信息
     */
    public static final String stopPump_url=host+"StopPump.do";
    /**
     * 获取序列号
     */
    public static final String getSerial_url=host+"Serial.do";
    /**
     * 增加任务
     */
    public static final String addTask_url=host+"AddTask.do";
    /**
     * 任务列表
     */
    public static final String task_url=host+"TaskList.do";
}

