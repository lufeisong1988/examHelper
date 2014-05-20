package com.example.ui;
/**
 * user jugg
 */
import com.example.examhelper.R;
import com.example.helper.HttpHelper;
import com.example.net.ParseHandler;
import com.example.utils.HttpPortUtils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	private Handler mHandler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			switch(msg.what){
			case 1:
				Log.i("resutl" ,(String)msg.obj);
				break;
			case 0:
				break;
			case -1:
				break;
			}
			super.handleMessage(msg);
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		HttpHelper.sendHttpGet(mHandler, HttpPortUtils.GET_HTTP + HttpPortUtils.GET_HTTP_SORT + HttpPortUtils.AppKey, null);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
