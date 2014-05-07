package com.example.actionbardemo;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
/**
 * 下拉列表样式的actionBar
 * @author lsx
 *
 */
public class ListNavigation extends ActionBarActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listnavigation);
		String[] locations=getResources().getStringArray(R.array.locations);
		ArrayAdapter adapter=ArrayAdapter.createFromResource(this, R.array.locations, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
		getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		getSupportActionBar().setListNavigationCallbacks(adapter, null);
	}
}
