package com.example.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.bean.Item;
import com.example.examhelper.R;
import com.example.view.CollapsibleTextView;

import android.content.Context;
import android.view.CollapsibleActionView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.TextView.BufferType;

/**
 * 单个试题详情适配器
 * @author Administrator
 *
 */
public class ItemExpListViewAdapter extends BaseExpandableListAdapter{
	private HashMap<Integer, Integer> map;
	private Context mContext;
	private ArrayList<Item> itemList;
	private String[] armTypes = new String[] { "神族", "虫族", "人族" };
	private String[][] arms = new String[][] { { "狂战士", "龙骑士", "黑暗圣堂" },
			{ "小狗", "飞龙", "自爆妃子" }, { "步兵", "伞兵", "护士mm" } };
	public ItemExpListViewAdapter(Context mContext,ArrayList<Item> itemList){
		this.mContext = mContext;
		this.itemList = itemList;
		map = new HashMap<Integer, Integer>();
	}
	@Override
	public Object getChild(int arg0, int arg1) {
		return arms[arg0][arg1];
	}

	@Override
	public long getChildId(int arg0, int arg1) {
		return arg1;
	}

	@Override
	public int getChildrenCount(int arg0) {
		return arms[arg0].length;
	}

	@Override
	public Object getGroup(int arg0) {
		return itemList.get(arg0).getQuestion();
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
		View view = LayoutInflater.from(mContext).inflate(R.layout.itemgroup,null);
		TextView queTv = (TextView) view.findViewById(R.id.question);
		queTv.setText("子类: " + getChild(arg0,arg1).toString());
		return view;
	}
	@Override
	public View getGroupView(int arg0, boolean arg1, View arg2, ViewGroup arg3) {
		View view = LayoutInflater.from(mContext).inflate(R.layout.itemgroup,null);
		CollapsibleTextView queTv = (CollapsibleTextView) view.findViewById(R.id.question);
		queTv.setDesc(getGroup(arg0).toString(), BufferType.NORMAL, map, arg0);
		queTv.setOnClickListener(descOpClickListener(getGroup(arg0).toString(),queTv,arg0));
		return view;
	}
	private View.OnClickListener descOpClickListener(final CharSequence charSequence,final CollapsibleTextView queTv,final int position){
		return new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				if(map.get(position)==1){
					map.put(position, 2);
				} else if(map.get(position)==2){
					map.put(position, 1);
				}
				queTv.setDesc(charSequence, BufferType.NORMAL, map, position);
			}
			
		};
	}
}
