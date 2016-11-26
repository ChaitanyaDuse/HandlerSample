package com.dnr.handlersample;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Handler hand = new Handler();
    Button clickme;
    TextView timer;
    private int count;
    private final int MAX_TIME = 10;

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);

        timer = (TextView) findViewById(R.id.timer);
        timer.setText(Integer.toString(MAX_TIME));
        clickme = (Button) findViewById(R.id.clickme);
        clickme.setVisibility(View.VISIBLE);

        clickme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = MAX_TIME;

                clickme.setVisibility(View.GONE);
                hand.postDelayed(run, 100);
            }
        });
    }

    Runnable run = new Runnable() {
        @Override
        public void run() {
            updateTime();
        }
    };

    public void updateTime() {

        count--;
        timer.setText(Integer.toString(count));
        if (count == 0) {
            clickme.setVisibility(View.VISIBLE);
            timer.setText(Integer.toString(MAX_TIME));
        } else {

            hand.postDelayed(run, 100);
        }
    }


}
