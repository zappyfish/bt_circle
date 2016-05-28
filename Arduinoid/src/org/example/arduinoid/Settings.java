package org.example.arduinoid;


import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.bluetooth.BluetoothAdapter;


import android.support.v7.app.ActionBarActivity;


import android.view.Menu;
import android.view.MenuItem;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;


import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.UUID;
 
 
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class Settings extends Activity {

	
	private static final String TAG = "bluetooth1";
	
	private BluetoothAdapter btAdapter = null;
	private BluetoothSocket btSocket = null;
	private OutputStream outStream = null;
	
	private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		
		
		
		
		final Button button1 = (Button) findViewById(R.id.send_brightness);
		button1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//
				
				EditText mEdit = (EditText)findViewById(R.id.brightness);
				String brightness = mEdit.getText().toString();
				BluetoothAdapter bluetoothAdapter 
				   = BluetoothAdapter.getDefaultAdapter();
				Set<BluetoothDevice> pairedDevices 
				   = bluetoothAdapter.getBondedDevices();
				if (pairedDevices.size() > 0) {
				      for (BluetoothDevice device : pairedDevices) {
				    	  
				    	  try {
				    		  btSocket = device.createRfcommSocketToServiceRecord(MY_UUID);
				    		  btSocket.connect();
				    		  outStream = btSocket.getOutputStream();
				    		  
				    	  }
				    	  catch (IOException e) {
				    		  Toast.makeText(Settings.this, "failed to send", Toast.LENGTH_SHORT).show();
				    	  }
				    	  byte[] msgBuffer = brightness.getBytes();
				    	  
				    	  try{
				    		  outStream.write(msgBuffer);
				    		  Toast.makeText(Settings.this, "sent!", Toast.LENGTH_SHORT).show();
				    	  }
				    	  catch (IOException e) {
				    		  Toast.makeText(Settings.this, "some error", Toast.LENGTH_SHORT).show();
				    		  Toast.makeText(Settings.this, brightness, Toast.LENGTH_SHORT).show();
				    	  }
				    	  }
				      }
				else {
					
				}
				
				try {
					outStream = btSocket.getOutputStream();
				}
				catch (Exception IOException) {
					
				}
			}
		});
		
		
			
		}
	
	
	
		
		
	
}
