package com.example.crud;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	Button Login;
	EditText USERNAME, USERPASS;
	String username, userpass;
	Context CTX = this;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_layout);
		
		Login = (Button) findViewById(R.id.b_login);
		USERNAME = (EditText) findViewById(R.id.user_name); 
		USERPASS = (EditText) findViewById(R.id.user_pass);
		Login.setOnClickListener(new OnClickListener() {
			
			public void onClick(View V){
				
					Toast.makeText(getBaseContext(), "Please Wait..", Toast.LENGTH_LONG).show();
					
					username = USERNAME.getText().toString();
					userpass = USERPASS.getText().toString();
					DatabaseOperations DOP = new DatabaseOperations(CTX);
					Cursor CR = DOP.getInformation(DOP);
					CR.moveToFirst();
					boolean loginstatus = false;
					String NAME = "";
					do
					{
						if(username.equals(CR.getString(0))&& (userpass.equals(CR.getString(1))))
						{
							loginstatus = true;
							NAME = CR.getString(0);
						}
					}
					while(CR.moveToNext());
					if(loginstatus)
					{
						Toast.makeText(getBaseContext(), "Login Success\n Welcome HOME"+NAME, Toast.LENGTH_LONG).show();
						finish();
					}
					else 
					{
						Toast.makeText(getBaseContext(), "Login Failed", Toast.LENGTH_LONG).show();
						finish();
					}
				}
		});
		
	}

}