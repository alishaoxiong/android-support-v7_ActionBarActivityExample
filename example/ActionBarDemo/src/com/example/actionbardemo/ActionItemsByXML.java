package com.example.actionbardemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;

public class ActionItemsByXML extends ActionBarActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_actionitems);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.actionitem, menu);
		return super.onCreateOptionsMenu(menu);
	}
}
