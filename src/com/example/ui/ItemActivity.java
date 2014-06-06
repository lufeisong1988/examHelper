package com.example.ui;
/**
 * 每个试题科目页面
 */
import com.example.examhelper.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.ListView;

public class ItemActivity extends Activity{
	private ViewPager itemVP;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.itemactivity);
		initView();
	}
	private void initView(){
		itemVP = (ViewPager) findViewById(R.id.itemactivity_vp);
	}
	
}
