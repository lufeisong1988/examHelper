package com.example.helper;
/**
 * activity帮助类
 */
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class UiHelper {
	public static void IntentActivity(Context mContext,Class<?> cls,Bundle bundle){
		Intent intent = new Intent(mContext,cls);
		Bundle mBundle = null;
		mBundle = bundle;
		intent.putExtras(mBundle);
		mContext.startActivity(intent);
	}
}
