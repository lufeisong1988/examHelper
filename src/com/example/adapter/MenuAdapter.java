package com.example.adapter;
/**
 * 主页适配器
 */
import java.util.ArrayList;
import java.util.HashMap;

import com.example.bean.Catalog;
import com.example.examhelper.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuAdapter extends BaseAdapter{
	private Context mContext;
	private HashMap<String, ArrayList<Catalog>> getResultData;
	private String[] subject_name = new String[] { "语文", "数学", "英语", "物理",
			"化学", "生物", "历史", "政治", "地理" };
	public MenuAdapter(Context mContext,HashMap<String, ArrayList<Catalog>> getResultData){
		this.mContext = mContext;
		this.getResultData = getResultData;
	}
	@Override
	public int getCount() {
		return subject_name.length;
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
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder vh = null;
		if(convertView == null){
			vh = new ViewHolder();
			convertView = LayoutInflater.from(mContext).inflate(R.layout.menuadapter, null);
			vh.subject_iv = (ImageView) convertView.findViewById(R.id.menuadapter_subject_iv);
			vh.subject_tv = (TextView) convertView.findViewById(R.id.menuadapter_subject_tv);
			convertView.setTag(vh);
		}else{
			vh = (ViewHolder) convertView.getTag();
		}
		vh.subject_iv.setBackgroundResource(R.drawable.ic_launcher);
		vh.subject_tv.setText(subject_name[position]);
		return convertView;
	}
	class ViewHolder{
		ImageView subject_iv;
		TextView subject_tv;
	}
}
