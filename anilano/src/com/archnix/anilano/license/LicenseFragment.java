package com.archnix.anilano.license;

import com.archnix.anilano.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LicenseFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater , ViewGroup container, Bundle savedInstanceState)
	{
		View v = inflater.inflate(R.layout.licensefragment,container, false);
		return v;
	}

}
