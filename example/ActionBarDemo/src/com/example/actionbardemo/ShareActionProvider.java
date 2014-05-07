package com.example.actionbardemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
/**
 * 调用系统意图的actionBar
 * @author lsx
 *
 */
public class ShareActionProvider extends ActionBarActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shareactionprovider);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuItem share=menu.add("分享");
		MenuItemCompat.setShowAsAction(share, MenuItemCompat.SHOW_AS_ACTION_ALWAYS);
		android.support.v7.widget.ShareActionProvider provider=new android.support.v7.widget.ShareActionProvider(this);
		provider.setShareIntent(createShareIntent());
		/**
		 * 保存历史分享记录
		 * 即一旦你选择了几个分享的App
		 * 下次分享时，就会将这几个排在最前面
		 * 设置为Null则不使用该功能(官方API是这么说的，但是我设置为null后好像点击失效了)
		 */
		provider.setShareHistoryFileName(android.support.v7.widget.ShareActionProvider.DEFAULT_SHARE_HISTORY_FILE_NAME);
		MenuItemCompat.setActionProvider(share, provider);
		return super.onCreateOptionsMenu(menu);
	}
	
	private Intent createShareIntent() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("image/*");
        Uri uri = Uri.fromFile(getFileStreamPath("shared.png"));
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        return shareIntent;
    }

}
