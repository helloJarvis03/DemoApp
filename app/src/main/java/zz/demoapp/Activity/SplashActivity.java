package zz.demoapp.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import zz.demoapp.R;

public class SplashActivity extends Activity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onStart() {
        super.onStart();
        stayFor2SecAndLoadDashBoard();

        tv = (TextView) findViewById(R.id.textView2);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
        tv.startAnimation(animation);

    }

    private void stayFor2SecAndLoadDashBoard() {
       Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent dashBoardIntent = new Intent(SplashActivity.this, DashBoardActivity.class);
                startActivity(dashBoardIntent);
            }
        }, 10000);
    }
}
