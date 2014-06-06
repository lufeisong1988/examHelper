package com.example.ui;
/**
 * 2014 6 6
 * 科目分类->单科目类型分类->类型分类详情
 * user jugg
 */
import java.util.ArrayList;
import java.util.HashMap;

import com.example.adapter.MenuAdapter;
import com.example.bean.Catalog;
import com.example.bean.CatalogList;
import com.example.examhelper.R;
import com.example.helper.HttpHelper;
import com.example.helper.UiHelper;
import com.example.utils.HttpPortUtils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	//view
	private ListView menu_lv;
	//adapter
	private MenuAdapter menuDataAdapter;
	//data
	private HashMap<String, ArrayList<Catalog>> getResultData = new HashMap<String, ArrayList<Catalog>>();
	private Handler mHandler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			switch(msg.what){
			case 1:
				if((String)msg.obj != null && !((String)msg.obj).equals("") && !((String)msg.obj).equals("null")){
					getResultData = CatalogList.getCatalogList((String)msg.obj,MainActivity.this);
					menuDataAdapter.notifyDataSetChanged();
				}
				break;
			case 0:
				Toast.makeText(MainActivity.this, "数据为空...", Toast.LENGTH_LONG).show();
				break;
			case -1:
				Toast.makeText(MainActivity.this, "网络连接失败....", Toast.LENGTH_LONG).show();
				break;
			}
			super.handleMessage(msg);
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initData();
		listener();
	} 
	private void initView(){
		menu_lv = (ListView) findViewById(R.id.activity_main_lv);
	}
	private void initData(){
		menuDataAdapter = new MenuAdapter(this, getResultData);
		menu_lv.setAdapter(menuDataAdapter);
		String url = HttpPortUtils.GET_HTTP_SUBJECT + HttpPortUtils.GET_HTTP_SUBJECT_SORT + HttpPortUtils.AppKey;
		HttpHelper.sendHttpGet(mHandler, url, null);
	}
	private void listener(){
		menu_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
				Bundle bundle = new Bundle();
				bundle.putInt("Subject_No", position);
				UiHelper.IntentActivity(MainActivity.this, SubjectActivity.class, bundle);
			}
		});
	}
}
