package unal.todosalau.formularioui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIMEOUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView imageViewLogo = findViewById(R.id.imageViewLogo1);
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(1500);
        imageViewLogo.startAnimation(fadeIn);

        imageViewLogo.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }, SPLASH_TIMEOUT);
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        ImageView logo = findViewById(R.id.imageViewLogo1);
        logo.removeCallbacks(null);
    }
}