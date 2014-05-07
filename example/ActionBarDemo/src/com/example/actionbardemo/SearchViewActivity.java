package com.example.actionbardemo;

import android.app.SearchManager;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/**
 * 带搜索栏的actionBar
 * @author lsx
 *
 */
public class SearchViewActivity extends ActionBarActivity implements SearchView.OnQueryTextListener,SearchView.OnSuggestionListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_searchview);
	}
	
	private static final String[] COLUMNS = {
        BaseColumns._ID,
        SearchManager.SUGGEST_COLUMN_TEXT_1,
	};
	SuggestionAdapter adapter;
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		SearchView searchView=new SearchView(this);
		searchView.setQueryHint("请输入搜索内容");
		//当搜索框内容发现变化时触发
		searchView.setOnQueryTextListener(this);
		//当选择自动补全内容时触发
		searchView.setOnSuggestionListener(this);
		if(adapter==null){
			
			MatrixCursor cursor = new MatrixCursor(COLUMNS);
	        cursor.addRow(new String[]{"1", "Murica"});
	        cursor.addRow(new String[]{"2", "Canada"});
	        cursor.addRow(new String[]{"3", "Denmark"});
	        adapter = new SuggestionAdapter(getSupportActionBar().getThemedContext(), cursor);
		}
		searchView.setSuggestionsAdapter(adapter);
		
		MenuItem search=menu.add("search").setIcon(R.drawable.ic_search_inverse);
		MenuItemCompat.setShowAsAction(search, MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
		MenuItemCompat.setActionView(search, searchView);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onQueryTextChange(String arg0) {
		Log.i("test","onQueryTextChange:"+arg0);
		return false;
	}

	@Override
	public boolean onQueryTextSubmit(String arg0) {
		Log.i("test","onQueryTextSubmit:"+arg0);
		return false;
	}

	
	
	@Override
	public boolean onSuggestionClick(int arg0) {
		Log.i("test","onSuggestionClick:"+arg0);
		return false;
	}

	@Override
	public boolean onSuggestionSelect(int arg0) {
		Log.i("test","onSuggestionSelect:"+arg0);
		return false;
	}
	
	
	class SuggestionAdapter extends CursorAdapter{

		Context cxt;

		public SuggestionAdapter(Context context, Cursor c) {
			super(context, c, 0);
			this.cxt=context;
		}

		@Override
		public void bindView(View view, Context context, Cursor cursor) {
			TextView tv = (TextView) view;
            final int textIndex = cursor.getColumnIndex(SearchManager.SUGGEST_COLUMN_TEXT_1);
            tv.setText(cursor.getString(textIndex));
		}

		@Override
		public View newView(Context context, Cursor cursor, ViewGroup parent) {
			LayoutInflater inflater = LayoutInflater.from(cxt);
			View v = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
			return v;
		}
		
	}
}
