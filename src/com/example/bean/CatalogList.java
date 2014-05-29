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


public class CatalogList {
	private ArrayList<Catalog> list = new ArrayList<Catalog>();
	private String reason = "";
	private static String[] subject = new String[]{
		"语文","数学","英语","物理","化学","生物","历史","政治","地理"
	};
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
			for(int i = 0;i < subject.length;i++){
				JSONArray array = obj_total.getJSONArray(subject[i]);
				ArrayList<Catalog> list_chinese = new ArrayList<Catalog>();
				for(int j = 0;j < array.length();j++){
					Catalog catalog = new Catalog();
					JSONObject obj_item = array.getJSONObject(j);
					catalog.setId(obj_item.getString("id"));
					catalog.setCatalog(obj_item.getString("catalog"));
					list_chinese.add(catalog);
				}
				hashData.put(subject[i], list_chinese);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return hashData;
	}
}
