package com.example.john.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button button[] = new Button[5];
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        // リニアレイアウトの設定
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        layout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));

        // レイアウト中央寄せ
        layout.setGravity(Gravity.CENTER);

        // 背景色
        layout.setBackgroundColor(Color.rgb(0xdd, 0xff, 0xee));

        setContentView(layout);

        // dp単位を取得
        float dp = getResources().getDisplayMetrics().density;
        // Button 幅を250dpに設定
        int buttonWidth = (int)(250 * dp);
        // マージン 10dp に設定
        int margins = (int)(10 * dp);

        // TextViewの設定
        textView = new TextView(this);
        String str = "TextView";
        textView.setText(str);
        textView.setTextColor(0xff000000);
        textView.setTextSize(10*dp);
        layout.addView(textView,
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));

        // Button[] 配列の設定
        for(int i=0; i< button.length ;i++) {
            button[i] = new Button(this);
            // Tag を設定する
            button[i].setTag(String.valueOf(i));
            button[i].setText(String.format(Locale.US, "Button %d", i));

            LinearLayout.LayoutParams buttonLayoutParams =
                    new LinearLayout.LayoutParams(buttonWidth,
                            ViewGroup.LayoutParams.WRAP_CONTENT);
            buttonLayoutParams.setMargins(margins, margins, margins, margins);

            button[i].setLayoutParams(buttonLayoutParams);
            layout.addView(button[i]);

            // Listnerをセット
            button[i].setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    // View からTagを取り出す
                    textView.setText(String.format(Locale.US,
                            "Button: %s", view.getTag().toString()));
                }
            });
        }
    }
}
