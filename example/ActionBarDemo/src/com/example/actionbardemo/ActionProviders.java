package com.example.actionbardemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.view.ActionProvider;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
/**
 * ActionProvider��ʵ����ʵ����Action�ĵ���¼����������кܶ�ط����õ���ϵͳ��ͼ���õĲ���ʱ�Ϳ���
 * �̳�ActionProviderȻ�󴴽�һ��ͳһ����ͼ�͵����ͼ���ʵ�֡�
 * @author lsx
 *
 */
public class ActionProviders extends ActionBarActivity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_actionprovider);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.settings_action_provider, menu);
		//ͬ����actionProviderҲ����ͨ������ķ�ʽ�����
//		MenuItemCompat.setActionProvider(item, provider);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Toast.makeText(this, ""+item, Toast.LENGTH_LONG).show();
		return super.onOptionsItemSelected(item);
	}
	
	/**
	 * �Զ���ActionProvider
	 * @author lsx
	 *
	 */
	public static class SettingsActionProvider extends ActionProvider{

        /** An intent for launching the system settings. */
        private static final Intent sSettingsIntent = new Intent(Settings.ACTION_SETTINGS);

        /** Context for accessing resources. */
        private final Context mContext;
		
		public SettingsActionProvider(Context context) {
			super(context);
			mContext=context;
		}

		@Override
		public View onCreateActionView() {
			// Inflate the action view to be shown on the action bar.
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            View view = layoutInflater.inflate(R.layout.settings_action_provider, null);
            ImageButton button = (ImageButton) view.findViewById(R.id.button);
            // Attach a click listener for launching the system settings.
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                	Log.i("test", "onClick");
                    mContext.startActivity(sSettingsIntent);
                }
            });
            return view;
		}
		
		/**
		 *��ѡ������˵��еĲ˵�ʱ��ϵͳ�����������������Ҳ����ṩ��Ӧ��������ѡ�еĲ˵���ִ��Ĭ�ϵĲ�����
			���ǣ������Ĳ����ṩ���ṩ��һ���Ӳ˵�����ʹ������˵���һ���˵�����Ӳ˵���
			��ôҲҪͨ��onPrepareSubMenu()�ص���������ʾ�Ӳ˵���
			����onPerformDefaultAction()���Ӳ˵���ʾʱ�Ͳ��ᱻ���á�ע�⣺ʵ����onOptionsItemSelected()
			�ص�������Activity��Frament�����ܹ�ͨ������item-selected�¼������ҷ���true�������ǲ����ṩ����Ĭ����Ϊ����������£�ϵͳ�������onPerformDefaultAction()�ص�������
		 */
		@Override
		public boolean onPerformDefaultAction() {
			Log.i("test", "onPerformDefaultAction");
			return super.onPerformDefaultAction();
		}
		
	}
}
