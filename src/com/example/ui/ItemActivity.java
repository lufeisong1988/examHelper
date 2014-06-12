package com.example.ui;
/**
 * 每个试题科目页面
 */
import com.example.adapter.ItemViewPagerAdapter;
import com.example.examhelper.R;
import com.example.helper.AppContext;
import com.example.helper.HttpHelper;
import com.example.utils.HttpPortUtils;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

@SuppressLint("HandlerLeak")
public class ItemActivity extends FragmentActivity{
	private ViewPager itemVP;
	private String id;
	private AppContext ac;
	
	private ItemViewPagerAdapter mItemAdapter;
	private FragmentManager fm = getSupportFragmentManager();
	private int size = 0;
	private Handler mHandler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			switch(msg.what){
			case 1:
				if((String)msg.obj != null && !((String)msg.obj).equals("") && !((String)msg.obj).equals("null")){
//					AppContext.getItemList((String)msg.obj, id);
				}
				break;
			case 0:
				Toast.makeText(ItemActivity.this, "数据为空...", Toast.LENGTH_LONG).show();
				break;
			case -1:
				Toast.makeText(ItemActivity.this, "网络连接失败....", Toast.LENGTH_LONG).show();
				break;
			}
			super.handleMessage(msg);
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.itemactivity);
		initView();
//		initData();
	}
	private void initView(){
		ac = (AppContext) getApplication();
		id = getIntent().getExtras().getString("id");
		
		itemVP = (ViewPager) findViewById(R.id.itemactivity_vp);
		mItemAdapter = new ItemViewPagerAdapter(fm,id);
		itemVP.setAdapter(mItemAdapter);
	}
//	private void initData(){
//		
//		String url = HttpPortUtils.GET_HTTP_ITEM + HttpPortUtils.GET_HTTP_SUBJECT_SORT + HttpPortUtils.AppKey + HttpPortUtils.GET_HTTP_CATALOG_ID + id + HttpPortUtils.GET_HTTP_PN + "0" + HttpPortUtils.GET_HTTP_RN + "30";
//		HttpHelper.sendHttpGet(mHandler,url , null);
//	}
}
