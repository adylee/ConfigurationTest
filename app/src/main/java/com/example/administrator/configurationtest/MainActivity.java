package com.example.administrator.configurationtest;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ori;
    EditText navigation;
    EditText touch;
    EditText mnc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ori = (EditText)findViewById(R.id.ori);
        navigation = (EditText)findViewById(R.id.navigation);
        touch = (EditText)findViewById(R.id.touch);
        mnc = (EditText)findViewById(R.id.mnc);
        Button bn = (Button)findViewById(R.id.button);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Configuration cfg = getResources().getConfiguration();
                String screen = cfg.orientation == Configuration.ORIENTATION_LANDSCAPE
                        ?"横向屏":"竖向屏";
                String mncCode = cfg.mnc+"";
                String naviName = cfg.orientation == Configuration.NAVIGATION_NONAV
                        ?"木有方向控制":
                        cfg.orientation == Configuration.NAVIGATION_WHEEL
                        ?"滚动控制方向":
                                cfg.orientation == Configuration.NAVIGATION_DPAD
                        ?"方向键控制方向":"轨迹球控制方向";
                navigation.setText(naviName);
                String touchName = cfg.touchscreen ==
                        Configuration.TOUCHSCREEN_NOTOUCH
                        ?"无触摸屏":"支持触摸屏";
                ori.setText(screen);
                mnc.setText(mncCode);
                touch.setText(touchName);
            }
        });
    }
}
