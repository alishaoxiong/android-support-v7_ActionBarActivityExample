package com.example.actionbardemo;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class CollapsibleActionItem extends ActionBarActivity{

	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_collapsibleactionitem);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuItem search=menu.add("search").setIcon(R.drawable.ic_search_inverse);
		/**
		 * menu��ÿ��item����������action view����������ˣ���ô���viewĬ������ʾ�ģ�
		 * ������SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW����Ĭ�ϲ���ʾ.
		 */
		MenuItemCompat.setShowAsAction(search, MenuItemCompat.SHOW_AS_ACTION_IF_ROOM|MenuItemCompat.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);
		View view=getLayoutInflater().inflate(R.layout.layout_edit, null);
		MenuItemCompat.setActionView(search,R.layout.layout_edit);
		return super.onCreateOptionsMenu(menu);
	}
}
