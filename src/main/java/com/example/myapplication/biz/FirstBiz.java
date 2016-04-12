package com.example.myapplication.biz;

import android.content.Context;
import android.text.TextUtils;

import com.example.myapplication.consts.Const;
import com.example.myapplication.entity.CommonData;
import com.example.myapplication.entity.ListData;
import com.example.myapplication.entity.Server;
import com.example.myapplication.utils.JsonParserUtil;
import com.example.myapplication.utils.LogUtil;
import com.example.myapplication.utils.ToastUtil;
import com.google.gson.reflect.TypeToken;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;

import java.lang.reflect.Type;

/**
 * Created by Lenovo on 2016/4/12.
 */
public class FirstBiz extends AbstractNetBiz{

    private Context context;
    private NetCallBack<ListData<Server>> netcallback;

    public FirstBiz() {
        super();
    }

    /**
     * 注册
     * @param context     上下文
     * @param netcallback 网络回调实例
     */

    public void http(Context context, NetCallBack<ListData<Server>> netcallback){
        this.context = context;
        this.netcallback = netcallback;

        HttpBiz httpbiz = new HttpBiz();
        httpbiz.setNetConnect(this);

        RequestParams params = new RequestParams(Const.getServer_url);
        httpbiz.connectNet(HttpBiz.POST, params);
    }

    @Override
    public void netSuccess(String url, String result) {
        LogUtil.e("获取信息", result);
        if (!TextUtils.isEmpty(url) && Const.register_url.equalsIgnoreCase(url) && !TextUtils.isEmpty(result)) {
            // 获取用户类型
            Type type = new TypeToken<ListData<Server>>() {
            }.getType();
            // 根据类型返回实体类
            ListData<Server> datamessage = JsonParserUtil.getObject(result, type);
            if(datamessage !=null){
                switch (Integer.valueOf(datamessage.getStatus())){
                    case 200://返回成功
                        if (netcallback != null) {
                            netcallback.getNetSuccess(NetCallBack.NET_SUCCESS, url, datamessage);
                        }
                        ToastUtil.toast(context, "恭喜您获取成功！");
                        break;
                    case 400://返回失败
                        if (netcallback != null) {
                            netcallback.getNetFauiled(NetCallBack.NET_FAILUED, url);
                        }
                        ToastUtil.toast(context,"数据返回错误！");
                        break;
                    case 500://返回异常
                        if(netcallback !=null) {
                            netcallback.getNetError(NetCallBack.NET_ERROR,url);
                        }
                        ToastUtil.toast(context,"网络错误！");
                        break;
                    default:
                        ToastUtil.toast(context,"获取失败");
                        LogUtil.e("获取返回","既不是500，也不是200");
                        break;
                }
            }else{
                LogUtil.e("获取返回解析失败",result);
            }
        }else{
            LogUtil.e("获取返回结果为空",result);
        }
    }

    @Override
    public void netCanceled(String url, Callback.CancelledException e) {
        ToastUtil.toast(context, "1获取失败");
        if(netcallback!=null){
            netcallback.getNetCanceled(NetCallBack.NET_CANCELLED,url);
        }
    }

    @Override
    public void netError(String url, Throwable ex, boolean b) {
        ToastUtil.toast(context, "2获取失败");
        if(netcallback!=null){
            netcallback.getNetError(NetCallBack.NET_ERROR,url);
        }
    }

    @Override
    public void netFinished(String url) {
        ToastUtil.toast(context,"3获取失败");
        if(netcallback!=null){
            netcallback.getNetFinished(NetCallBack.NET_FINISHED,url);
        }
    }
}
