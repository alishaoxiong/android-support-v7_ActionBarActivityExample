package com.example.actionbardemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class Styled extends ActionBarActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_styled);
		getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_compose_inverse));
		//这个要跟uiOptions搭配使用
		getSupportActionBar().setSplitBackgroundDrawable(getResources().getDrawable(R.drawable.ic_launcher_settings));
	}
}
