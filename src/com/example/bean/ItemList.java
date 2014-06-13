package com.example.bean;

import java.io.Serializable;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * 试题 集合 
 * @author lufeisong
 *
 */
@SuppressWarnings("serial")
public class ItemList implements Serializable{
	private String totalNum;
	private String pn;
	private String rn;
	private ArrayList<Item> itemList = new ArrayList<Item>();
	public String getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}
	public String getPn() {
		return pn;
	}
	public void setPn(String pn) {
		this.pn = pn;
	}
	public String getRn() {
		return rn;
	}
	public void setRn(String rn) {
		this.rn = rn;
	}
	public ArrayList<Item> getItemList() {
		return itemList;
	}
	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}
	public static ItemList getItemList(String result){
		ItemList mItemList = new ItemList();
		ArrayList<Item> itemList = new ArrayList<Item>();
		try {
			JSONObject obj = new JSONObject(result);
			String dataResult = obj.getString("result");
			JSONObject objData = new JSONObject(dataResult);
			mItemList.setPn(objData.getString("pn"));
			mItemList.setRn(objData.getString("rn"));
			mItemList.setTotalNum(objData.getString("totalNum"));
			JSONArray array = objData.getJSONArray("data");
			for(int i = 0;i < array.length();i++){
				Item mItem = new Item();
				JSONObject objItem = array.getJSONObject(i);
				mItem.setId(objItem.getString("id"));
				mItem.setSubjectName(objItem.getString("subjectName"));
				mItem.setKnowledge(objItem.getString("knowledge"));
				mItem.setSourcename(objItem.getString("sourcename"));
				mItem.setQuestionTypes(objItem.getString("questionTypes"));
				mItem.setQuestionDifficulty(objItem.getString("questionDifficulty"));
				mItem.setQuestion(objItem.getString("question"));
				mItem.setAnswer(objItem.getString("answer"));
				mItem.setResolve(objItem.getString("resolve"));
				itemList.add(mItem);
			}
			mItemList.setItemList(itemList);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return mItemList;
	}
	
}
