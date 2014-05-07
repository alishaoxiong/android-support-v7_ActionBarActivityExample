package com.example.actionbardemo;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
/**
 * 自定义布局和样式的ActionBar
 * @author lsx
 *
 */
public class CustomNavigation extends ActionBarActivity{

	
	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customernavigation);
		View customerView=getLayoutInflater().inflate(R.layout.layout_customerview, null);
		Button btn1=(Button)customerView.findViewById(R.id.customerView_btn_1);
		btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(CustomNavigation.this, "btn1", 1).show();
				
			}
		});
		Button btn2=(Button)customerView.findViewById(R.id.customerView_btn_2);
		btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(CustomNavigation.this, "btn2", 1).show();
			}
		});
		ActionBar actionBar=getSupportActionBar();
		actionBar.setCustomView(customerView);
		actionBar.setDisplayShowCustomEnabled(true);//这句不要忘了加
	}
}
