package com.example.myapplication.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;

/**
* @Description:�����Ҳ�Ǵ������ҵĲο�
*/
public class SyncHorizontalScrollView extends HorizontalScrollView {
	
	private View mView;
	
	public SyncHorizontalScrollView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public SyncHorizontalScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
 
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);
		//���ÿؼ������������õ������ľ��룬Ȼ���ô�������viewҲ������ͬ�Ĺ�������
		if(mView!=null) {
			mView.scrollTo(l, t);
		}
	}
	
	/**
	* ���ø���������view
	* @param view
	*/
	public void setScrollView(View view) {
		mView = view;
	}
}