package com.example.adapter;

import java.util.ArrayList;

import com.example.bean.Item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

/**
 * 单个试题详情适配器
 * @author Administrator
 *
 */
public class ItemExpListViewAdapter extends BaseExpandableListAdapter{
	private Context mContext;
	private ArrayList<Item> itemList;
	public ItemExpListViewAdapter(Context mContext,ArrayList<Item> itemList){
		this.mContext = mContext;
		this.itemList = itemList;
	}
	@Override
	public Object getChild(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getChildId(int arg0, int arg1) {
		return arg1;
	}

	

	@Override
	public int getChildrenCount(int arg0) {
		return 1;
	}

	@Override
	public Object getGroup(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getGroupCount() {
		return itemList.size();
	}

	@Override
	public long getGroupId(int arg0) {
		return arg0;
	}

	
	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		return true;
	}
	
	@Override
	public View getChildView(int arg0, int arg1, boolean arg2, View arg3,ViewGroup arg4) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public View getGroupView(int arg0, boolean arg1, View arg2, ViewGroup arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
