package com.bewareofraj.gozinta;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import com.bewareofraj.gozinta.util.SystemUiHider;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class MainActivity extends Activity {
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		// hide action bar
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			ActionBar actionBar = getActionBar();
			actionBar.hide();
		}
	}

}
