package com.example.actionbardemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Window;
import android.widget.TextView;
/**
 * ��ʾ����Ҫչʾ��һ�����������ӵ�ActionBar״̬��
 * һ����Ҫ����ʾ���ĵĿռ����ø�MarginTop,�Ӷ���Activityһ��ʼ������ʱ��
 * ��������״̬����ס��˵���������
 * @author lsx
 *
 */
public class Overlay extends ActionBarActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		supportRequestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
		setContentView(R.layout.activity_overlay);
		
		//����һ��͸������
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.transparent));
        
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<1000;i++){
        	sb.append("Android��WebKit��GUI��Android��GUI�õ���ͬһ��GDI����Skia����GUI������ȫ��ͬ����ƣ��ֱ��Գ���ϵ��"
        	+"Android�д��ڵ�Window�࣬Windowjava.java�ļ���"
        	+"��һ�������࣬������Android���ڵĻ������Ժͻ������ܡ� 1).  Window��Ļ����������£�"
        	+"FEATURE_OPTIONS_PANEL = 0;��ѡ��Panel��־��Ĭ��ʹ�ܣ�" 
            +"FEATURE_NO_TITLE = 1;");
        }
        ((TextView)findViewById(R.id.overLay_text_content)).setText(sb.toString());
	}
}
