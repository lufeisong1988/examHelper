package com.example.fragment;
/**
 * 单个科目 分页
 */
import com.example.examhelper.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ItemFragment extends Fragment{
	public static ItemFragment newInstance(){
		ItemFragment fg = new ItemFragment();
		Bundle bundle = new Bundle();
		return fg;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.itemfragment, null);
		ListView lv = (ListView) view.findViewById(R.id.itemfragment_lv);
		
		return view;
	}
	
}
