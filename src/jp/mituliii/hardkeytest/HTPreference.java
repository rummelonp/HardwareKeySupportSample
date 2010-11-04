package jp.mituliii.hardkeytest;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.view.KeyEvent;
import android.widget.TextView;

public class HTPreference extends PreferenceActivity
{
  protected Context context;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    addPreferencesFromResource(R.layout.preference);

    context = this;
    
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
    
    int[] ids = {
      R.string.button1,
      R.string.button2,
      R.string.button3
    };
    
    for (int id : ids) {
      String key = getString(id);
      Preference preference = findPreference(key);
      int keyCode = preferences.getInt(key, KeyEvent.KEYCODE_UNKNOWN);
      HTKeyCodeMap keyCodeMap = HTKeyCodeMap.valueOf(keyCode);
      String keyCodeName = keyCodeMap.getName();
      preference.setSummary(keyCodeName);
    }
  }

  @Override
  public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, final Preference preference)
  {
    final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
    final Editor editor = preferences.edit();
    
    final String key = preference.getKey();

    final int keyCode = preferences.getInt(key, KeyEvent.KEYCODE_UNKNOWN);
    HTKeyCodeMap keyCodeMap = HTKeyCodeMap.valueOf(keyCode);
    String keyCodeName = keyCodeMap.getName();

    final TextView textView = new TextView(context);
    textView.setText(keyCodeName);
    textView.setTextSize(30);

    AlertDialog dialog = new AlertDialog(context)
    {
      public boolean dispatchKeyEvent(KeyEvent event)
      {
        int keyCode = event.getKeyCode();
        HTKeyCodeMap keyCodeMap = HTKeyCodeMap.valueOf(keyCode);
        String keyCodeName = keyCodeMap.getName();
        
        editor.putInt(key, keyCode);
        textView.setText(keyCodeName);
       
        return true;
      }
    };

    dialog.setTitle(preference.getTitle());
    dialog.setView(textView);

    dialog.setButton("OK", new OnClickListener()
    {
      public void onClick(DialogInterface dialog, int whichButton)
      {
        editor.commit();
        
        int keyCode = preferences.getInt(key, KeyEvent.KEYCODE_UNKNOWN);
        HTKeyCodeMap keyCodeMap = HTKeyCodeMap.valueOf(keyCode);
        String keyCodeName = keyCodeMap.getName();
        preference.setSummary(keyCodeName);
      }
    });

    dialog.setButton2("Cancel", new OnClickListener()
    {
      public void onClick(DialogInterface dialog, int whichButton)
      {
        editor.putInt(key, keyCode);
        editor.commit();
      }
    });

    dialog.setButton3("Clear", new OnClickListener()
    {
      public void onClick(DialogInterface dialog, int whichButton)
      {
        editor.putInt(key, KeyEvent.KEYCODE_UNKNOWN);
        editor.commit();
        
        preference.setSummary(HTKeyCodeMap.KEYCODE_UNKNOWN.getName());
      }
    });

    dialog.show();

    return super.onPreferenceTreeClick(preferenceScreen, preference);
  }
}
