package jp.mituliii.hardwarekeysupportsample;

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

public class HKPreference extends PreferenceActivity
{
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    addPreferencesFromResource(R.layout.preference);
    
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
    
    int[] ids = {
      R.string.button1,
      R.string.button2,
      R.string.button3
    };
    
    // 各項目に設定されたキーコード取得して
    // 動的にサマリーをセットする
    for (int id : ids) {
      String key = getString(id);
      Preference preference = findPreference(key);
      int keyCode = preferences.getInt(key, KeyEvent.KEYCODE_UNKNOWN);
      HKKeyCodeMap keyCodeMap = HKKeyCodeMap.valueOf(keyCode);
      String keyCodeName = keyCodeMap.getName();
      preference.setSummary(keyCodeName);
    }
  }

  // 項目のクリックイベントにフックする
  @Override
  public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, final Preference preference)
  {
    final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
    final Editor editor = preferences.edit();
    
    final String key = preference.getKey();

    // 現在設定されているキーコードを保存
    final int keyCode = preferences.getInt(key, KeyEvent.KEYCODE_UNKNOWN);
    HKKeyCodeMap keyCodeMap = HKKeyCodeMap.valueOf(keyCode);
    String keyCodeName = keyCodeMap.getName();

    // ダイアログにテキストビューを追加して
    // 設定されているキーコードの名前を表示
    final TextView textView = new TextView(this);
    textView.setText(keyCodeName);
    textView.setTextSize(30);

    // ダイアログのキーアップ/ダウンイベントにフックして
    // 設定値とテキストビューの表示を書き換える
    AlertDialog dialog = new AlertDialog(this)
    {
      public boolean dispatchKeyEvent(KeyEvent event)
      {
        int keyCode = event.getKeyCode();
        HKKeyCodeMap keyCodeMap = HKKeyCodeMap.valueOf(keyCode);
        String keyCodeName = keyCodeMap.getName();
        
        editor.putInt(key, keyCode);
        textView.setText(keyCodeName);
       
        return true;
      }
    };

    dialog.setTitle(preference.getTitle());
    dialog.setView(textView);

    // OKが押された時は
    // 書き換えた設定値を適用し
    // サマリーも新しい設定値に書き換える
    dialog.setButton("OK", new OnClickListener()
    {
      public void onClick(DialogInterface dialog, int whichButton)
      {
        editor.commit();
        
        int keyCode = preferences.getInt(key, KeyEvent.KEYCODE_UNKNOWN);
        HKKeyCodeMap keyCodeMap = HKKeyCodeMap.valueOf(keyCode);
        String keyCodeName = keyCodeMap.getName();
        preference.setSummary(keyCodeName);
      }
    });

    // キャンセルが押された時は
    // 元々設定してあった値に戻す
    dialog.setButton2("Cancel", new OnClickListener()
    {
      public void onClick(DialogInterface dialog, int whichButton)
      {
        editor.putInt(key, keyCode);
        editor.commit();
      }
    });

    // クリアが押された時は
    // KEYCODE_UNKNOWNを設定して閉じる
    dialog.setButton3("Clear", new OnClickListener()
    {
      public void onClick(DialogInterface dialog, int whichButton)
      {
        editor.putInt(key, KeyEvent.KEYCODE_UNKNOWN);
        editor.commit();
        
        preference.setSummary(HKKeyCodeMap.KEYCODE_UNKNOWN.getName());
      }
    });

    dialog.show();

    return super.onPreferenceTreeClick(preferenceScreen, preference);
  }
  
  // キーを引数に
  // 設定されているキーコードを取得する
  public static int getKeyCode(Context context, String key)
  {
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
    return preferences.getInt(key, KeyEvent.KEYCODE_UNKNOWN);
  }
}
