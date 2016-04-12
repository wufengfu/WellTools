package com.example.myapplication;

import android.os.Bundle;
import com.example.myapplication.adapter.MyLeftAdapter;
import com.example.myapplication.adapter.MyRightAdapter;
import com.example.myapplication.biz.NetCallBack;
import com.example.myapplication.biz.WellBiz;
import com.example.myapplication.customview.NavListView;
import com.example.myapplication.customview.NestListView;
import com.example.myapplication.entity.CommonData;
import com.example.myapplication.entity.ListData;
import com.example.myapplication.entity.Well;
import com.example.myapplication.utils.LogUtil;
import com.example.myapplication.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class WellListActivity extends BaseActivity implements NetCallBack<CommonData<ListData<Well>>> {

    private NavListView wellList;
    private NestListView leftListView;
    private NestListView rightListView;
    private List<Well> wells;
    WellBiz wellBiz = new WellBiz();
    private MyLeftAdapter<Well> wellMyLeftAdapter;
    private MyRightAdapter<Well> wellMyRightAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_well_list);
        initView();
    }

    private void initView() {
        wellList = (NavListView) findViewById(R.id.wellList);
        List<String> titles = new ArrayList<String>();
        titles.add("机井名称");
        titles.add("机井编号");
        titles.add("ROW");
        titles.add("用户卡号");
        titles.add("时间");
        titles.add("用电量");
        titles.add("用水量");
        titles.add("泵状态");
        titles.add("在线状态");
        titles.add("XX");
        titles.add("orderzt");
        wellList.setTitles(titles);
        wells = new ArrayList<Well>();
        wellBiz.getWellList(this,this,"1","1","20");
//        for(int i =0;i<5;i++){
//            Well well = new Well(i+1,"编号"+1,"机井名称"+i,"用户卡"+i,"2016-04-12",Double.parseDouble(i+1+""),Double.parseDouble(i+1+""),"开泵","在线","1","1");
//            wells.add(well);
//        }
        wellMyLeftAdapter = new MyLeftAdapter<>(this, wells);
        wellMyRightAdapter = new MyRightAdapter<>(this,wells);
        wellList.setAdapter(wellMyLeftAdapter,wellMyRightAdapter);

        leftListView = wellList.getLeftListView();
        rightListView = wellList.getRightListView();

        //如果有详情的话，添加点击事件跳转到详情页。
//        leftListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Well well = wells.get(position);
//                Intent intent = new Intent(this,WellDetialActivity.class);
//                intent.putExtra("land_no",well.getSTCD());
//                startActivity(intent);
//            }
//        });
//        rightListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Well well = wells.get(position);
//                Intent intent = new Intent(this,WellDetialActivity.class);
//                intent.putExtra("land_no",well.getSTCD());
//                startActivity(intent);
//            }
//        });
    }

    @Override
    public void getNetSuccess(int statu, String url, CommonData<ListData<Well>> listDataCommonData) {
        wells.clear();
        wells.addAll(listDataCommonData.getData().getList());
        LogUtil.e("wellListActivity", wells.size());
        System.out.println("wellList size is:"+wells.size());
        wellMyLeftAdapter.notifyDataSetChanged();
        wellMyRightAdapter.notifyDataSetChanged();
    }

    @Override
    public void getNetFauiled(int statu, String url) {
        ToastUtil.toast(this,"获取列表错误");
        LogUtil.e("netFauiled",url);
    }

    @Override
    public void getNetCanceled(int statu, String url) {
        ToastUtil.toast(this,"获取列表错误");
        LogUtil.e("netFauiled",url);
    }

    @Override
    public void getNetError(int statu, String url) {
        ToastUtil.toast(this,"获取列表错误");
        LogUtil.e("netFauiled",url);
    }

    @Override
    public void getNetFinished(int statu, String url) {
        ToastUtil.toast(this,"获取列表错误");
        LogUtil.e("netFauiled",url);
    }
}
