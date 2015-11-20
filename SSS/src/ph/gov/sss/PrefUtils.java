package ph.gov.sss;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PrefUtils {
	public static final String PREFS_LOGIN_USERNAME_KEY = "__USERNAME__" ;
    public static final String PREFS_LOGIN_PASSWORD_KEY = "__PASSWORD__" ;
    
    public static void saveToPrefs(Context context, String key, String value) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        final SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key,value);
        editor.commit();
    }
    
    public static String getFromPrefs(Context context, String key, String defaultValue) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        try {
            return sharedPrefs.getString(key, defaultValue);
        } catch (Exception e) {
             e.printStackTrace();
             return defaultValue;
        }
    }
    
    public static void removeFromPrefs(Context context)
    {
    	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        final SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PREFS_LOGIN_USERNAME_KEY ,"");
        editor.putString(PREFS_LOGIN_PASSWORD_KEY ,"");
        editor.commit();
    }
}
