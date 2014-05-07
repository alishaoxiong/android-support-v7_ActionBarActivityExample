package com.example.actionbardemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
/**
 * ����ϵͳ��ͼ��actionBar
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
		MenuItem share=menu.add("����");
		MenuItemCompat.setShowAsAction(share, MenuItemCompat.SHOW_AS_ACTION_ALWAYS);
		android.support.v7.widget.ShareActionProvider provider=new android.support.v7.widget.ShareActionProvider(this);
		provider.setShareIntent(createShareIntent());
		/**
		 * ������ʷ�����¼
		 * ��һ����ѡ���˼��������App
		 * �´η���ʱ���ͻὫ�⼸��������ǰ��
		 * ����ΪNull��ʹ�øù���(�ٷ�API����ô˵�ģ�����������Ϊnull�������ʧЧ��)
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
