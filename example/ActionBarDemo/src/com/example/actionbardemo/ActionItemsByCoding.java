package com.example.actionbardemo;

import android.R;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuItem;
/**
 * ��򵥵�ActionBarʵ��
 * ActionBar��ʵ�������ַ�ʽ��
 * һ������ʵ��,����ActionItemsByCoding����
 * ����xml�����ļ�ʵ�֣�����ActionItemsByXML����
 * @author lsx
 *
 */
public class ActionItemsByCoding extends ActionBarActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_actionitems);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuItem saveItem=menu.add("save").setIcon(R.drawable.ic_compose_inverse);
		MenuItemCompat.setShowAsAction(saveItem, MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
		
		MenuItem search=menu.add("search");
		MenuItemCompat.setShowAsAction(search, MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
		
		MenuItem refresh=menu.add("refresh").setIcon(R.drawable.ic_refresh_inverse);
		MenuItemCompat.setShowAsAction(refresh, MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
				
		return true;//����true����ʾ,false����ʾ
	}
}
