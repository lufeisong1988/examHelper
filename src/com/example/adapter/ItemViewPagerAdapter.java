package com.example.adapter;
/**
 * 每个科目下 单个试题类型适配器
 * viewpager适配器
 * 用来添加fragment
 */
import com.example.fragment.ItemFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ItemViewPagerAdapter extends FragmentStatePagerAdapter{
	private String id;
	public ItemViewPagerAdapter(FragmentManager fm,String id) {
		super(fm);
		this.id = id;
	}

	@Override
	public Fragment getItem(int arg0) {
		return ItemFragment.newInstance(id,arg0);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
