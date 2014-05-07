package com.example.actionbardemo;

import java.util.Random;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
/**
 * 混合使用
 * @author lsx
 *
 */
public class FeatureToggle extends ActionBarActivity implements TabListener{

	private static final Random RANDOM = new Random();
	
	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*
		 * 如果要启用进度条样子的ActionBar则必须要加这个，Window.FEATURE_INDETERMINATE_PROGRESS是一个圆形
		 * 的不确定的进度条，Window.FEATURE_PROGRESS一般是一个条形进度条，范围：0-10000
		 *注意这里是supportRequestWindowFeature，而不是requestWindowFeature(int i)
		 *并且必须在setContentView(int layout)之前调用
		 */
		supportRequestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		supportRequestWindowFeature(Window.FEATURE_PROGRESS);
		setContentView(R.layout.activity_featuretoggle);
		setSupportProgressBarIndeterminateVisibility(false);
        setSupportProgressBarVisibility(false);
        getSupportActionBar().setCustomView(R.layout.layout_customerview);
        getSupportActionBar().setDisplayShowCustomEnabled(false);
        
        ArrayAdapter<CharSequence> listAdapter = ArrayAdapter.createFromResource(this, R.array.locations, android.R.layout.simple_spinner_item);
        listAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        getSupportActionBar().setListNavigationCallbacks(listAdapter, null);
		initEvents();
	}
	
	private void initEvents(){
		/****显示ActionBar*****/
		((Button)findViewById(R.id.featureToggle_btn_showActionBar)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().show();
			}
		});
		/****隐藏ActionBar*****/
		((Button)findViewById(R.id.featureToggle_btn_showActionBar)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().hide();
			}
		});
		/****将ActionBar样式设置为标准样式*****/
		((Button)findViewById(R.id.featureToggle_btn_standardActionBar)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
			}
		});
		/****将ActionBar样式设置为下拉列表List样式*****/
		((Button)findViewById(R.id.featureToggle_btn_listActionBar)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
			}
		});
		/****将ActionBar样式设置为选项卡Tab样式*****/
		((Button)findViewById(R.id.featureToggle_btn_tabsActionBar)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
			}
		});
		/****新增一个Tab*****/
		((Button)findViewById(R.id.featureToggle_btn_addTab)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ActionBar.Tab newTab=getSupportActionBar().newTab();
				if(RANDOM.nextBoolean()) {
                    newTab.setCustomView(R.layout.layout_edit);
                } else {
                    boolean icon = RANDOM.nextBoolean();
                    if (icon) {
                        newTab.setIcon(R.drawable.ic_title_share_default);
                    }
                    if (!icon || RANDOM.nextBoolean()) {
                        newTab.setText("Text!");
                    }
                }
				newTab.setTabListener(FeatureToggle.this);//这个必须设置
				getSupportActionBar().addTab(newTab);
			}
		});
		
		/****随机选择一个Tab*****/
		((Button)findViewById(R.id.featureToggle_btn_selectTab)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ActionBar actionBar=getSupportActionBar();
				if(actionBar.getTabCount()>0){
					Tab tab=actionBar.getTabAt(RANDOM.nextInt(actionBar.getTabCount()));
					actionBar.selectTab(tab);
				}
			}
		});
		/****删除一个Tab*****/
		((Button)findViewById(R.id.featureToggle_btn_removeTab)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ActionBar actionBar=getSupportActionBar();
				if(actionBar.getTabCount()>0){
					actionBar.removeTabAt(actionBar.getTabCount()-1);
				}
			}
		});
		/****删除所有Tab*****/
		((Button)findViewById(R.id.featureToggle_btn_removeAllTab)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ActionBar actionBar=getSupportActionBar();
				if(actionBar.getTabCount()>0){
					actionBar.removeAllTabs();
				}
			}
		});
		/****添加一个ActionItems*****/
		((Button)findViewById(R.id.featureToggle_btn_addActionItems)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				items++;
				//类似ListView中的Adapter.notifyDatasetChanged();
				supportInvalidateOptionsMenu();
			}
		});
		/****删除所有ActionItems*****/
		((Button)findViewById(R.id.featureToggle_btn_removeAllActionItems)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				items=0;
				supportInvalidateOptionsMenu();
			}
		});
		/****显示title*****/
		((Button)findViewById(R.id.featureToggle_btn_showTitle)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().setDisplayShowTitleEnabled(true);
			}
		});
		/****隐藏title*****/
		((Button)findViewById(R.id.featureToggle_btn_hideTitle)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().setDisplayShowTitleEnabled(false);
			}
		});
		/****显示子title*****/
		((Button)findViewById(R.id.featureToggle_btn_showSubTitle)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().setSubtitle("subTitle");
			}
		});
		/****隐藏子title*****/
		((Button)findViewById(R.id.featureToggle_btn_hideSubTitle)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().setSubtitle(null);
			}
		});
		/****显示自定义ActionItem*****/
		((Button)findViewById(R.id.featureToggle_btn_showCustomeView)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().setDisplayShowCustomEnabled(true);
			}
		});
		/****隐藏自定义ActionItem*****/
		((Button)findViewById(R.id.featureToggle_btn_hideCustomeView)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().setDisplayShowCustomEnabled(false);
			}
		});
		/****显示左边Home*****/
		((Button)findViewById(R.id.featureToggle_btn_showHomeActionItem)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().setDisplayShowHomeEnabled(true);
			}
		});
		/****隐藏左边Home*****/
		((Button)findViewById(R.id.featureToggle_btn_hideHomeActionItem)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().setDisplayShowHomeEnabled(false);
			}
		});
		/****显示Logo*****/
		((Button)findViewById(R.id.featureToggle_btn_useLogo)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().setDisplayUseLogoEnabled(true);
			}
		});
		/****隐藏Logo*****/
		((Button)findViewById(R.id.featureToggle_btn_notUseLogo)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().setDisplayUseLogoEnabled(false);
			}
		});
		/****显示返回尖括号*****/
		((Button)findViewById(R.id.featureToggle_btn_showHomeAsUp)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().setDisplayHomeAsUpEnabled(true);
			}
		});
		/****隐藏返回尖括号*****/
		((Button)findViewById(R.id.featureToggle_btn_hideHomeAsUp)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().setDisplayHomeAsUpEnabled(false);
			}
		});
		/****显示条形进度条*****/
		((Button)findViewById(R.id.featureToggle_btn_showProgress)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setSupportProgressBarVisibility(true);
				setSupportProgressBarIndeterminateVisibility(false);
				setSupportProgress(RANDOM.nextInt(8000) + 10);
			}
		});
		/****隐藏条形进度条*****/
		((Button)findViewById(R.id.featureToggle_btn_hideProgress)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setSupportProgressBarVisibility(false);
			}
		});
		/****显示圆形进度条*****/
		((Button)findViewById(R.id.featureToggle_btn_showIndeterminateProgress)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setSupportProgress(Window.PROGRESS_END);
				setSupportProgressBarIndeterminateVisibility(true);
			}
		});
		/****隐藏圆形进度条*****/
		((Button)findViewById(R.id.featureToggle_btn_hideIndeterminateProgress)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setSupportProgressBarIndeterminateVisibility(false);
			}
		});
		
	}
	
	int items=0;
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		for(int i=0;i<items;i++){
			MenuItem menuItem=menu.add("items"+items)
					.setIcon(R.drawable.ic_title_share_default);
			MenuItemCompat.setShowAsAction(menuItem, MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
	}

	@Override
	public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
	}
}
