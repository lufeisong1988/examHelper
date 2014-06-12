package com.example.adapter;
/**
 * 总科目适配器
 */
import com.example.examhelper.R;
import com.example.helper.UtilsHelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SubjectAdapter extends BaseAdapter{
	private Context mContext;
	public SubjectAdapter(Context mContext){
		this.mContext = mContext;
	}
	@Override
	public int getCount() {
		return UtilsHelper.subject_name.length;
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
		vh.subject_tv.setText(UtilsHelper.subject_name[position]);
		return convertView;
	}
	class ViewHolder{
		ImageView subject_iv;
		TextView subject_tv;
	}
}
