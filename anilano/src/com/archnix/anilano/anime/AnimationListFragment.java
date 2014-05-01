package com.archnix.anilano.anime;



import com.actionbarsherlock.view.MenuItem;
import com.archnix.anilano.R;
import com.archnix.anilano.license.LicenseFragment;
import com.archnix.anilano.novel.NovelListFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AnimationListFragment extends SlidingFragmentActivity {


		
	private Fragment mContent;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		

		setContentView(R.layout.animationlistfragment);

		// check if the content frame contains the menu frame
		if (findViewById(R.id.menu_frame_two) == null) {
			setBehindContentView(R.layout.right_list);
			getSlidingMenu().setSlidingEnabled(true);
			getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
			// show home as up so we can toggle
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		} else {
			// add a dummy view
			View v = new View(this);
			setBehindContentView(v);
			getSlidingMenu().setSlidingEnabled(false);
			getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
		}

		// set the Above View Fragment
		if (savedInstanceState != null)
			mContent = getSupportFragmentManager().getFragment(savedInstanceState, "mContent");
		if (mContent == null)
//			mContent = new AnimeGridFragment(0);	
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.content_frame,mContent)
		.commit();

		// set the Behind View Fragment
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.menu_frame, new AnimeMenuFragment())
		.commit();

		// customize the SlidingMenu
		SlidingMenu sm = getSlidingMenu();
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindScrollScale(0.25f);
		sm.setFadeDegree(0.25f);
		
		getSlidingMenu().setMode(SlidingMenu.LEFT_RIGHT);
			getSlidingMenu().setSecondaryMenu(R.layout.right_list);
			getSlidingMenu().setSecondaryShadowDrawable(R.drawable.shadowright);
		//	getSupportFragmentManager()
		//	.beginTransaction()
		//	.replace(R.id.menu_frame_two, new RightSlideFragment())
		//	.commit();

		// show the explanation dialog
		if (savedInstanceState == null)
			new AlertDialog.Builder(this)
			.setTitle("R.string.what_is_this")
			.setMessage("R.string.responsive_explanation")
			.show();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			toggle();
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		getSupportFragmentManager().putFragment(outState, "mContent", mContent);
	}

	public void switchContent(final Fragment fragment) {
		mContent = fragment;
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.content_frame, fragment)
		.commit();
		Handler h = new Handler();
		h.postDelayed(new Runnable() {
			public void run() {
				getSlidingMenu().showContent();
			}
		}, 50);
	}	

	public void onBirdPressed(int pos) {
		Intent intent = AnimeActivity.newInstance(this, pos);
		startActivity(intent);
	}
}