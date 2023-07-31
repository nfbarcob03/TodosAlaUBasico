package unal.todosalau.repasoui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonBlink, buttonTranslate;

    TextView text;
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonBlink = findViewById(R.id.buttonBlink);
        buttonTranslate = findViewById(R.id.buttonTranslate);

        text = findViewById(R.id.text);
        text1 = findViewById(R.id.text1);

        Animation blinkAnimation = AnimationUtils.loadAnimation(this,R.anim.blink);

        Animation blinkAnimationProgramatic = new AlphaAnimation(1,0);
        blinkAnimationProgramatic.setDuration(1000);
        blinkAnimationProgramatic.setRepeatCount(Animation.INFINITE);


        buttonBlink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                text.startAnimation(blinkAnimationProgramatic);
            }
        });

        Animation translateAnimation = AnimationUtils.loadAnimation(this,R.anim.traslate);
        buttonTranslate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                text.startAnimation(translateAnimation);
            }
        });

    }
}