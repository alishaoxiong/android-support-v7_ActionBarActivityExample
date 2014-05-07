package com.example.actionbardemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
/**
 * 不确定具体进度的圆形进度条
 * @author lsx
 *
 */
public class IndeterminateProgress extends ActionBarActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		supportRequestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.activity_indeterminateprogress);
		((Button)findViewById(R.id.inderminateProgress_btn_show)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setSupportProgressBarIndeterminateVisibility(true);
			}
		});
		((Button)findViewById(R.id.inderminateProgress_btn_hide)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setSupportProgressBarIndeterminateVisibility(false);
			}
		});
	}
}
