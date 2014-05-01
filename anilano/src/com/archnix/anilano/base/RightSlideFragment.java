package com.archnix.anilano.base;

import com.archnix.anilano.R;

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


public class RightSlideFragment extends ListFragment {
	public RightSlideFragment()
	{
		
	}
	
	   public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	        return inflater.inflate(R.layout.anime_list, null);
	}
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		SlidingAdapter adapter = new SlidingAdapter(getActivity());
		adapter.add(new SlideItem("워어어어얼",R.drawable.menu));
		adapter.add(new SlideItem("화아아아",R.drawable.menu));
		adapter.add(new SlideItem("수우우",R.drawable.menu));
		adapter.add(new SlideItem("모옥",R.drawable.menu));
		adapter.add(new SlideItem("금",R.drawable.menu));
		adapter.add(new SlideItem("퇼",R.drawable.menu));
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
			((BaseActivity)getActivity()).fragmentReplace2(0);
			break;
		case 1:
			((BaseActivity)getActivity()).fragmentReplace2(1);
			break;
		case 2:
			((BaseActivity)getActivity()).fragmentReplace2(2);
			break;
		case 3:
			((BaseActivity)getActivity()).fragmentReplace2(3);
			break;
		case 4:
			((BaseActivity)getActivity()).fragmentReplace2(4);
			break;
		case 5:
			((BaseActivity)getActivity()).fragmentReplace2(5);
			break;
		case 6:
			((BaseActivity)getActivity()).fragmentReplace2(6);
			break;
		default:
			break;
		}
		super.onListItemClick(l, v, position, id);
	}



}
