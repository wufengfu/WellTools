package com.example.myapplication.customview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.MyLeftAdapter;
import com.example.myapplication.adapter.MyRightAdapter;
import com.example.myapplication.pullrefreshloadview.PullToRefreshLayout;
import com.example.myapplication.utils.DensityUtil;
import com.example.myapplication.utils.LogUtil;

import java.util.List;

/**
 * Created by NewWater on 2016/3/2.
 */
public class NavListView extends LinearLayout implements PullToRefreshLayout.OnRefreshListener {

    private Context context;


    private NestListView leftListView;
    private NestListView rightListView;
    private TextView tv_left_title;
    private LinearLayout right_title_container;
    private PullToRefreshLayout pullToRefreshLayout;
    private BaseAdapter leftAdapter;
    private BaseAdapter rightAdapter;

    private List<String> rightTitles;

    public NavListView(Context context) {
        super(context);
        initWithContext(context);
    }

    public NavListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initWithContext(context);
    }

    public NavListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LogUtil.e("初始化布局", "NavListView");
        initWithContext(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public NavListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initWithContext(context);
    }


    private void initWithContext(Context context) {
        this.context = context;
        View view = LayoutInflater.from(context).inflate(R.layout.view_nav_listview, null);

        // 左侧内容区域
        LinearLayout leftContainerView = (LinearLayout) view.findViewById(R.id.left_container);
        // 左侧内容区域背景设置为黄色
        leftContainerView.setBackgroundColor(Color.WHITE);
        // 左侧内容listview
        leftListView = (NestListView) view.findViewById(R.id.left_container_listview);

        // 右侧内容区域
        LinearLayout rightContainerView = (LinearLayout) view.findViewById(R.id.right_container);
        // 右侧内容区域背景设置为灰色
        rightContainerView.setBackgroundColor(Color.WHITE);
        // 右侧内容listview
        rightListView = (NestListView) view.findViewById(R.id.right_container_listview);

        // 右侧  “标题” 水平滑动控件
        SyncHorizontalScrollView titleHorsv = (SyncHorizontalScrollView) view.findViewById(R.id.title_horsv);
        //右侧  “内容”  水平滑动控件
        SyncHorizontalScrollView contentHorsv = (SyncHorizontalScrollView) view.findViewById(R.id.content_horsv);
        // 设置两个水平控件的联动
        titleHorsv.setScrollView(contentHorsv);
        contentHorsv.setScrollView(titleHorsv);

        // 左侧标题textview 控件
        tv_left_title = (TextView) view.findViewById(R.id.tv_left_title);
        // 右侧标题区域
        right_title_container = (LinearLayout) view.findViewById(R.id.right_title_container);

        pullToRefreshLayout = ((PullToRefreshLayout) view.findViewById(R.id.refresh_view));
        pullToRefreshLayout.setOnRefreshListener(this);
//        leftListView.setAdapter(leftAdapter);
//        rightListView.setAdapter(rightAdapter);
        this.addView(view, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

    }

    public void setAdapter(MyLeftAdapter mleftAdapter, MyRightAdapter mrightAdapter) {
        this.leftAdapter = mleftAdapter;
        this.rightAdapter = mrightAdapter;
        leftListView.setAdapter(leftAdapter);
        rightListView.setAdapter(rightAdapter);
//        notifyData();

    }

    public NestListView getLeftListView(){
        return leftListView;
    }
    public NestListView getRightListView(){
        return rightListView;
    }

    /**
     * 设置左右标题
     *
     * @param titles 标题数组，0位左标题，其他为右标题
     */
    public void setTitles(List<String> titles) {
        this.rightTitles = titles;
        if (titles.size() > 0) {
            setLeftTitles(titles.remove(0));
            setRightTitles(titles);
        }
    }

    private void setRightTitles(List<String> rightTitles) {
        right_title_container.removeAllViews();
        for (String s : rightTitles) {
            setRightTitles(s);
        }
    }

    public void setRightTitles(String title) {
        LayoutParams rightparam = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        TextView tv = new TextView(context);
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(DensityUtil.sp2px(context, 9));
        //ToastUtil.toast(context, DensityUtil.sp2px(context, 9)+"");
        tv.setWidth(DensityUtil.dip2px(context, 170));
        int padpix = DensityUtil.dip2px(context, 8);
        tv.setPadding(padpix, padpix, padpix, padpix);
        tv.setText(title);
        right_title_container.addView(tv, rightparam);
    }

    private void setLeftTitles(String title) {
        tv_left_title.setText(title);
    }

    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        if (changeData != null) {
            changeData.onRefresh(pullToRefreshLayout);
        }
    }

    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
        if (changeData != null) {
            changeData.onLoadMore(pullToRefreshLayout);
        }
    }


    public ChangeData changeData;

    public void setChangeData(ChangeData changeData) {
        this.changeData = changeData;
    }

    public interface ChangeData {
        public void onRefresh(PullToRefreshLayout pullToRefreshLayout);

        public void onLoadMore(PullToRefreshLayout pullToRefreshLayout);
    }
}
