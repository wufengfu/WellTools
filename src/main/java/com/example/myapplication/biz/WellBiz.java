package com.example.myapplication.biz;

import android.content.Context;
import android.text.TextUtils;

import com.example.myapplication.consts.Const;
import com.example.myapplication.entity.CommonData;
import com.example.myapplication.entity.ListData;
import com.example.myapplication.entity.Well;
import com.example.myapplication.utils.JsonParserUtil;
import com.example.myapplication.utils.LogUtil;
import com.google.gson.reflect.TypeToken;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;

import java.lang.reflect.Type;

/**
 * Created by NewWater on 2016/4/12.
 */
public class WellBiz extends AbstractNetBiz {

    private Context context;
    private NetCallBack<CommonData<ListData<Well>>> wellNetCallBack;


    public void getWellList(Context context,NetCallBack<CommonData<ListData<Well>>> wellNetCallBack,String project,String page,String pageSize ){
        this.context = context;
        this.wellNetCallBack = wellNetCallBack;

        HttpBiz httpbiz = new HttpBiz();
        httpbiz.setNetConnect(this);
        RequestParams params = new RequestParams(Const.well_url);
        params.addBodyParameter("project",project);
        params.addBodyParameter("page",page);
        params.addBodyParameter("page_size",pageSize);
        httpbiz.connectNet(HttpBiz.POST, params);
    }

    @Override
    public void netSuccess(String url, String result) {
//        LogUtil.e("wellList",result);
        if(!TextUtils.isEmpty(result) && !TextUtils.isEmpty(url)){
            if(Const.well_url.equals(url)){
                Type type = new TypeToken<CommonData<ListData<Well>>>(){}.getType();
                CommonData<ListData<Well>> dataMessage = JsonParserUtil.getObject(result,type);
                if(dataMessage!=null){
                    switch (dataMessage.getStatus()){
                        case 200:
                            if(wellNetCallBack!=null){
                                wellNetCallBack.getNetSuccess(NetCallBack.NET_SUCCESS,url,dataMessage);
                            }
                            break;
                        case 400:
                            if(wellNetCallBack!=null){
                                wellNetCallBack.getNetFauiled(NetCallBack.NET_FAILUED,url);
                            }
                            break;
                        case 500:
                            if(wellNetCallBack!=null){
                                wellNetCallBack.getNetFauiled(NetCallBack.NET_SUCCESS,url);
                            }
                            break;
                    }
                }
            }
        }

    }

    @Override
    public void netCanceled(String url, Callback.CancelledException e) {

    }

    @Override
    public void netError(String url, Throwable ex, boolean b) {

    }

    @Override
    public void netFinished(String url) {

    }
}
