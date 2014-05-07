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
 * ���ʹ��
 * @author lsx
 *
 */
public class FeatureToggle extends ActionBarActivity implements TabListener{

	private static final Random RANDOM = new Random();
	
	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*
		 * ���Ҫ���ý��������ӵ�ActionBar�����Ҫ�������Window.FEATURE_INDETERMINATE_PROGRESS��һ��Բ��
		 * �Ĳ�ȷ���Ľ�������Window.FEATURE_PROGRESSһ����һ�����ν���������Χ��0-10000
		 *ע��������supportRequestWindowFeature��������requestWindowFeature(int i)
		 *���ұ�����setContentView(int layout)֮ǰ����
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
		/****��ʾActionBar*****/
		((Button)findViewById(R.id.featureToggle_btn_showActionBar)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().show();
			}
		});
		/****����ActionBar*****/
		((Button)findViewById(R.id.featureToggle_btn_showActionBar)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().hide();
			}
		});
		/****��ActionBar��ʽ����Ϊ��׼��ʽ*****/
		((Button)findViewById(R.id.featureToggle_btn_standardActionBar)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
			}
		});
		/****��ActionBar��ʽ����Ϊ�����б�List��ʽ*****/
		((Button)findViewById(R.id.featureToggle_btn_listActionBar)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
			}
		});
		/****��ActionBar��ʽ����Ϊѡ�Tab��ʽ*****/
		((Button)findViewById(R.id.featureToggle_btn_tabsActionBar)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
			}
		});
		/****����һ��Tab*****/
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
				newTab.setTabListener(FeatureToggle.this);//�����������
				getSupportActionBar().addTab(newTab);
			}
		});
		
		/****���ѡ��һ��Tab*****/
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
		/****ɾ��һ��Tab*****/
		((Button)findViewById(R.id.featureToggle_btn_removeTab)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ActionBar actionBar=getSupportActionBar();
				if(actionBar.getTabCount()>0){
					actionBar.removeTabAt(actionBar.getTabCount()-1);
				}
			}
		});
		/****ɾ������Tab*****/
		((Button)findViewById(R.id.featureToggle_btn_removeAllTab)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ActionBar actionBar=getSupportActionBar();
				if(actionBar.getTabCount()>0){
					actionBar.removeAllTabs();
				}
			}
		});
		/****���һ��ActionItems*****/
		((Button)findViewById(R.id.featureToggle_btn_addActionItems)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				items++;
				//����ListView�е�Adapter.notifyDatasetChanged();
				supportInvalidateOptionsMenu();
			}
		});
		/****ɾ������ActionItems*****/
		((Button)findViewById(R.id.featureToggle_btn_removeAllActionItems)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				items=0;
				supportInvalidateOptionsMenu();
			}
		});
		/****��ʾtitle*****/
		((Button)findViewById(R.id.featureToggle_btn_showTitle)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().setDisplayShowTitleEnabled(true);
			}
		});
		/****����title*****/
		((Button)findViewById(R.id.featureToggle_btn_hideTitle)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().setDisplayShowTitleEnabled(false);
			}
		});
		/****��ʾ��title*****/
		((Button)findViewById(R.id.featureToggle_btn_showSubTitle)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().setSubtitle("subTitle");
			}
		});
		/****������title*****/
		((Button)findViewById(R.id.featureToggle_btn_hideSubTitle)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().setSubtitle(null);
			}
		});
		/****��ʾ�Զ���ActionItem*****/
		((Button)findViewById(R.id.featureToggle_btn_showCustomeView)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().setDisplayShowCustomEnabled(true);
			}
		});
		/****�����Զ���ActionItem*****/
		((Button)findViewById(R.id.featureToggle_btn_hideCustomeView)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().setDisplayShowCustomEnabled(false);
			}
		});
		/****��ʾ���Home*****/
		((Button)findViewById(R.id.featureToggle_btn_showHomeActionItem)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().setDisplayShowHomeEnabled(true);
			}
		});
		/****�������Home*****/
		((Button)findViewById(R.id.featureToggle_btn_hideHomeActionItem)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().setDisplayShowHomeEnabled(false);
			}
		});
		/****��ʾLogo*****/
		((Button)findViewById(R.id.featureToggle_btn_useLogo)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().setDisplayUseLogoEnabled(true);
			}
		});
		/****����Logo*****/
		((Button)findViewById(R.id.featureToggle_btn_notUseLogo)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().setDisplayUseLogoEnabled(false);
			}
		});
		/****��ʾ���ؼ�����*****/
		((Button)findViewById(R.id.featureToggle_btn_showHomeAsUp)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().setDisplayHomeAsUpEnabled(true);
			}
		});
		/****���ط��ؼ�����*****/
		((Button)findViewById(R.id.featureToggle_btn_hideHomeAsUp)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSupportActionBar().setDisplayHomeAsUpEnabled(false);
			}
		});
		/****��ʾ���ν�����*****/
		((Button)findViewById(R.id.featureToggle_btn_showProgress)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setSupportProgressBarVisibility(true);
				setSupportProgressBarIndeterminateVisibility(false);
				setSupportProgress(RANDOM.nextInt(8000) + 10);
			}
		});
		/****�������ν�����*****/
		((Button)findViewById(R.id.featureToggle_btn_hideProgress)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setSupportProgressBarVisibility(false);
			}
		});
		/****��ʾԲ�ν�����*****/
		((Button)findViewById(R.id.featureToggle_btn_showIndeterminateProgress)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setSupportProgress(Window.PROGRESS_END);
				setSupportProgressBarIndeterminateVisibility(true);
			}
		});
		/****����Բ�ν�����*****/
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
