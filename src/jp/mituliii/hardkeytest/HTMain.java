package jp.mituliii.hardkeytest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HTMain extends Activity
{
  protected Context context;
  
  protected TextView textView;

  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    
    final Context context = this;

    textView = (TextView) findViewById(R.id.textview);

    Button button1 = (Button) findViewById(R.id.button1);
    button1.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View view)
      {
        onClickButton1();
      }
    });
    
    Button button2 = (Button) findViewById(R.id.button2);
    button2.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View view)
      {
        onClickButton2();
      }
    });
    
    Button button3 = (Button) findViewById(R.id.button3);
    button3.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View view)
      {
        onClickButton3();
      }
    });
    
    Button gotopreference = (Button) findViewById(R.id.gotopreference);
    gotopreference.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View v)
      {
        Intent intent = new Intent(context, HTPreference.class);
        startActivity(intent);
      }
    });
  }

  protected void onClickButton1()
  {
    textView.setText("button1 clicked.");
  }

  protected void onClickButton2()
  {
    textView.setText("button2 clicked.");
  }

  protected void onClickButton3()
  {
    textView.setText("button3 clicked.");
  }
}
