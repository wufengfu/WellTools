package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.example.myapplication.adapter.MyGridAdapter;
import com.example.myapplication.customview.MyGridView;

public class MainActivity extends BaseActivity {

    private MyGridView gridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    private void initview() {
        gridview = (MyGridView) findViewById(R.id.gridview);
        gridview.setAdapter(new MyGridAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Log.e("Number","num"+":"+position);
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this,WellListActivity.class));
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
            }
        });
    }
}
