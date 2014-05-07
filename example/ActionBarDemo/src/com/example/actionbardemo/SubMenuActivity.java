package com.example.actionbardemo;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
/**
 * 带子菜单的actionBar
 * @author lsx
 *
 */
public class SubMenuActivity extends ActionBarActivity{

	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_submenu);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		SubMenu operation1=menu.addSubMenu("operation1");
		operation1.add("1");
		operation1.add("2");
		operation1.add("3");
		
		MenuItem menuItem=operation1.getItem();
		menuItem.setIcon(getResources().getDrawable(R.drawable.ic_compose_inverse));
		MenuItemCompat.setShowAsAction(menuItem, MenuItemCompat.SHOW_AS_ACTION_ALWAYS);
		
		SubMenu operation2=menu.addSubMenu("operation2");
		operation2.add("1");
		operation2.add("2");
		operation2.add("3");
		
		MenuItem menuItem2=operation2.getItem();
		menuItem2.setIcon(getResources().getDrawable(R.drawable.ic_compose_inverse));
		return super.onCreateOptionsMenu(menu);
	}
}
