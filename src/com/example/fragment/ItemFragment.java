package com.example.fragment;
/**
 * 单个科目 分页
 */
import java.util.ArrayList;

import com.example.adapter.ItemListViewAdapter;
import com.example.bean.Item;
import com.example.bean.ItemList;
import com.example.examhelper.R;
import com.example.helper.AppContext;
import com.example.helper.HttpHelper;
import com.example.utils.HttpPortUtils;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

@SuppressLint("HandlerLeak")
public class ItemFragment extends Fragment{
	private String id;
	private int position;
	private int pageCount = 30;
	private String saveFile;
	private ArrayList<Item> itemData = new ArrayList<Item>();
	private ItemListViewAdapter adapter;
	private AppContext ac;
	private Handler mHandler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			switch(msg.what){
			case 2://读取缓存
				itemData.addAll(((ItemList) AppContext.getObjectFromSdCard(saveFile)).getItemList());
				adapter.notifyDataSetChanged();
				break;
			case 1://在线读取
				if((String)msg.obj != null && !((String)msg.obj).equals("") && !((String)msg.obj).equals("null")){
					itemData.addAll(AppContext.getItemList((String)msg.obj, saveFile).getItemList()) ;
					adapter.notifyDataSetChanged();
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
		ListView lv = (ListView) view.findViewById(R.id.itemfragment_lv);
		TextView tv = (TextView) view.findViewById(R.id.item_tv);
		tv.setText("this is" + position + "");
		adapter = new ItemListViewAdapter(getActivity(), itemData);
		lv.setAdapter(adapter);
		initData();
		return view;
	}
	private void initData(){
		ac = (AppContext) getActivity().getApplication();
		saveFile = id + "_" + position * pageCount + "_" + pageCount;
		String url = HttpPortUtils.GET_HTTP_ITEM + HttpPortUtils.GET_HTTP_SUBJECT_SORT + HttpPortUtils.AppKey + HttpPortUtils.GET_HTTP_CATALOG_ID + id + HttpPortUtils.GET_HTTP_PN + position * pageCount + HttpPortUtils.GET_HTTP_RN + pageCount + "&dtype=json";
		HttpHelper.itemHttpGet(ac, saveFile, mHandler, url, null);
	}
}
