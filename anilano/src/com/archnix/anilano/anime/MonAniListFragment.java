package com.archnix.anilano.anime;

import com.archnix.anilano.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MonAniListFragment extends Fragment {

	public View onCreateView(LayoutInflater inflater , ViewGroup container, Bundle savedInstanceState)
	{
	
		View v = inflater.inflate(R.layout.mon,container, false);
		return v;
	}
}
