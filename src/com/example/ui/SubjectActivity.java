package com.example.ui;
/**
 * 2014 6 6
 * 科目分类->单科目类型分类->类型分类详情
 * subject->catalog->item
 * user jugg
 */

import java.util.ArrayList;

import com.example.adapter.SubjectAdapter;
import com.example.bean.CatalogList;
import com.example.bean.ItemList;
import com.example.examhelper.R;
import com.example.helper.AppContext;
import com.example.helper.HttpHelper;
import com.example.helper.UiHelper;
import com.example.helper.UtilsHelper;
import com.example.utils.HttpPortUtils;
import com.example.view.commentDialogUtils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

@SuppressLint("HandlerLeak")
public class SubjectActivity extends Activity implements OnClickListener{
	private ListView menu_lv;
	private SubjectAdapter menuDataAdapter;
	private ArrayList<String> subject_name = new ArrayList<String>();
	//fail layout
	private LinearLayout loadFailView;
	private TextView loadFailView_tv;
	private Button loadFailView_bnt;
	//load layout
	private commentDialogUtils loadView;
	
	private Handler mHandler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			disLoadDialog();
			switch(msg.what){
			case 1:
				loadFailView.setVisibility(View.GONE);
				if((String)msg.obj != null && !((String)msg.obj).equals("") && !((String)msg.obj).equals("null")){
					for(int i = 0;i < UtilsHelper.subject_name.length;i++){
						subject_name.add(UtilsHelper.subject_name[i]);
					}
					CatalogList.getCatalogList((String)msg.obj, SubjectActivity.this);
					menuDataAdapter.notifyDataSetChanged();
				}
				break;
			case 0:
				loadFailView.setVisibility(View.VISIBLE);
				loadFailView_tv.setText(R.string.data_empty);
				break;
			case -1:
				loadFailView.setVisibility(View.VISIBLE);
				loadFailView_tv.setText(R.string.newwork_fail);
				break;
			}
			super.handleMessage(msg);
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.subjectmain);
		initView();
		initData();
		listener();
	} 
	private void initView(){
		menu_lv = (ListView) findViewById(R.id.activity_main_lv);
		
		loadFailView = (LinearLayout) findViewById(R.id.view_load_fail);
		loadFailView_tv = (TextView) findViewById(R.id.view_load_fail_tv);
		loadFailView_bnt = (Button) findViewById(R.id.view_load_fail_bnt);

		loadView = new commentDialogUtils(this, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, R.style.Theme_dialog);
		showLoadDialog();
	}
	private void initData(){
		menuDataAdapter = new SubjectAdapter(this,subject_name);
		menu_lv.setAdapter(menuDataAdapter);
		loadData();
	}
	private void loadData(){
		String url = HttpPortUtils.GET_HTTP_SUBJECT + HttpPortUtils.GET_HTTP_SUBJECT_SORT + HttpPortUtils.AppKey;
		HttpHelper.sendHttpGet(mHandler, url, null);
	}
	private void listener(){
		loadFailView_bnt.setOnClickListener(this);
		menu_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
				Bundle bundle = new Bundle();
				bundle.putInt("Subject_No", position);
				UiHelper.IntentActivity(SubjectActivity.this, CatalogActivity.class, bundle);
			}
		});
	}
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.view_load_fail_bnt:
			loadFailView.setVisibility(View.GONE);
			showLoadDialog();
			loadData();
			break;
		}
	}
	private void showLoadDialog(){
		loadView.show();
		loadView.starAnim();
	}
	private void disLoadDialog(){
		loadView.dismiss();
		loadView.stopAnim();
	}
}
