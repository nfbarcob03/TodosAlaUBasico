package unal.todosalau.allanimation;

import static android.util.Log.INFO;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1,button2,button3,button4,button5,button6, button7;
    TextView text;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 =  findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3= findViewById(R.id.button3);
        button4= findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);

        text = findViewById(R.id.text);

        //blink animation
        Animation blinkAnimation = AnimationUtils.loadAnimation(this, R.anim.blink);
        Animation blinkAnimationProgramatic = new AlphaAnimation(0,1);
        blinkAnimationProgramatic.setRepeatMode(Animation.REVERSE);
        blinkAnimationProgramatic.setRepeatCount(Animation.INFINITE);
        blinkAnimationProgramatic.setDuration(1000);
        blinkAnimationProgramatic.setInterpolator(new DecelerateInterpolator());

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  mensaje = "¡Botón Blinck presionado!";
                String TAG = "MiApp";
                Toast.makeText(MainActivity.this,
                        mensaje,
                        Toast.LENGTH_LONG).show();
                Log.d(TAG, "Mensaje de depuración"); // Mensaje de depuración
                Log.i(TAG, "Mensaje de información"); // Mensaje de información
                Log.w(TAG, "Mensaje de advertencia"); // Mensaje de advertencia
                Log.e(TAG, "Mensaje de error"); // Mensaje de error

                text.startAnimation(blinkAnimationProgramatic);
            }
        });

        //Trtanslate animation
        Animation translateAnimation = AnimationUtils.loadAnimation(this, R.anim.translate);
        Animation translateAnimationProgramatic = new TranslateAnimation(0,500,0,500);
        translateAnimationProgramatic.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimationProgramatic.setFillAfter(true);
        translateAnimationProgramatic.setDuration(1000);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.startAnimation(translateAnimationProgramatic);
            }
        });

        //Fade

        Animation fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.fade);
        Animation fadeAnimationProgramatic = new AlphaAnimation(1, 0);
        fadeAnimationProgramatic.setDuration(1000);
        fadeAnimationProgramatic.setInterpolator(new LinearInterpolator());

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.startAnimation(fadeAnimationProgramatic);
            }
        });


        //ZoomIn

        Animation zoomInAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        Animation zoomInAnimationProgramatic = new ScaleAnimation(1,3,1,3,Animation.RELATIVE_TO_SELF,(float)0.5,Animation.RELATIVE_TO_SELF,(float)0.5);
        zoomInAnimationProgramatic.setDuration(1000);
        zoomInAnimationProgramatic.setFillAfter(true);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.startAnimation(zoomInAnimationProgramatic);
            }
        });

        //ZoomOut

        Animation zoomOutAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom_out);
        Animation zoomOutAnimationProgramatic = new ScaleAnimation(3,1,3,1,Animation.RELATIVE_TO_SELF,(float)0.5,Animation.RELATIVE_TO_SELF,(float)0.5);
        zoomOutAnimationProgramatic.setDuration(1000);
        zoomOutAnimationProgramatic.setInterpolator(new LinearInterpolator());
        zoomOutAnimationProgramatic.setFillAfter(true);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.startAnimation(zoomOutAnimationProgramatic);
            }
        });

        //Rotate

        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        //Animation rotateAnimationProgramatic = new RotateAnimation(0,720,Animation.RELATIVE_TO_SELF,(float)0.5,Animation.RELATIVE_TO_SELF,(float)0.5);
        Animation rotateAnimationProgramatic = new RotateAnimation(0,720,Animation.RELATIVE_TO_SELF,(float)0.5,Animation.RELATIVE_TO_SELF,(float)0.5);
        rotateAnimationProgramatic.setDuration(1000);
        rotateAnimationProgramatic.setInterpolator(new LinearInterpolator());
        rotateAnimationProgramatic.setFillAfter(true);
        rotateAnimationProgramatic.setRepeatCount(Animation.INFINITE);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.startAnimation(rotateAnimationProgramatic);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.clearAnimation();
            }
        });
    }
}