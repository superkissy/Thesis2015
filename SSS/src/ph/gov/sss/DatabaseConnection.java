package ph.gov.sss;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import android.os.AsyncTask;

public class DatabaseConnection extends AsyncTask<String, Void, String>{
	
	MainActivity main = new MainActivity();
	
	String reg_url = "http://192.168.1.100/webapp/register.php";  
    String login_url = "http://192.168.1.100//webapp/login.php";  
    String login_status = "";
    
	 protected void onPostExecute(DatabaseConnection feed)
	 {
	        // TODO: check this.exception 
	        // TODO: do something with the feed
	 }
	


	@Override
	protected String doInBackground(String... arg0) {
		String login_name = arg0[0],
				login_pass = arg0[1],
				response = "";
		try {  
	        URL url = new URL(login_url);  
	        HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();  
	        httpURLConnection.setRequestMethod("POST");  
	        httpURLConnection.setDoOutput(true);  
	        httpURLConnection.setDoInput(true);  
	        OutputStream outputStream = httpURLConnection.getOutputStream();  
	        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));  
	        String data = URLEncoder.encode("login_name","UTF-8")+"="+URLEncoder.encode(login_name,"UTF-8")+"&"+  
	        URLEncoder.encode("login_pass","UTF-8")+"="+URLEncoder.encode(login_pass,"UTF-8");  
	        bufferedWriter.write(data);  
	        bufferedWriter.flush();  
	        bufferedWriter.close();  
	        outputStream.close();  
	        InputStream inputStream = httpURLConnection.getInputStream();  
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));  
	        String line = "";  
	        while ((line = bufferedReader.readLine())!=null)  
	        {  
	          response+= line;
	        }
	        main.loginstatus(response);
	       
	        bufferedReader.close();  
	        inputStream.close();  
	        httpURLConnection.disconnect();  
	      } catch (MalformedURLException e) {  
	        e.printStackTrace();  
	      } catch (IOException e) {  
	        e.printStackTrace();  
	      }  
	    
	    return null;  
	  }
	 
}
