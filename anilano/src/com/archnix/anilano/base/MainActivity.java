package com.archnix.anilano.base;

import android.os.Bundle;
import com.archnix.anilano.R;


public class MainActivity extends BaseActivity {
	
	  @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        fragmentReplace(0);
	    }

}
