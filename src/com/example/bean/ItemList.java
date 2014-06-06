package com.example.bean;

import java.util.ArrayList;

/**
 * 试题 集合 
 * @author lufeisong
 *
 */
public class ItemList {
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
	

}
