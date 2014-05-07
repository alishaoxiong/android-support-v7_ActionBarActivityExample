package com.example.actionbardemo;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.Toast;
/**
 * 该示例主要是说明actionbar可以和contextMenu一起使用
 * 需要注意的是别搞混了。
 * @author lsx
 *
 */
public class ContextMenuDemo extends ActionBarActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contextmenudemo);
		registerForContextMenu(findViewById(R.id.contextMenuDemo_btn_longPress));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuItem refresh=menu.add("refresh").setIcon(R.drawable.ic_refresh_inverse);
		MenuItemCompat.setShowAsAction(refresh, MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		Toast.makeText(this, ""+item, Toast.LENGTH_LONG).show();
		return super.onContextItemSelected(item);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		menu.add("10");
		menu.add("12");
		menu.add("13");
		menu.add("14");
		super.onCreateContextMenu(menu, v, menuInfo);
	}
}
