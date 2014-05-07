package com.example.actionbardemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
/**
 * 该示例主要在AndroidManifest.xml中多加了下面一句：
 * <meta-data android:name="android.support.UI_OPTIONS" android:value="splitActionBarWhenNarrow"/>
 * 大概意思是如果当前显示的屏幕较窄（竖屏情况下）会分开展示（即显示在底部），如果是当前显示的屏幕够宽（横屏）则按
 * 正常样子显示在顶部
 * @author lsx
 *
 */
public class SplitActionItems extends ActionBarActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spliteactionitems);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.actionitem, menu);
		return super.onCreateOptionsMenu(menu);
	}
}
