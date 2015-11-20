package ph.gov.sss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity{

	static boolean login_status;
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		

		Button loginbtn = (Button) findViewById(R.id.loginbutton);
		loginbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText uname = (EditText)findViewById(R.id.uname);
				EditText pass = (EditText)findViewById(R.id.pass);
				try
				{
					DatabaseConnection dbcon =  new DatabaseConnection();
					dbcon.execute("login",uname.getText().toString(), pass.getText().toString());
				}
				catch(Exception e)
				{
					System.out.println("Login catch :" + e);
				}
				
				System.out.println(login_status);
				if(login_status == true)
				{
					Intent HomePage = new Intent(LoginActivity.this, HomeActivity.class);
					HomePage.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
					startActivity(HomePage);
					PrefUtils prefutils = new PrefUtils();
					PrefUtils.saveToPrefs(LoginActivity.this, prefutils.PREFS_LOGIN_PASSWORD_KEY, pass.getText().toString());
					PrefUtils.saveToPrefs(LoginActivity.this, prefutils.PREFS_LOGIN_USERNAME_KEY, uname.getText().toString());
					login_status = false;
					Toast.makeText(LoginActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
				}
				else if(login_status == false)
				{
					Toast.makeText(LoginActivity.this, "Wrong UserID or Password", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
	}
	
	public static void loginstatus(String status)
	{
		char[] status2 = status.toCharArray();
		
		switch (status2[4]) {
			case '1':
				login_status = true;
				break;
			
			case '2':
				login_status = false;
				break;
				
			default:
				login_status = false;
				break;
		}
	}
}
