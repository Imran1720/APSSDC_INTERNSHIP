package com.example.sensorsexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.github.nisrulz.sensey.LightDetector;
import com.github.nisrulz.sensey.Sensey;
import com.github.nisrulz.sensey.ShakeDetector;
import com.github.nisrulz.sensey.TouchTypeDetector;

public class MainActivity extends AppCompatActivity {

    Switch shake,touch,light;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shake = findViewById(R.id.shake);
        touch = findViewById(R.id.touch);
        light = findViewById(R.id.light);
        tv = findViewById(R.id.mysensor);

        Sensey.getInstance().init(this);
        ShakeDetector.ShakeListener listener = new ShakeDetector.ShakeListener() {
            @Override
            public void onShakeDetected() {
                tv.setText("Shake Sensor Dtector");
            }

            @Override
            public void onShakeStopped() {
                tv.setText("Shake Sensor stopped");
            }
        };
        shake.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    Sensey.getInstance().startShakeDetection(listener);
                }
                else
                    Sensey.getInstance().stopShakeDetection(listener);
            }
        });

        //light sensor
        LightDetector.LightListener lightListener = new LightDetector.LightListener() {
            @Override
            public void onDark() {
                tv.setText("It is dark here");
            }

            @Override
            public void onLight() {

                tv.setText("It is light here");
            }
        };
        light.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Sensey.getInstance().startLightDetection(lightListener);
                }
                else
                    Sensey.getInstance().stopLightDetection(lightListener);
            }
        });
        //touch
        TouchTypeDetector.TouchTypListener touchTypListener = new TouchTypeDetector.TouchTypListener() {
            @Override
            public void onDoubleTap() {
                tv.setText("Double Tapped");
            }

            @Override
            public void onLongPress() {
                tv.setText("LongPressed");

            }

            @Override
            public void onScroll(int i) {
                tv.setText("Scrolled");

            }

            @Override
            public void onSingleTap() {
                tv.setText("Single Tapped");

            }

            @Override
            public void onSwipe(int i) {
                tv.setText("Swiped");

            }

            @Override
            public void onThreeFingerSingleTap() {
                tv.setText("Three Finger Tap");

            }

            @Override
            public void onTwoFingerSingleTap() {
                tv.setText("Two Finger Tap");

            }
        };
        touch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Sensey.getInstance().startTouchTypeDetection(MainActivity.this,touchTypListener);
                else
                    Sensey.getInstance().stopTouchTypeDetection();
            }

        });


    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Sensey.getInstance().setupDispatchTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onDestroy() {
        Sensey.getInstance().stop();
        super.onDestroy();

    }
    public static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

}