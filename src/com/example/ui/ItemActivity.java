package com.example.ui;
/**
 * 每个试题科目页面
 */
import com.example.adapter.ItemViewPagerAdapter;
import com.example.bean.ItemList;
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
	
	private String saveFile;
	private ItemViewPagerAdapter mItemAdapter;
	private FragmentManager fm = getSupportFragmentManager();
	private Handler mHandler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			switch(msg.what){
			case 1://在线读取
				if((String)msg.obj != null && !((String)msg.obj).equals("") && !((String)msg.obj).equals("null")){
					ItemList mItemList = AppContext.getItemList((String)msg.obj, id);
					mItemAdapter.changeCount(Integer.parseInt(mItemList.getTotalNum()) / 30);
					mItemAdapter.notifyDataSetChanged();
				}
				break;
			case 2://读缓存
				ItemList mItemList = (ItemList) AppContext.getObjectFromSdCard(saveFile);
				mItemAdapter.changeCount(Integer.parseInt(mItemList.getTotalNum()) / 30);
				mItemAdapter.notifyDataSetChanged();
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
		initData();
	}
	private void initView(){
		ac = (AppContext) getApplication();
		id = getIntent().getExtras().getString("id");
		
		itemVP = (ViewPager) findViewById(R.id.itemactivity_vp);
		mItemAdapter = new ItemViewPagerAdapter(fm,id);
		mItemAdapter.changeCount(0);
		itemVP.setAdapter(mItemAdapter);
	}
	private void initData(){
		String url = HttpPortUtils.GET_HTTP_ITEM + HttpPortUtils.GET_HTTP_SUBJECT_SORT + HttpPortUtils.AppKey + HttpPortUtils.GET_HTTP_CATALOG_ID + id + HttpPortUtils.GET_HTTP_PN + "0" + HttpPortUtils.GET_HTTP_RN + "30" + "&dtype=json";
		saveFile = id + "_" + "0" + "_" + "30";
		HttpHelper.itemHttpGet(ac, saveFile, mHandler, url, null);
	}
}
