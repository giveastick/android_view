package com.example.giveastick;

import com.example.entity.User;
import com.example.giveastick.RegisterActivity;
import com.example.giveastick.HomeActivity;
import com.example.giveastick.R;
import com.example.utils.giveastick.Const;

import android.os.Bundle;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
        final EditText email = (EditText) findViewById(R.id.userName);
		final EditText mdp   = (EditText) findViewById(R.id.password);
        Button connexion     = (Button)   findViewById(R.id.connexion);
		TextView register    = (TextView) findViewById(R.id.register);
		
		final String editEmail = "toto";
		final String editMdp = "toto";

			
		register.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){	
				Intent intentRegister = new Intent(HomeActivity.this, RegisterActivity.class);
				startActivity(intentRegister);
				//overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
			}
		});
		
		connexion.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				if ((email.getText().toString().equals(editEmail)) && (mdp.getText().toString().equals(editMdp))){
				
					Intent intentConnexion = new Intent(HomeActivity.this, ListActivity.class);
				
					startActivity(intentConnexion);
				} else {
					Toast.makeText(HomeActivity.this, "Erreur, login incorrect", Toast.LENGTH_LONG).show();
				}
		
			}
		});
    
    }

}
