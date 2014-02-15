package com.example.giveastick;

import java.util.ArrayList;
import java.util.List;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.example.entity.User;
import com.example.utils.giveastick.Const;

import android.net.Uri;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ListActivity extends SherlockActivity implements AccelerometerListener {

	private static class myAdapter extends ArrayAdapter<User> {

		private Context context;
		private int resource;
		private LayoutInflater monInflateur;
		
		public myAdapter(Context context, int resource, List<User> objects) {
			super(context, resource, objects);
			// TODO Auto-generated constructor stub
			this.context = context;
			this.resource = resource;
			this.monInflateur = LayoutInflater.from(this.context);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View view = monInflateur.inflate(this.resource, null);
			TextView nick = (TextView) view.findViewById(R.id.row_pseudo);
			TextView stick = (TextView) view.findViewById(R.id.stick);
			TextView nbStick = (TextView) view.findViewById(R.id.nomber_stick);
			
			User unUser = this.getItem(position);
			
			nick.setText(unUser.getNick().toString());
			nbStick.setText(unUser.getNomberStick().toString());
			stick.setText(unUser.getStick().toString());
			
			return view;
		}
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_list);
		
		//Binder la vue
		final ListView myList = (ListView) findViewById(R.id.list);
		
		// Create Data
		final ArrayList<User> aUsers = new ArrayList<User>();
		
		User monUser = (User) new User("alex","|||", 3);
		User monUser2 = (User) new User("steve", "||", 2);
		User monUser3 = (User) new User("boby", "||||", 4);
		User monUser4 = (User) new User("charly", "", 0);
		User monUser5 = (User) new User("emma","|||", 3);
		User monUser6 = (User) new User("caissa", "||", 2);
		User monUser7 = (User) new User("lolo", "||||", 4);
		User monUser8 = (User) new User("cliclic", "", 0);
		User monUser9 = (User) new User("zizou","|||", 3);
		User monUser10 = (User) new User("momo", "||", 2);
		User monUser11 = (User) new User("tony", "||||", 4);
		User monUser12 = (User) new User("guigui", "", 0);
		
		aUsers.add(monUser);
		aUsers.add(monUser2);
		aUsers.add(monUser3);
		aUsers.add(monUser4);
		aUsers.add(monUser5);
		aUsers.add(monUser6);
		aUsers.add(monUser7);
		aUsers.add(monUser8);
		aUsers.add(monUser9);
		aUsers.add(monUser10);
		aUsers.add(monUser11);
		aUsers.add(monUser12);
		
		// Convertion Array object to array string
		//ArrayList<User> nameUser = new ArrayList<User>();
		
		//for (User user : aUsers) {
		//	nameUser.add(user.getPrenom() + " " + user.getNom());
		//}
		
		myAdapter adapter = new myAdapter(this, R.layout.activity_row_list, aUsers);
		
		myList.setAdapter(adapter);	
		myList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
		
		public void onItemClick(AdapterView<?> parent, View v, int position, long id){
			AlertDialog.Builder adb = new AlertDialog.Builder(
			ListActivity.this);
			adb.setTitle("Vote !");
			adb.setMessage("Veux tu donner un baton à "
			+ aUsers.get(position).getNick());
			adb.setPositiveButton("OUI", null);
			adb.setNegativeButton("NON", null);
			adb.show();                     
		}
	});
		
	}
		
	/* action bar */
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getSupportMenuInflater();
        inflater.inflate(R.menu.row_list, menu);
        return super.onCreateOptionsMenu(menu);
    }
	
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()){
		case R.id.action_about:
			About();
			return true;
		case R.id.action_logout:
			Logout();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void About(){
		Intent intentAbout = new Intent(ListActivity.this, AboutActivity.class);
		startActivity(intentAbout);
	}
	
	private void Logout(){
		Intent intentLogout = new Intent(ListActivity.this, HomeActivity.class);
		startActivity(intentLogout);
	}
	
	
	/* shake */
	public void onAccelerationChanged(float x, float y, float z) {
		// TODO Auto-generated method stub
		
	}

	public void onShake(float force) {
		
        // Do your stuff here
        
		// Called when Motion Detected
		//Toast.makeText(getBaseContext(), "vote envoyé !", 
			//	Toast.LENGTH_SHORT).show();
		AlertDialog.Builder adb = new AlertDialog.Builder(
				ListActivity.this);
				adb.setTitle("Votre Gage !");
				adb.setMessage("Vous devez dire ces 3 mots dans l'heure :\r \n" +
						"Smurf, vache, prise ");
				adb.setPositiveButton("RETOUR", null);
				adb.show(); 
		
	}
	
	@Override
    public void onResume() {
            super.onResume();
//            Toast.makeText(getBaseContext(), "onResume Accelerometer Started", 
//            		Toast.LENGTH_SHORT).show();
            
            //Check device supported Accelerometer senssor or not
            if (AccelerometerManager.isSupported(this)) {
            	
            	//Start Accelerometer Listening
    			AccelerometerManager.startListening(this);
            }
    }
	
	@Override
    public void onStop() {
            super.onStop();
            
            //Check device supported Accelerometer senssor or not
            if (AccelerometerManager.isListening()) {
            	
            	//Start Accelerometer Listening
    			AccelerometerManager.stopListening();
    			
//    			Toast.makeText(getBaseContext(), "onStop Accelerometer Stoped", 
//                         Toast.LENGTH_SHORT).show();
            }
           
    }
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i("Sensor", "Service  distroy");
		
		//Check device supported Accelerometer senssor or not
		if (AccelerometerManager.isListening()) {
			
			//Start Accelerometer Listening
			AccelerometerManager.stopListening();
			
//			Toast.makeText(getBaseContext(), "onDestroy Accelerometer Stoped", 
//                   Toast.LENGTH_SHORT).show();
        }
			
	}

}