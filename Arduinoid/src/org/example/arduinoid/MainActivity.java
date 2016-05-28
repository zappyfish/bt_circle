package org.example.arduinoid;

import android.support.v7.app.ActionBarActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

public class MainActivity extends ActionBarActivity implements OnClickListener {
	
	
	private void checkBt() {
		BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

		if (!mBluetoothAdapter.isEnabled()) {
			Toast.makeText(getApplicationContext(), "Bluetooth Disabled !",
					Toast.LENGTH_SHORT).show();
                   /* It tests if the bluetooth is enabled or not, if not the app will show a message. */
		}

		if (mBluetoothAdapter == null) {
			Toast.makeText(getApplicationContext(),
					"Bluetooth null !", Toast.LENGTH_SHORT)
					.show();
		}
	}
	@Override
	public void onResume() {
		super.onResume();
		//checkBt(); // check if BT is enabled
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		/*View settingsButton = findViewById(R.id.settings_button);
		settingsButton.setOnClickListener(this);
		*/
		View connectButton = findViewById(R.id.connection_button);
		connectButton.setOnClickListener(this);
	}
	public void onClick(View v) {
		switch(v.getId()) {
		
		/*case R.id.settings_button:
			Intent i = new Intent(this, Settings.class);
			startActivity(i);
			break;
		*/
		case R.id.connection_button:
			Intent j = new Intent(this, Connection.class);
			startActivity(j);
			break; 
			
			}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
