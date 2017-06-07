package zz.demoapp.common;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.speech.tts.TextToSpeech;
import android.view.Display;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Locale;

import zz.demoapp.Activity.SplashActivity;


public class CommonHelperImpl{


    public ScreenDimensions getScreenDimensions(Display display){
        Point p = new Point();
        display.getSize(p);
        return new ScreenDimensions(p.x, p.y);
    }

    public ImageView drawImage(Context ctx,RelativeLayout rl, Drawable srcDrawable)
    {
        ImageView iv = new ImageView(ctx);
        iv.setImageDrawable(srcDrawable);
        android.view.ViewGroup.LayoutParams lp = new android.view.ViewGroup.LayoutParams(android.view.ViewGroup.LayoutParams.WRAP_CONTENT, android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
//        lp.height = 300;
//        lp.width = 600;

        iv.setLayoutParams(lp);
        iv.setX(0);
        iv.setY(0);
        iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        rl.addView(iv);

        return iv;
    }

    public void animateIt(View view, String animationTyoe)
    {
        RotateAnimation rotateAnimation = null;

        if (animationTyoe.equals(AnimationTypes.ROTATION_CLOCKWISE.getAnimationType()))
        {
            rotateAnimation = new RotateAnimation(0, 3600, Animation.RELATIVE_TO_SELF,
                    0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        }
        else if (animationTyoe.equals(AnimationTypes.ROTATION_ANTICLOCKWISE.getAnimationType()))
        {
            rotateAnimation = new RotateAnimation(1800, 0, Animation.RELATIVE_TO_SELF,
                    0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        }

        //lastly, set duration
        rotateAnimation.setDuration(45000);
        view.startAnimation(rotateAnimation);
    }

    public void speakOut(Context context, TextToSpeech tts,  String str)
    {

        Toast.makeText(context, "common helper", Toast.LENGTH_SHORT).show();
        tts.setLanguage(Locale.UK);
        tts.speak(str, TextToSpeech.QUEUE_FLUSH, null);
    }
}
