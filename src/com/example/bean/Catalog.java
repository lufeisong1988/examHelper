package com.example.bean;

import java.io.Serializable;

/**
 * 获取 试题目录（单个）
 * @author lufeisong
 *
 */
public class Catalog implements Serializable{
	private String id = "";
	private String catalog = "";
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCatalog() {
		return catalog;
	}
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
}
