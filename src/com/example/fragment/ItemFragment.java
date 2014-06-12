package com.example.fragment;
/**
 * 单个科目 分页
 */
import java.util.ArrayList;

import com.example.bean.Item;
import com.example.bean.ItemList;
import com.example.examhelper.R;
import com.example.helper.AppContext;
import com.example.helper.HttpHelper;
import com.example.utils.HttpPortUtils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ListView;

public class ItemFragment extends Fragment{
	private String id;
	private int position;
	private int pageCount = 30;
	private String saveFile;
	private ArrayList<Item> itemData = new ArrayList<Item>();
	private Handler mHandler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			switch(msg.what){
			case 2://读取缓存
				break;
			case 1://在线读取
				if((String)msg.obj != null && !((String)msg.obj).equals("") && !((String)msg.obj).equals("null")){
					itemData = AppContext.getItemList((String)msg.obj, saveFile).getItemList();;
				}
				break;
			case 0:
				break;
			case -1:
				break;
			}
			super.handleMessage(msg);
		}
	};
	public static ItemFragment newInstance(String id,int position){
		ItemFragment fg = new ItemFragment();
		Bundle bundle = new Bundle();
		bundle.putString("id", id);
		bundle.putInt("position", position);
		fg.setArguments(bundle);
		return fg;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		id = getArguments() != null ? getArguments().getString("id") : "";
		position = getArguments() != null ? getArguments().getInt("position") : 0;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.itemfragment, null);
		ExpandableListView lv = (ExpandableListView) view.findViewById(R.id.itemfragment_lv);
		initData();
		return view;
	}
	private void initData(){
		saveFile = id + "_" + position * pageCount + "_" + pageCount;
		String url = HttpPortUtils.GET_HTTP_ITEM + HttpPortUtils.GET_HTTP_SUBJECT_SORT + HttpPortUtils.AppKey + HttpPortUtils.GET_HTTP_CATALOG_ID + id + HttpPortUtils.GET_HTTP_PN + position * pageCount + HttpPortUtils.GET_HTTP_RN + pageCount;
		HttpHelper.sendHttpGet(mHandler,url , null);
	}
}
