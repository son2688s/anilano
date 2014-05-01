package com.archnix.anilano.novel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;
import com.archnix.anilano.R;

public class NovelListFragment extends SherlockFragment {
	@Override
	public View onCreateView(LayoutInflater inflater , ViewGroup container, Bundle savedInstanceState)
	{
		View v = inflater.inflate(R.layout.novellistfragment,container, false);
		return v;
	}
}
