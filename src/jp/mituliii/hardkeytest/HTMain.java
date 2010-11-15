package jp.mituliii.hardkeytest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HTMain extends Activity
{
  protected Context  context;

  protected TextView textView;

  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    final Context context = this;

    textView = (TextView) findViewById(R.id.textview);

    // 各ボタンにイベントリスナーを登録
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

    // 設定画面に遷移させる
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

  // キーアップ/ダウンイベントにフックする
  @Override
  public boolean dispatchKeyEvent(KeyEvent event)
  {
    int keyCode = event.getKeyCode();
    
    // 設定されたキーコードを取得
    int button1KeyCode = HTPreference.getKeyCode(this, getString(R.string.button1));
    int button2KeyCode = HTPreference.getKeyCode(this, getString(R.string.button2));
    int button3KeyCode = HTPreference.getKeyCode(this, getString(R.string.button3));
    
    if (event.getAction() == KeyEvent.ACTION_DOWN) {
      // キーダウンイベントにフックして
      // 設定されたキーコードであればアクションを呼び出す
      if (keyCode == button1KeyCode) {
        onClickButton1();
        return true;
      } else if (keyCode == button2KeyCode) {
        onClickButton2();
        return true;
      } else if (keyCode == button3KeyCode) {
        onClickButton3();
        return true;
      }
    } else {
      // キーアップイベントをフックして無効化する
      if (keyCode == button1KeyCode) {
        return true;
      } else if (keyCode == button2KeyCode) {
        return true;
      } else if (keyCode == button3KeyCode) {
        return true;
      }
    }

    return super.dispatchKeyEvent(event);
  }

  // 各ボタンが押された時のアクション
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
