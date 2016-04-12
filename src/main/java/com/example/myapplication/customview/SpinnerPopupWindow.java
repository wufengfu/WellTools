package com.example.myapplication.customview;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.example.myapplication.R;


/**
 * Created by NewWater on 2016/3/4.
 */
public class SpinnerPopupWindow extends PopupWindow {
    private View contentView;
    private ListView listView;

    public SpinnerPopupWindow(Activity context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        contentView = inflater.inflate(R.layout.popup_window_list,null);
        int h = context.getWindowManager().getDefaultDisplay().getHeight();
        int w = context.getWindowManager().getDefaultDisplay().getWidth();
        // 设置SelectPicPopupWindow的View
        this.setContentView(contentView);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(w / 2 + 100);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        // 刷新状态
        this.update();
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xff000000);
        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        this.setBackgroundDrawable(dw);
        // mPopupWindow.setAnimationStyle(android.R.style.Animation_Dialog);
        // 设置SelectPicPopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.AnimationPreview);
       //TODO listview的初始化
        listView = (ListView) contentView.findViewById(R.id.popup_list);
    }

    /**
     * 为listView设置item点击事件
     * @param listItemClickListener
     */
    public void setListItemClickListener(AdapterView.OnItemClickListener listItemClickListener){
        listView.setOnItemClickListener(listItemClickListener);
    }
    public void setAdapter(BaseAdapter adapter){
        listView.setAdapter(adapter);
    }
    /**
     * 显示popupWindow
     *
     * @param parent
     */
    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            // 以下拉方式显示popupwindow
            this.showAsDropDown(parent, parent.getLayoutParams().width / 2, 5);
            //this.showAtLocation(parent, Gravity.CENTER,500,500);
//            LogUtil.e("showpopwindow", "离左侧位置：" + (parent.getLayoutParams().width / 2));
        } else {
            this.dismiss();
        }
    }
}
