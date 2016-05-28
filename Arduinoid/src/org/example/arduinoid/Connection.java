package org.example.arduinoid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.bluetooth.BluetoothAdapter;
import android.support.v7.app.ActionBar;

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






public class Connection extends Activity {
	
	private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
	private BluetoothAdapter btAdapter = null;
	private BluetoothSocket btSocket = null;
	public OutputStream outStream = null;
	private Settings settings;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ConnectionView connectionView = new ConnectionView(this);
		setContentView(connectionView);
		connectionView.requestFocus();
		
		
		
		
		
	}
	
	
}
