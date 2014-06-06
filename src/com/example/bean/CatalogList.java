package com.example.bean;
/**
 * 获取 试题目录（集合）
 * 
 * @author lufeisong
 * 
 */
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.helper.UtilsHelper;


public class CatalogList{
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

	public static HashMap<String, ArrayList<Catalog>> getCatalogList(String result) {
		HashMap<String, ArrayList<Catalog>> hashData = new HashMap<String, ArrayList<Catalog>>();
		try {
			JSONObject obj = new JSONObject(result);
			JSONObject obj_total = obj.getJSONObject("result");
			for(int i = 0;i < UtilsHelper.subject_name.length;i++){
				JSONArray array = obj_total.getJSONArray(UtilsHelper.subject_name[i]);
				ArrayList<Catalog> list_chinese = new ArrayList<Catalog>();
				for(int j = 0;j < array.length();j++){
					Catalog catalog = new Catalog();
					JSONObject obj_item = array.getJSONObject(j);
					catalog.setId(obj_item.getString("id"));
					catalog.setCatalog(obj_item.getString("catalog"));
					list_chinese.add(catalog);
				}
				hashData.put(UtilsHelper.subject_name[i], list_chinese);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return hashData;
	}
}
