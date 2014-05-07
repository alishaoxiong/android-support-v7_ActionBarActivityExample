package com.example.actionbardemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Window;
import android.widget.TextView;
/**
 * 该示例主要展示了一个浮动层样子的ActionBar状态栏
 * 一般需要给显示正文的空间设置个MarginTop,从而在Activity一开始启动的时候
 * 不至于让状态栏遮住最顶端的正文内容
 * @author lsx
 *
 */
public class Overlay extends ActionBarActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		supportRequestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
		setContentView(R.layout.activity_overlay);
		
		//加载一个透明背景
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.transparent));
        
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<1000;i++){
        	sb.append("Android的WebKit的GUI和Android的GUI用的是同一套GDI——Skia，但GUI层是完全不同的设计，分别自成体系。"
        	+"Android中窗口的Window类，Windowjava.java文件，"
        	+"是一个抽象类，概括了Android窗口的基本属性和基本功能。 1).  Window类的基本属性如下："
        	+"FEATURE_OPTIONS_PANEL = 0;可选的Panel标志（默认使能）" 
            +"FEATURE_NO_TITLE = 1;");
        }
        ((TextView)findViewById(R.id.overLay_text_content)).setText(sb.toString());
	}
}
