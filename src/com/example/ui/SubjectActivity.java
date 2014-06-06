package com.example.ui;
/**
 * 单个科目 类型分类
 */
import java.util.ArrayList;

import com.example.adapter.ViewPagerListViewAdapter;
import com.example.bean.Catalog;
import com.example.examhelper.R;
import com.example.helper.AppContext;
import com.example.helper.UiHelper;
import com.example.helper.UtilsHelper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class SubjectActivity extends Activity{
	private ListView lv;
	private int position;
	private ViewPagerListViewAdapter adapter;
	private AppContext ac;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.subjectactivity);
		initView();
		initData();
	}
	private void initView(){
		lv = (ListView) findViewById(R.id.subjectactivity_lv);
	}
	@SuppressWarnings("unchecked")
	private void initData(){
		ac = (AppContext) getApplication();
		position = getIntent().getExtras().getInt("Subject_No");
		final ArrayList<Catalog> list_chinese = (ArrayList<Catalog>) ac.getObjectFromFile(UtilsHelper.subject_name[position]);
		adapter = new ViewPagerListViewAdapter(this,list_chinese );
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				String id = list_chinese.get(arg2).getId();
				Bundle bundle = new Bundle();
				bundle.putString("id", id);
				UiHelper.IntentActivity(SubjectActivity.this, ItemActivity.class, bundle);
				
			}
		});
	}
	
}
