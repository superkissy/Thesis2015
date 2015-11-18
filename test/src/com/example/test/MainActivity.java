package com.example.test;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Driver;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	
	Button button1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	    final  EditText editTextUserName=(EditText) findViewById(R.id.user_id);
	    final  EditText editTextPassword=(EditText) findViewById(R.id.pass_field);
 
		Button loginbutton = (Button) findViewById(R.id.button1);
		loginbutton.setOnClickListener(new View.OnClickListener() 
		{
			String dbusername;
			String dbpass;
			
			@Override
			public void onClick(View v) {
				
				String userName= editTextUserName.getText().toString();
				String password= editTextPassword.getText().toString();
				
				
				String query  = "SELECT userid, password from sss_login WHERE userid = " + userName;
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					String sql ="jdbc:mysql://192.168.1.111:3306";
	    			Connection connect = DriverManager.getConnection(sql, "root", "");
	    			Statement statement = connect.createStatement();
	    			ResultSet rs = statement.executeQuery(query);
	    			while(rs.next())
	    			{
	    				dbusername = rs.getNString("userid");
	    				dbpass = rs.getNString("password");
	    			}
	    			if((dbusername.equals(userName)) && (dbpass.equals(password)))
	    			{
	    				Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();
	    			}
	    			else
	    			{
	    				Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_LONG).show();
	    			}
	    			      
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		});
		
	}
		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void SecondAct(View v)
	{
		Intent intent = new Intent(this, SecondActivity.class);
		startActivity(intent);
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
