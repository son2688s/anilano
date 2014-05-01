package com.archnix.anilano.base;

import com.archnix.anilano.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class LeftSlideFragment extends ListFragment {
	
	public LeftSlideFragment()
	{
		
	}
	
	   public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	        return inflater.inflate(R.layout.list, null);
	}
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		SlidingAdapter adapter = new SlidingAdapter(getActivity());
		adapter.add(new SlideItem("Notice",R.drawable.menu));
		adapter.add(new SlideItem("Anime",R.drawable.menu));
		adapter.add(new SlideItem("Light Novel", R.drawable.menu));
		adapter.add(new SlideItem("License",R.drawable.menu));
		
		setListAdapter(adapter);
	
	}
	
	 private class SlideItem {
			public String tag;
			public int iconRes;

			public SlideItem(String tag, int iconRes) {
				this.tag = tag;
				this.iconRes = iconRes;
			}
		}
	
	public class SlidingAdapter extends ArrayAdapter<SlideItem> 
	{

		public SlidingAdapter(Context context) {
			super(context, 0);
			// TODO Auto-generated constructor stub
		}
		
		public View getView(int position, View converView, ViewGroup parent)
		{
			if(converView == null)
			{
				converView = LayoutInflater.from(getContext()).inflate(R.layout.row,null);
			}
			ImageView icon=(ImageView)converView.findViewById(R.id.row_icon);
			icon.setImageResource(getItem(position).iconRes);
			TextView title = (TextView) converView.findViewById(R.id.row_title);
			title.setText(getItem(position).tag);
			
			return converView;
		}
	}
		
	@Override
	public void onListItemClick(ListView l, View v, int position, long id)
	{
		switch(position )
		{
		case 0:
			((BaseActivity)getActivity()).fragmentReplace(0);
			break;
		case 1:
			((BaseActivity)getActivity()).fragmentReplace(1);
			//Intent intent = new Intent(Activity)
			break;
		case 2:
			((BaseActivity)getActivity()).fragmentReplace(2);
			break;
		case 3:
			((BaseActivity)getActivity()).fragmentReplace(3);
			break;
		case 4:
			((BaseActivity)getActivity()).fragmentReplace(4);
			break;
		}
		super.onListItemClick(l, v, position, id);
	}



}
