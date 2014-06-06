package com.example.helper;

import android.os.Environment;

/**
 * 工具类
 * 保存 app常量
 */

public class UtilsHelper {
	public static String SubjectData_File_Save = "SubjectData.cfg";
	//科目分类数组
	public static String[] subject_name = new String[] { "语文", "数学", "英语", "物理",
		"化学", "生物", "历史", "政治", "地理" };
	public static String SAVE_ITEMOBJECT_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/ExamHelper/";//保存 单个科目试题集合的路径
}
