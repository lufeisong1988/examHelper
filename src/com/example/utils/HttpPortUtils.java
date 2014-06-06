package com.example.utils;
/**
 * 接口工具类
 * @author lufeisong
 *
 */
public class HttpPortUtils {
	/*
	 * 试题目录
	 * 	名称			类型		必填		说明
 		key			string	是		应用APPKEY(应用详细页查询)
 		dtype		string	否		返回数据的格式,xml或json，默认json
 		
 		接口地址：http://apis.juhe.cn/exam/catalog
		支持格式：JSON/XML
		请求方式：GET
		请求示例：http://apis.juhe.cn/exam/catalog?key=你申请的key&dtype=json

	 */
	/* 试题考题
	 * 	名称			类型		必填		说明
 		key			string	是		应用APPKEY(应用详细页查询)
 		catalog_id	int		是		目录编号
 		pn			int		是		数据返回起始
 		rn			int		是		数据返回条数，最大30
 		dtype		string	否		返回数据的格式,xml或json，默认json
 		
 		接口地址：http://apis.juhe.cn/exam/query
		支持格式：JSON/XML
		请求方式：GET
		请求示例：http://apis.juhe.cn/exam/query?key=你申请的key&catalog_id=880&pn=10&rn=10

	 */
	public static String AppKey = "2e28782d340e9ff7682537d7806dd562";//appkey
	public static String GET_HTTP_SUBJECT = "http://apis.juhe.cn/exam/catalog";//获取试题目录接口
	public static String GET_HTTP_ITEM = "http://apis.juhe.cn/exam/query";//获取试题考题接口
	public static String GET_HTTP_SUBJECT_SORT = "?key=";	//获取试题目录接口 和 试题考题 拼接字段
	public static String GET_HTTP_CATALOG_ID = "&catalog_id=";//试题考题 分类id
	public static String GET_HTTP_PN = "&pn=";//试题考题 pn
	public static String GET_HTTP_RN = "&rn=";//试题考题 rn
}
