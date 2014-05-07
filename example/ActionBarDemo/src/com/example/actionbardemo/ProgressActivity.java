package com.example.actionbardemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
/**
 * 长条形进度条actionBar
 * @author lsx
 *
 */
public class ProgressActivity extends ActionBarActivity{

	int begin=1000;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		supportRequestWindowFeature(Window.FEATURE_PROGRESS);
		setContentView(R.layout.activity_progress);
		((Button)findViewById(R.id.progress_btn_go)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(begin<Window.PROGRESS_END){
					begin+=1000;
					setSupportProgressBarVisibility(true);
					//setSecondaryProgress(begin);
					setProgress(begin-1000);
					//setSupportProgressBarIndeterminate(true);
				}
			}
		});
	}
}
