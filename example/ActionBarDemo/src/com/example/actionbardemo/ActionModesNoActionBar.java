package com.example.actionbardemo;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActionModesNoActionBar extends ActionBarActivity{

	ActionMode actionMode;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_actionmodes);
		getSupportActionBar().hide();
		((Button)findViewById(R.id.actionModes_btn_start)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				actionMode=startSupportActionMode(new MyActionModels());
			}
		});
		((Button)findViewById(R.id.actionModes_btn_close)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(actionMode!=null){
					actionMode.finish();
				}
			}
		});
	}
	
	
	private final class MyActionModels implements ActionMode.Callback{

		@Override
		public boolean onCreateActionMode(ActionMode mode, Menu menu) {
			MenuItem save=menu.add("save").setIcon(R.drawable.ic_compose_inverse);
			MenuItemCompat.setShowAsAction(save, MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
			
			MenuItem search=menu.add("search").setIcon(R.drawable.ic_search_inverse);
			MenuItemCompat.setShowAsAction(search, MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
			
			MenuItem refresh=menu.add("refresh").setIcon(R.drawable.ic_refresh_inverse);
			MenuItemCompat.setShowAsAction(refresh, MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
			MenuItem save1=menu.add("save").setIcon(R.drawable.ic_compose_inverse);
			MenuItemCompat.setShowAsAction(save1, MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
			
			MenuItem search1=menu.add("search").setIcon(R.drawable.ic_search_inverse);
			MenuItemCompat.setShowAsAction(search1, MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
			
			MenuItem refresh1=menu.add("refresh").setIcon(R.drawable.ic_refresh_inverse);
			MenuItemCompat.setShowAsAction(refresh1, MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
			MenuItem save2=menu.add("save").setIcon(R.drawable.ic_compose_inverse);
			MenuItemCompat.setShowAsAction(save2, MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
			
			MenuItem search2=menu.add("search").setIcon(R.drawable.ic_search_inverse);
			MenuItemCompat.setShowAsAction(search2, MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
			
			MenuItem refresh2=menu.add("refresh").setIcon(R.drawable.ic_refresh_inverse);
			MenuItemCompat.setShowAsAction(refresh2, MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
			return true;
		}
		
		@Override
		public boolean onActionItemClicked(ActionMode mode, MenuItem menu) {
			Toast.makeText(ActionModesNoActionBar.this, "µã»÷:"+menu, Toast.LENGTH_LONG).show();
			return false;
		}


		@Override
		public void onDestroyActionMode(ActionMode mode) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
}
