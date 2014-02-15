package com.example.giveastick;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class SplashActivity extends Activity {

	// Splash screen timer
    private static int SPLASH_TIME_OUT = 2000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		new Handler().postDelayed(new Runnable(){
			
			@Override
			public void run(){
				Intent i = new Intent(SplashActivity.this, HomeActivity.class);
				startActivity(i);
				
				finish();
			}
		}, SPLASH_TIME_OUT);
	}

}
