package com.example.adapter;
/**
 * 每个科目下 单个试题类型适配器
 */
import com.example.fragment.ItemFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ItemAdapter extends FragmentStatePagerAdapter{

	public ItemAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int arg0) {
		return ItemFragment.newInstance();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
