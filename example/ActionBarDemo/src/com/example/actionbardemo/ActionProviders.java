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
 * ActionProvider其实就是实现了Action的点击事件，当我们有很多地方都用到了系统意图或公用的操作时就可以
 * 继承ActionProvider然后创建一个统一的视图和点击视图后的实现。
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
		//同样，actionProvider也可以通过代码的方式来添加
//		MenuItemCompat.setActionProvider(item, provider);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Toast.makeText(this, ""+item, Toast.LENGTH_LONG).show();
		return super.onOptionsItemSelected(item);
	}
	
	/**
	 * 自定义ActionProvider
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
		 *在选中溢出菜单中的菜单时，系统会调用这个方法，并且操作提供器应该这对这个选中的菜单项执行默认的操作。
			但是，如果你的操作提供器提供了一个子菜单，即使是溢出菜单中一个菜单项的子菜单，
			那么也要通过onPrepareSubMenu()回调方法来显示子菜单。
			这样onPerformDefaultAction()在子菜单显示时就不会被调用。注意：实现了onOptionsItemSelected()
			回调方法的Activity或Frament对象能够通过处理item-selected事件（并且返回true）来覆盖操作提供器的默认行为，这种情况下，系统不会调用onPerformDefaultAction()回调方法。
		 */
		@Override
		public boolean onPerformDefaultAction() {
			Log.i("test", "onPerformDefaultAction");
			return super.onPerformDefaultAction();
		}
		
	}
}
