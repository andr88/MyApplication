package com.example.john.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private boolean flag = false;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        textView = findViewById(R.id.text_view);
        layout = findViewById(R.id.lay);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.setGravity(Gravity.BOTTOM);
                // flagがtrueの時
                if (flag) {
                    //textView.setText(R.string.hello);
                    textView.setText(R.string.hello);

                    flag = false;
                }
                // flagがfalseの時
                else {
                    //textView.setText(R.string.world);
                    textView.setText(R.string.world);
                    flag = true;
                }
            }
        });



    }
}
