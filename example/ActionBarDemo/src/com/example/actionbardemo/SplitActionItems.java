package com.example.actionbardemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
/**
 * ��ʾ����Ҫ��AndroidManifest.xml�ж��������һ�䣺
 * <meta-data android:name="android.support.UI_OPTIONS" android:value="splitActionBarWhenNarrow"/>
 * �����˼�������ǰ��ʾ����Ļ��խ����������£���ֿ�չʾ������ʾ�ڵײ���������ǵ�ǰ��ʾ����Ļ������������
 * ����������ʾ�ڶ���
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
