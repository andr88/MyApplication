package com.example.john.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        
        // 匿名クラス
        final Button button0 = findViewById(R.id.button_0);
        button0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String str = getString(R.string.bt0);
                textView.setText(str);
            }
        });
        // 変数でまとめる
        final Button button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(buttonClick);

        // OnClickListener を implementsして onClick を定義
        final Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(this);

        // カスタムクラス
        final Button button3 = findViewById(R.id.button_3);
        button3.setOnClickListener(new BtClick());

    }


    // 変数でまとめる
    private View.OnClickListener buttonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button_1:
                    String str = getString(R.string.bt1);
                    textView.setText(str);
                    break;
            }
        }
    };

    // OnClickListener を implementsして onClick を定義
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.button_2:
                String str = getString(R.string.bt2);
                textView.setText(str);
                break;
        }
    }

    // カスタムクラス
    class BtClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button_3:
                    String str = getString(R.string.bt3);
                    textView.setText(str);
                    break;
            }
        }
    }

    // android:onClick
    public void selfDestruct(View view) {
        String str = getString(R.string.bt4);
        textView.setText(str);
    }


}
