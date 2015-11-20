package ph.gov.sss;

import javax.xml.datatype.Duration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity{

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

				DatabaseConnection dbcon =  new DatabaseConnection();
				dbcon.execute(uname.getText().toString(), pass.getText().toString());
				
				if(login_status == true)
				{
					Intent HomePage = new Intent(MainActivity.this, HomeActivity.class);
					finish();
					startActivity(HomePage);
					Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_LONG).show();
				}
				else
				{
					Toast.makeText(MainActivity.this, "Wrong UserID or Password", Toast.LENGTH_LONG).show();
				}
			}
		});
	}
	
	public static void loginstatus(String status)
	{
		char[] status2 = status.toCharArray();
		if(status2[4] == '1')
		{
			login_status = true;
		}
		else if(status2[4] == '2')
		{
			login_status = false;
		}
	}
}
