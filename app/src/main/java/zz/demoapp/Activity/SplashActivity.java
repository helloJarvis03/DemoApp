package zz.demoapp.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.Display;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Locale;

import zz.demoapp.R;
import zz.demoapp.common.AnimationTypes;
import zz.demoapp.common.CommonHelperImpl;
import zz.demoapp.common.ScreenDimensions;

public class SplashActivity extends Activity implements TextToSpeech.OnInitListener{

    CommonHelperImpl commonHelper = new CommonHelperImpl();
    public static ScreenDimensions screenDimensions;
    RelativeLayout rl;
    public static  Context context;
    TextToSpeech tts;
    EditText ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(R.layout.activity_splash);
        rl = (RelativeLayout) findViewById(R.id.activity_main);
        tts = new TextToSpeech(this, this);

//     stayForAWhileAndLoadNextActivity(50000, SplashActivity.this, DashBoardActivity.class);

        Display display = getWindowManager().getDefaultDisplay();
        screenDimensions = commonHelper.getScreenDimensions(display);

        createJarvisUI();

        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                commonHelper.speakOut(context, tts, "Please type your name");
            }
        }, 5000);
//        ed = new EditText(context);
//        ed.setLayoutParams(new RelativeLayout.LayoutParams(screenDimensions.getX()/2, screenDimensions.getY()/4));
//        ed.setX(screenDimensions.getX()/2);
//        ed.setY(screenDimensions.getY()/2);
//        ed.setBackgroundColor(Color.WHITE);
//        ed.setAlpha(0.5f);
//        rl.addView(ed);


    }

    private void stayForAWhileAndLoadNextActivity(int miliseconds, final Context context, final Class<?> cls) {
       Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent dashBoardIntent = new Intent(SplashActivity.this, DashBoardActivity.class);
                startActivity(dashBoardIntent);
            }
        }, miliseconds);
    }

    private void createJarvisUI()
    {
        ImageView iv = null;
        iv = getTheImageDrawn(R.drawable.ring_bg_greenish);
        iv = getTheImageDrawn(R.drawable.jarvis_ring_1_cyan);
        iv = getTheImageDrawn(R.drawable.jarvis_ring_2_cyan);
        commonHelper.animateIt(iv, AnimationTypes.ROTATION_CLOCKWISE.getAnimationType());

        iv = getTheImageDrawn(R.drawable.jarvis_ring_3_cyan);
        iv = getTheImageDrawn(R.drawable.jarvis_ring_4_cyan);
        commonHelper.animateIt(iv, AnimationTypes.ROTATION_ANTICLOCKWISE.getAnimationType());
        iv = getTheImageDrawn(R.drawable.jarvis_ring_5_cyan);
    }

    private ImageView getTheImageDrawn(int imageId)
    {
        Drawable srcDrawable = getDrawable(imageId);
        ImageView iv;
        iv = commonHelper.drawImage(context, rl, srcDrawable);
        iv.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        return iv;

    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
             tts.setLanguage(Locale.US);
        }
    }

    @Override
    protected void onDestroy() {
        if(tts != null) {
            tts.stop();
            tts.shutdown();
        }
        finish();
        super.onDestroy();
    }
}
