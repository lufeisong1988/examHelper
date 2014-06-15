package com.example.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import com.example.bean.Item;
import com.example.examhelper.R;
import com.example.view.CollapsibleTextView;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView.BufferType;

@SuppressLint("UseSparseArrays")
public class ItemListViewAdapter extends BaseAdapter{
	private Context mContext;
	private ArrayList<Item> itemList;
	private HashMap<Integer, Integer> map = null;
	public ItemListViewAdapter(Context mContext,ArrayList<Item> itemList){
		this.mContext = mContext;
		this.itemList = itemList;
		map = new HashMap<Integer, Integer>();
	}
	@Override
	public int getCount() {
		return itemList.size();
	}

	@Override
	public Object getItem(int arg0) {
		return arg0;
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		ViewHolder vh = null;
		if(arg1 == null){
			vh = new ViewHolder();
			arg1 = LayoutInflater.from(mContext).inflate(R.layout.itemgroup,null);
			vh.queTv = (CollapsibleTextView) arg1.findViewById(R.id.question);
			arg1.setTag(vh);
		}else{
			vh = (ViewHolder) arg1.getTag();
		}
		Item item = itemList.get(arg0);
		String queStr = itemList.get(arg0).getQuestion().toString().replace("&nbsp;", "");
		vh.queTv.setDesc(queStr,item, BufferType.NORMAL, map, arg0);
		vh.queTv.setOnClickListener(descOpClickListener(queStr,item,vh.queTv,arg0));
		return arg1;
	}
	class ViewHolder{
		CollapsibleTextView queTv;
	}
	private View.OnClickListener descOpClickListener(final CharSequence charSequence,final Item item,final CollapsibleTextView queTv,final int position){
		return new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				if(map.get(position)==1){
					map.put(position, 2);
				} else if(map.get(position)==2){
					map.put(position, 1);
				}
				queTv.setDesc(charSequence, item,BufferType.NORMAL, map, position);
			}
			
		};
	}
}
