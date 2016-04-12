package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.biz.FirstBiz;
import com.example.myapplication.biz.LoginBiz;
import com.example.myapplication.biz.NetCallBack;
import com.example.myapplication.customview.SpinnerPopupWindow;
import com.example.myapplication.entity.ListData;
import com.example.myapplication.entity.Serial;
import com.example.myapplication.entity.Server;
import com.example.myapplication.entity.User;
import com.example.myapplication.utils.ToastUtil;

public class LoginActivity extends BaseActivity implements View.OnClickListener,NetCallBack<ListData<Serial>> {

    private Button btn_configure;
    private SpinnerPopupWindow areaPopupWindow;
    private SpinnerPopupWindow projectPopupWindow;
    private TextView area;
    private TextView project;
    private EditText et_name;
    private EditText et_tell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getserver();
        getproject();
        initview();
        setlistener();
        initdata();
    }

    private void getserver() {
        FirstBiz fbiz = new FirstBiz();
        fbiz.http(this,
                new NetCallBack<ListData<Server>>() {

                    @Override
                    public void getNetSuccess(int statu, String url, ListData<Server> serverListData) {

                    }

                    @Override
                    public void getNetFauiled(int statu, String url) {

                    }

                    @Override
                    public void getNetCanceled(int statu, String url) {

                    }

                    @Override
                    public void getNetError(int statu, String url) {

                    }

                    @Override
                    public void getNetFinished(int statu, String url) {

                    }
                });
    }
    private void getproject() {

    }

    private void initview() {
        et_name = (EditText) findViewById(R.id.et_name);
        et_tell = (EditText) findViewById(R.id.et_tell);
        area = (TextView) findViewById(R.id.tv_area);
        project = (TextView)findViewById(R.id.tv_project);
        btn_configure = (Button) findViewById(R.id.btn_configure);

        areaPopupWindow = new SpinnerPopupWindow(this);
        projectPopupWindow = new SpinnerPopupWindow(this);
    }

    private void setlistener() {
        area.setOnClickListener(this);
        btn_configure.setOnClickListener(this);
    }

    private void initdata() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_area:
                areaPopupWindow.showPopupWindow(area);
                break;
            case R.id.tv_project:
                projectPopupWindow.showPopupWindow(project);
                break;
            case R.id.btn_configure:
                LoginBiz biz = new LoginBiz();
                biz.login(this,
                        et_name.getText().toString().trim(),
                        et_tell.getText().toString().trim(),
                        area.getText().toString().trim(),
                        project.getText().toString().trim(),
                        this
                        );
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }

    @Override
    public void getNetSuccess(int statu, String url, ListData<Serial> serialListData) {
        ToastUtil.toast(this,"恭喜您配置成功");
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }

    @Override
    public void getNetFauiled(int statu, String url) {

    }

    @Override
    public void getNetCanceled(int statu, String url) {

    }

    @Override
    public void getNetError(int statu, String url) {

    }

    @Override
    public void getNetFinished(int statu, String url) {

    }
}
