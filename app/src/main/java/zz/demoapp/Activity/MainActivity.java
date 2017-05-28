package zz.demoapp.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import zz.demoapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        stayFor2SecAndLoadDashBoard();
    }

    private void stayFor2SecAndLoadDashBoard() {
       Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent dashBoardIntent = new Intent(MainActivity.this, DashBoardActivity.class);
                startActivity(dashBoardIntent);
            }
        }, 2000);
    }
}
