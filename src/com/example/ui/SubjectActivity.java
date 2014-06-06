package com.example.ui;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.adapter.ViewPagerListViewAdapter;
import com.example.bean.Catalog;
import com.example.examhelper.R;
import com.example.helper.UtilsHelper;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class SubjectActivity extends Activity{
	private ListView lv;
	private HashMap<String, ArrayList<Catalog>> data;
	private ViewPagerListViewAdapter adapter;
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
	private void initData(){
		data = (HashMap<String, ArrayList<Catalog>>) getIntent().getExtras().getSerializable("subject_name");
		adapter = new ViewPagerListViewAdapter(this, data.get(UtilsHelper.subject_name[1]));
		lv.setAdapter(adapter);
	}
	
}
