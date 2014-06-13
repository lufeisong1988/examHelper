package com.example.helper;
/**
 * application工具类 保存全局变量
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;

import com.example.bean.ItemList;

import android.app.Application;
import android.os.Environment;

public class AppContext extends Application{

	@Override
	public void onCreate() {
		super.onCreate();
	}
	//TODO
	/*	subject and catalog
	 * 	
	 * 目录为 data/data/包名
	 */
	//保存对象 
	public void setObjectToFile(Serializable ser,String file){
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = openFileOutput(file, MODE_PRIVATE);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(ser);
			oos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fos.close();
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//读取对象 
	public Serializable getObjectFromFile(String file){
		if(!fileExist(file))
			return null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = openFileInput(file);
			ois = new ObjectInputStream(fis);
			return (Serializable) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (StreamCorruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	catch(Exception e){
			//反序列化失败 
			if(e instanceof InvalidClassException){
				File data = getFileStreamPath(file);
				data.delete();
			}
		}finally{
			try {
				fis.close();
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	//判断 读取对象的文件路径是否存在
	private boolean fileExist(String file) {
		boolean bExist = false;
		File data = getFileStreamPath(file);
		if (data.exists())
			bExist = true;
		return bExist;
	}
	//TODO
	/*item
	 * 路径为 sdcard
	 */
	//保存文件
	public static void setObjectToSdCard(Serializable ser,String file){
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		if(sdCardFileExist()){
			File saveFile = new File(UtilsHelper.SAVE_ITEMOBJECT_PATH,file);
			try {
				fos = new FileOutputStream(saveFile);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(ser);
				oos.flush();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					fos.close();
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	//获取文件
	public static Serializable getObjectFromSdCard(String file){
		File rootFile = new File(UtilsHelper.SAVE_ITEMOBJECT_PATH,file);
		if(!rootFile.exists())
			return null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(rootFile);
			ois = new ObjectInputStream(fis);
			return (Serializable) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (StreamCorruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				fis.close();
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	//保存文件时创建文件夹
	private static boolean sdCardFileExist(){
		if(!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
			return false;
		File saveFile = new File(UtilsHelper.SAVE_ITEMOBJECT_PATH);
		if(!saveFile.exists())
			saveFile.mkdirs();
		return true;
	}
	//在线读取 ，并保存到sdcard缓存
	public static ItemList getItemList(String result,String file){
		ItemList mItemList = null;
		mItemList = ItemList.getItemList(result);
		setObjectToSdCard(mItemList,file);
		return mItemList;
	}
	//判断缓存是否存在
	public boolean bExistCache(String file) {
		boolean bExist = false;
		File rootFile = new File(UtilsHelper.SAVE_ITEMOBJECT_PATH, file);
		if (rootFile.exists())
			bExist = true;
		return bExist;
	}
}
