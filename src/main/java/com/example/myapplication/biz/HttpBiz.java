package com.example.myapplication.biz;

import android.content.Context;

import org.xutils.common.Callback;
import org.xutils.common.Callback.Cancelable;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by 徐帅军 on 2015/11/25.
 */
public class HttpBiz {
    public static final int GET=0;
    public static final int POST=1;
    private Context context;

    public HttpBiz(){}
    public HttpBiz(Context context){
        this.context=context;
    }

    public Cancelable connectNet(int httpmethod,RequestParams params){

        Cancelable cancelalbe=null;
        switch (httpmethod) {
            case GET:
                cancelalbe=getnet(params);
                break;

            case POST:
                cancelalbe=postnet(params);
                break;
        }
        return  cancelalbe;

    }


    /**
     * 通过地址追加方式传参获取信息
     * @param params   网络参数
     *
     */
    private Cancelable getnet(final RequestParams params){





        Cancelable cancelable=x.http().get(params, new Callback.CommonCallback<String>() {


            @Override
            public void onSuccess(String s) {

                 if(netConnect!=null){
                     netConnect.getSuccess(params.getUri(),s);
                 }
            }

            @Override
            public void onCancelled(CancelledException e) {
                if(netConnect!=null){
                    netConnect.getCanelled(params.getUri(),e);
                }
            }

            @Override
            public void onError(Throwable ex, boolean b) {
                if(netConnect!=null){
                    netConnect.getError(params.getUri(), ex, b);
                }
            }

            @Override
            public void onFinished() {
                if(netConnect!=null){
                    netConnect.getFinished(params.getUri());
                }
            }
        });

        return cancelable;
    }

    /**
     * 通过表单方式传参获取信息
     * @param params   网络参数
     *
     */
    private Cancelable postnet(final RequestParams params){

        Cancelable cancelable=x.http().post(params, new Callback.CommonCallback<String>() {


            @Override
            public void onSuccess(String s) {

                if(netConnect!=null){
                    netConnect.getSuccess(params.getUri(),s);
                }
            }

            @Override
            public void onCancelled(CancelledException e) {
                if(netConnect!=null){
                    netConnect.getCanelled(params.getUri(),e);
                }
            }

            @Override
            public void onError(Throwable ex, boolean b) {
                if(netConnect!=null){
                    netConnect.getError(params.getUri(),ex,b);
                }
            }

            @Override
            public void onFinished() {
                if(netConnect!=null){
                    netConnect.getFinished(params.getUri());
                }
            }

        });
        return cancelable;
    }

    /**
     * 声明网络回调接口
     */
    public interface NetConnect{

        /**
         * 成功返回结果
         * @param url     网络地址
         * @param result  返回结果
         */
        void getSuccess(String url, String result);

        /**
         * 取消连接是返回结果
         * @param url  网络地址
         * @param e    取消连接时出现的异常
         */
        void getCanelled(String url, Callback.CancelledException e);

        /**
         * 连接错误时返回结果
         * @param url  网络地址
         * @param ex   连接时出现的错误异常
         * @param b    是否是在回调时出错
         */
        void getError(String url, Throwable ex, boolean b);

        /**
         * 连接结束时调用
         * @param url
         */
        void getFinished(String url);


    }

    /**
     * 网络连接回调接口实例
     */
    private NetConnect netConnect;

    /**
     * 设置网络连接回调接口实例
     * @param mNetConnect  网络连接回调接口实例
     */
    public void setNetConnect(NetConnect mNetConnect){
        netConnect=mNetConnect;
    }


}
