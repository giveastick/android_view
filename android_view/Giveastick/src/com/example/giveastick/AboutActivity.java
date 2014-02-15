package com.example.giveastick;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AboutActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		
		final TextView title = (TextView) this.findViewById(R.id.about_title);
		final TextView content = (TextView) this.findViewById(R.id.about);
		Button backHome = (Button) this.findViewById(R.id.return_home);
		
		backHome.setOnClickListener(new OnClickListener(){
			
			public void onClick(View v){
				
				Intent intentBack = new Intent(AboutActivity.this, HomeActivity.class);
				startActivity(intentBack);
			}
		});
	}

}
