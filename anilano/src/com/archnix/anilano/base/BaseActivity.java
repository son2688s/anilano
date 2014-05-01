package com.archnix.anilano.base;

import java.util.Calendar;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.archnix.anilano.R;
import com.archnix.anilano.anime.AnimationListFragment;
import com.archnix.anilano.anime.EndAniListFragment;
import com.archnix.anilano.anime.FriAniListFragment;
import com.archnix.anilano.anime.MonAniListFragment;
import com.archnix.anilano.anime.ThrAniListFragment;
import com.archnix.anilano.anime.ThuAniListFragment;
import com.archnix.anilano.anime.WenAniListFragment;
import com.archnix.anilano.license.LicenseFragment;
import com.archnix.anilano.notice.NoticeListFragment;
import com.archnix.anilano.novel.NovelListFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class BaseActivity extends SlidingFragmentActivity {
	
	protected ListFragment mFrag;
	
	
	public BaseActivity()
	{
		
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		//비하인드 뷰 설정
		setBehindContentView(R.layout.menu_frame);
		if(savedInstanceState == null)
		{
			FragmentTransaction t = this.getSupportFragmentManager().beginTransaction();
			mFrag = new LeftSlideFragment();
			t.replace(R.id.menu_frame, mFrag);
			t.commit();
		} else 
		{
			mFrag = (ListFragment)this.getSupportFragmentManager().findFragmentById(R.id.menu_frame);
		}
		//커스텀 슬라이딩 메뉴 설정
		
		SlidingMenu sm = getSlidingMenu();
	//	sm.setMode(SlidingMenu.LEFT_RIGHT);
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setFadeDegree(1f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(false);
		getSupportActionBar().setDisplayShowCustomEnabled(true);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xff0068b7));
	//	getSupportActionBar().setTitle("애니라노!");
		getSupportActionBar().setLogo(R.drawable.menu_btn);
		getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.acb_main));
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch(item.getItemId())
		{
		case android.R.id.home:
		toggle();
		return true;
		}
		return super.onOptionsItemSelected(item);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getSupportMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
		
	public void fragmentReplace(int reqNewFragmentIndex) 
	{
			// TODO Auto-generated method stub
			Fragment newFragment = null;
			
			newFragment = getFragment(reqNewFragmentIndex);
			
			final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
			
			transaction.replace(R.id.fragment_mainContainer, newFragment);
			
			//getSlidingMenu().setMode(SlidingMenu.LEFT);
			
			getSlidingMenu().showContent();
			transaction.commit();
		}

		
		private Fragment getFragment(int idx)
		{
			Fragment newFragment = null;
			
			switch(idx)
			{
			case 0:
				newFragment = new NoticeListFragment();
				getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.acb_main));
				getSlidingMenu().setMode(SlidingMenu.LEFT);
				break;
			case 1:
				//newFragment = new AnimationListFragment();
				new Intent(BaseActivity.this, AnimationListFragment.class); 
			//	getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.acb_anime));
			//	getSlidingMenu().setMode(SlidingMenu.LEFT_RIGHT);
			//	getSlidingMenu().setSecondaryMenu(R.layout.right_list);
			//	getSlidingMenu().setSecondaryShadowDrawable(R.drawable.shadowright);
			//	getSupportFragmentManager()
			//	.beginTransaction()
			//	.replace(R.id.menu_frame_two, new RightSlideFragment())
			//	.commit();
				
				Calendar cal= Calendar.getInstance ( );
				
				int day_of_week = cal.get ( Calendar.DAY_OF_WEEK );
				if ( day_of_week == 1 )
					newFragment = new EndAniListFragment();
				else if ( day_of_week == 2 )
					newFragment = new MonAniListFragment();
				else if ( day_of_week == 3 )
					newFragment = new ThuAniListFragment();
				else if ( day_of_week == 4 )
					newFragment = new WenAniListFragment();
				else if ( day_of_week == 5 )
					newFragment = new ThrAniListFragment();
				else if ( day_of_week == 6 )
					newFragment = new FriAniListFragment();
				else if ( day_of_week == 7 )
					newFragment = new EndAniListFragment();
				
				break;
			case 2:
				newFragment = new NovelListFragment();
				getSlidingMenu().setMode(SlidingMenu.LEFT);
				getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.acb_novel));
				break;
			case 3:
				newFragment = new LicenseFragment();
				getSlidingMenu().setMode(SlidingMenu.LEFT);
				getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.acb_license));
				break;
			default:
				break;
			}
			return newFragment;
		}
		
		public void fragmentReplace2(int reqNewFragmentIndex) 
		{
				// TODO Auto-generated method stub
				Fragment newFragment = null;
				
				newFragment = getFragment2(reqNewFragmentIndex);
				
				final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
				
				transaction.replace(R.id.fragment_mainContainer, newFragment);
				
				//getSlidingMenu().setMode(SlidingMenu.LEFT);
				
				getSlidingMenu().showContent();
				transaction.commit();
			}

			
			private Fragment getFragment2(int idx)
			{
				Fragment newFragment = null;
				
				switch(idx)
				{
				case 0:
					newFragment = new MonAniListFragment();
					break;
				case 1:
					newFragment = new ThuAniListFragment();
					break;
				case 2:
					newFragment = new WenAniListFragment();
					break;
				case 3:
					newFragment = new ThrAniListFragment();
					break;
				case 4:
					newFragment = new FriAniListFragment();
					break;
				case 5:
					newFragment = new EndAniListFragment();
					break;
				default:
					break;
				}
				return newFragment;
			}
		

}
