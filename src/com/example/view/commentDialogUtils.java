package com.example.view;
/**
 * 自定义Dialog类
 */
import com.example.examhelper.R;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class commentDialogUtils extends Dialog {
	private View view;
	private AnimationDrawable anim;
	@SuppressWarnings("deprecation")
	public commentDialogUtils(Context context, int width, int height, int style) {
		super(context, style);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// set content
		setContentView(R.layout.loadingdiaolg);
		view = findViewById(R.id.loading_view);
		anim = (AnimationDrawable) context.getResources().getDrawable(R.drawable.loading_animation_list);
		anim.setOneShot(false);
		view.setBackgroundDrawable(anim);
		// set window params
		Window window = getWindow();
		WindowManager.LayoutParams params = window.getAttributes();

		// set width,height by density and gravity
		float density = getDensity(context);
		params.width = (int) (width * density);
		params.height = (int) (height * density);
		params.gravity = Gravity.CENTER;

		window.setAttributes(params);
	}
	
	public void starAnim() {
		anim.start();
	}

	public void stopAnim() {
		anim.stop();
	}
	private float getDensity(Context context) {
		Resources resources = context.getResources();
		DisplayMetrics dm = resources.getDisplayMetrics();
		return dm.density;
	}

}
