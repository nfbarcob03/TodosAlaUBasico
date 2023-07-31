package unal.todosalau.transcitions;

import static android.view.animation.Animation.INFINITE;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.titulo);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        animation.setRepeatCount(4);
        animation.setRepeatMode(1);
        textView.startAnimation(animation);

    }
}