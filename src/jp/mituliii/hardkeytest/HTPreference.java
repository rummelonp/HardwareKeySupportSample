package jp.mituliii.hardkeytest;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class HTPreference extends PreferenceActivity
{
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    addPreferencesFromResource(R.layout.preference);
  }
}
