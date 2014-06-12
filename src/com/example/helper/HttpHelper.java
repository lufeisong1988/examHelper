package com.example.helper;
/**
 * http 工具类
 * @author lufeisong
 *
 */
import java.util.ArrayList;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.net.AsyncHttpGet;
import com.example.net.AsyncHttpPost;
import com.example.net.DefaultThreadPool;
import com.example.net.RequestParameter;
import com.example.net.RequestResultCallback;


public class HttpHelper {
	
	/*
	 *  1； 请求 数据正常
	 *  0； 请求 数据为空 json解析要注意
	 * －1；请求 数据失败 异常
	 *  
	 */
	public static void sendHttpPost(final Handler mHandler,String url,ArrayList<RequestParameter> parameter){
		final Message msg = new Message();
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
		final Message msg = new Message();
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
	/*
	 * 	获取 科目 类型下 单页面试题
	 */
	public static void itemHttpGet(AppContext ac,String saveFile ,final Handler mHandler,String url,ArrayList<RequestParameter> parameter){
		if(ac.bExistCache(saveFile)){
			Message msg = new Message();
			msg.what = 2;
			mHandler.sendMessage(msg);
		}else{
			sendHttpGet(mHandler,url,parameter);
		}
	}
}
