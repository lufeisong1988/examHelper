package com.example.helper;
/**
 * 工具类
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.HashMap;
import android.annotation.SuppressLint;
import android.content.Context;
import com.example.bean.Catalog;

public class UtilsHelper {
	public static String SubjectData_File_Save = "SubjectData.cfg";
	//科目分类数组
	public static String[] subject_name = new String[] { "语文", "数学", "英语", "物理",
		"化学", "生物", "历史", "政治", "地理" };
	//保存请求到的大数据到本地file
	@SuppressLint("WorldReadableFiles")
	@SuppressWarnings({ "deprecation", "static-access" })
	public static void saveSubjectDataToFlie(HashMap<String, ArrayList<Catalog>> getResultData, Context mContext){
		try {
			FileOutputStream fos = mContext.openFileOutput(SubjectData_File_Save, mContext.MODE_WORLD_READABLE);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(getResultData);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//获取请求到的大数据从本地
	@SuppressWarnings("unchecked")
	public static HashMap<String, ArrayList<Catalog>> getSubjectDataFromFile(Context mContext){
		HashMap<String, ArrayList<Catalog>> getResultData = null;
		try {
			FileInputStream fis = mContext.openFileInput(SubjectData_File_Save);
			ObjectInputStream ois = new ObjectInputStream(fis);
			getResultData = (HashMap<String, ArrayList<Catalog>>) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (StreamCorruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return getResultData;
	}
}
