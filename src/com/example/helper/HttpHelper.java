package com.example.helper;

import java.util.ArrayList;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.net.AsyncHttpGet;
import com.example.net.AsyncHttpPost;
import com.example.net.DefaultThreadPool;
import com.example.net.RequestParameter;
import com.example.net.RequestResultCallback;

/**
 * http 工具类
 * @author lufeisong
 *
 */
public class HttpHelper {
	static Message msg = new Message();
	/*
	 *  1； 请求 数据正常
	 *  0； 请求 数据为空 json解析要注意
	 * －1；请求 数据失败 异常
	 *  
	 */
	public static void sendHttpPost(final Handler mHandler,String url,ArrayList<RequestParameter> parameter){
		
		AsyncHttpPost post = new AsyncHttpPost(null, url, parameter, new RequestResultCallback() {
			
			@Override
			public void onSuccess(Object o) {
				String result = (String) o;
				if(result != null && !result.equals("")){
					msg.what = 1;
					msg.obj = result;
					mHandler.sendMessage(msg);
				}else{
					msg.what = 0;
					mHandler.sendMessage(msg);
				}
			}
			
			@Override
			public void onFail(Exception e) {
				msg.what = -1;
				mHandler.sendMessage(msg);
			}
		});
		DefaultThreadPool.getInstance().execute(post);
	}
	public static void sendHttpGet(final Handler mHandler,String url,ArrayList<RequestParameter> parameter){
		Log.i("getUrl",url);
		AsyncHttpGet get = new AsyncHttpGet(null, url, parameter, new RequestResultCallback() {
			
			@Override
			public void onSuccess(Object o) {
				String result = (String) o;
				if(result != null && !result.equals("")){
					msg.what = 1;
					msg.obj = result;
					mHandler.sendMessage(msg);
				}else{
					msg.what = 0;
					mHandler.sendMessage(msg);
				}
			}
			
			@Override
			public void onFail(Exception e) {
				msg.what = -1;
				mHandler.sendMessage(msg);
			}
		});
		DefaultThreadPool.getInstance().execute(get);
	}

	
}
