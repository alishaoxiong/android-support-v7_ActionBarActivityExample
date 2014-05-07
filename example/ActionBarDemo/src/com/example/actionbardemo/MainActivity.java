package com.example.actionbardemo;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
/**
 * 有两种测试没弄出来：
 * 1、带preferences和actionbar的
 * 2、不通过继承，通过代码实现actionbar
 * 如有知道者，可以发封邮件到alishaoxiong@163.com。谢谢
 * @author lsx
 *
 */
public class MainActivity extends ActionBarActivity implements android.widget.AdapterView.OnItemClickListener{

	List<String> list=new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ListView lv=(ListView)findViewById(R.id.lv);
		list=getList();
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, list);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(this);
	}

	
	private List<String> getList(){
		List<String> _list=new ArrayList<String>();
		_list.add("ActionItemsByCoding");
		_list.add("ActionItemsByXML");
		_list.add("ActionModes");
		_list.add("ActionModesNoActionBar");
		_list.add("ActionProvider");
		_list.add("CollapsibleActionItem");
		_list.add("ContextMenuDemo");
		_list.add("CustomerNavigation");
		_list.add("FeatureToggle");
		_list.add("IndeterminateProgress");
		_list.add("ListNavigation");
		_list.add("Oveylay");
		_list.add("ProgressActivity");
		_list.add("SeachView");
		_list.add("ShareActionProvider");
		_list.add("SplitActionItems");
		_list.add("SplitActionModes");
		_list.add("Styled");
		_list.add("SubMenuActivity");
		return _list;
	}
	
	private void startActivity(Class<?> cls){
		Intent data=new Intent(this,cls);
		startActivity(data);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		switch (position) {
		case 0:
			startActivity(ActionItemsByCoding.class);
			break;
		case 1:
			startActivity(ActionItemsByXML.class);
			break;
		case 2:
			startActivity(ActionModes.class);
			break;
		case 3:
			startActivity(ActionModesNoActionBar.class);
			break;
		case 4:
			startActivity(ActionProviders.class);
			break;
		case 5:
			startActivity(CollapsibleActionItem.class);
			break;
		case 6:
			startActivity(ContextMenuDemo.class);
			break;
		case 7:
			startActivity(CustomNavigation.class);
			break;
		case 8:
			startActivity(FeatureToggle.class);
			break;
		case 9:
			startActivity(IndeterminateProgress.class);
			break;
		case 10:
			startActivity(ListNavigation.class);
			break;
		case 11:
			startActivity(Overlay.class);
			break;
		case 12:
			startActivity(ProgressActivity.class);
			break;
		case 13:
			startActivity(SearchViewActivity.class);
			break;
		case 14:
			startActivity(ShareActionProvider.class);
			break;
		case 15:
			startActivity(SplitActionItems.class);
			break;
		case 16:
			startActivity(SplitActionModes.class);
			break;
		case 17:
			startActivity(Styled.class);
			break;
		case 18:
			startActivity(SubMenuActivity.class);
			break;
		default:
			break;
		}
		
	}

}
