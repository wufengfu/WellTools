package com.example.myapplication.biz;

import android.content.Context;
import android.text.TextUtils;

import com.example.myapplication.consts.Const;
import com.example.myapplication.entity.ListData;
import com.example.myapplication.entity.Serial;
import com.example.myapplication.entity.User;
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
public class LoginBiz extends AbstractNetBiz {

    private Context context;
    private NetCallBack<ListData<Serial>> netcallback;

    public LoginBiz() {
        super();
    }

    /**
     * 注册
     *
     * @param context     上下文
     * @param username    姓名
     * @param telephone   联系方式
     * @param addvcd      服务器地址代码号
     * @param project     项目ID
     * @param netcallback 网络回调实例
     */
    public void login(Context context, String username, String telephone, String addvcd, String project, NetCallBack<ListData<Serial>> netcallback) {
        this.context = context;
        this.netcallback = netcallback;

        HttpBiz httpbiz = new HttpBiz();
        httpbiz.setNetConnect(this);

        RequestParams params = new RequestParams(Const.register_url);
        params.addBodyParameter("uername", username);
        params.addBodyParameter("telephone", telephone);
        params.addBodyParameter("addvcd", addvcd);
        params.addBodyParameter("project", project);

        httpbiz.connectNet(HttpBiz.POST, params);
    }

    @Override
    public void netSuccess(String url, String result) {
        LogUtil.e("登录信息", result);
        if (!TextUtils.isEmpty(url) && Const.register_url.equalsIgnoreCase(url) && !TextUtils.isEmpty(result)) {
            // 获取用户类型
            Type type = new TypeToken<ListData<Serial>>() {
            }.getType();
            // 根据类型返回实体类
            ListData<Serial> datamessage = JsonParserUtil.getObject(result, type);
            if (datamessage != null) {
                switch (Integer.valueOf(datamessage.getStatus())) {
                    case 200://返回成功
                        if (netcallback != null) {
                            netcallback.getNetSuccess(NetCallBack.NET_SUCCESS, url, datamessage);
                        }
                        ToastUtil.toast(context, "恭喜您配置成功！");
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
                        ToastUtil.toast(context,"配置失败");
                        LogUtil.e("配置返回","既不是500，也不是200");
                        break;
                }
            }else{
                LogUtil.e("配置返回解析失败",result);
            }
        }else{
            LogUtil.e("配置返回结果为空",result);
        }
    }

    @Override
    public void netCanceled(String url, Callback.CancelledException e) {
        ToastUtil.toast(context, "1配置失败");
        if(netcallback!=null){
            netcallback.getNetCanceled(NetCallBack.NET_CANCELLED,url);
        }
    }

    @Override
    public void netError(String url, Throwable ex, boolean b) {
        ToastUtil.toast(context, "2配置失败");
        if(netcallback!=null){
            netcallback.getNetError(NetCallBack.NET_ERROR,url);
        }
    }

    @Override
    public void netFinished(String url) {
        ToastUtil.toast(context,"3配置失败");
        if(netcallback!=null){
            netcallback.getNetFinished(NetCallBack.NET_FINISHED,url);
        }
    }
}
