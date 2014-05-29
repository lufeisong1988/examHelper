package com.example.bean;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.helper.HttpHelper;
import com.example.utils.HttpPortUtils;

import android.os.Handler;
import android.widget.BaseAdapter;
import android.widget.ListView;

/**
 * 获取 试题目录（集合）
 * @author lufeisong
 *
 */
public class CatalogList {
	private ArrayList<Catalog> list = new ArrayList<Catalog>();
	private String reason = "";
	public ArrayList<Catalog> getmCatalogList() {
		return list;
	}
	public void setmCatalogList(ArrayList<Catalog> list) {
		this.list = list;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public HashMap<String, CatalogList> getCatalogList(String result){
		HashMap<String, CatalogList> hashData = new HashMap<String, CatalogList>();
		String key = "";
		CatalogList mCatalogList = new CatalogList();
		
		return hashData;
	}
}
