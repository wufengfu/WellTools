package com.example.myapplication.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public class DialogUtil {
	/**
	 * 创建自定义Dialog
	 * @param context 上下文环境
	 * @param resource dialog中的布局文件R.layout.xxx
	 * @param style dialog样式
	 * @param v  可为null
	 * @return dialog  返回一个类型为 Dialog 的对话框
	 */
	public static Dialog createDialog(Context context,int resource,int style,View v){
		Dialog dialog=null;
		if(style==-1){
			dialog =new Dialog(context);
		}else{
			dialog = new Dialog(context, style);
		}

		View dialogview = LayoutInflater.from(context).inflate(resource, null);
		//设置它的ContentView
		dialog.setContentView(dialogview);
		dialog.show();
		return dialog;
	}


	public static void dilogDismiss(Dialog dialog){
		if(dialog!=null){
			dialog.dismiss();
		}
	}

}
