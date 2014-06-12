package com.example.adapter;

import java.util.ArrayList;

import com.example.bean.Catalog;
import com.example.examhelper.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * 科目 分类适配器
 * @author lufeisong
 *
 */
public class CatalogAdapter extends BaseAdapter{
	private Context mContext;
	private ArrayList<Catalog> data;
	public CatalogAdapter(Context mContext,ArrayList<Catalog> data){
		this.mContext = mContext;
		this.data = data;
	}
	@Override
	public int getCount() {
		return data.size();
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
	public View getView(int position, View convertView, ViewGroup arg2) {
			ViewHolder vh = null;
			if(convertView == null){
				vh = new ViewHolder();
				convertView = LayoutInflater.from(mContext).inflate(R.layout.catalogadapter, null);
				vh.noTv = (TextView) convertView.findViewById(R.id.viewpagerlistviewadapter_id);
				vh.nameTv = (TextView) convertView.findViewById(R.id.viewpagerlistviewadapter_name);
				convertView.setTag(vh); 
			}else{
				vh = (ViewHolder) convertView.getTag();
			}
			vh.noTv.setText(data.get(position).getId() + "");
			vh.nameTv.setText(data.get(position).getCatalog() + "");
			return convertView;
	}
	class ViewHolder{
		TextView noTv;
		TextView nameTv;
	}
}
