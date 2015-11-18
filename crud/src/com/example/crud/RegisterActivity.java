package com.example.crud;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterActivity extends Activity {
	
	EditText username, pass, conpass;
	String  user_name, user_pass, con_pass;
	Button Reg;
	Context ctx = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)

	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_layout);
		
		username=(EditText) findViewById(R.id.reg_user);
		pass = (EditText) findViewById(R.id.reg_pass);
		conpass = (EditText) findViewById(R.id.con_pass);
		Reg= (Button) findViewById(R.id.user_reg);
		Reg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				user_name= username.getText().toString();
				user_pass= pass.getText().toString();
				con_pass= conpass.getText().toString();
				
				if(!(user_pass.equals(con_pass)))
				{
					Toast.makeText(getBaseContext(), "Pass not match", Toast.LENGTH_LONG).show();
					username.setText("");
					pass.setText("");
					conpass.setText("");
				}
				else
				{
					//Toast.makeText(getBaseContext(), user_name +" "+user_pass, Toast.LENGTH_LONG).show();
					DatabaseOperations DB= new DatabaseOperations(ctx);
					DB.putInformation(DB, user_name, user_pass);
					Toast.makeText(getBaseContext(),"Registration success", Toast.LENGTH_LONG).show();
					finish();
				}
			}
		});
		
		
	}
}
