package unal.todosalau.animationclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonIngresar;
    Button buttonRegistro;
    EditText editTextCorreo,editTextPassword;
    TextView textViewTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tituloView = findViewById(R.id.textViewTitulo);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_out);
        tituloView.startAnimation(animation);
        buttonRegistro = findViewById(R.id.buttonRegistro);
        buttonIngresar =  findViewById(R.id.buttonIngresar);
        editTextCorreo =  findViewById(R.id.editTextCorreo);
        editTextPassword = findViewById(R.id.editTextPassword);
        textViewTitulo = findViewById(R.id.textViewTitulo);

        // Animacion Rotacion Programatica Boton
        Animation rotateAnimationProgramatic = new RotateAnimation(0,360,
                Animation.RELATIVE_TO_SELF,(float)0.5,Animation.RELATIVE_TO_SELF,(float)0.5);
        rotateAnimationProgramatic.setDuration(200);
        rotateAnimationProgramatic.setRepeatCount(4);
        //rotateAnimationProgramatic.setStartOffset(0);

        buttonIngresar.startAnimation(rotateAnimationProgramatic);

        // Animacion aparecer XML input email
        Animation fadeInAnimationXml = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        editTextCorreo.startAnimation(fadeInAnimationXml);

        // Animacion aparecer programatica input password
        Animation fadeInAnimationProgramatic = new AlphaAnimation(0,1);
        fadeInAnimationProgramatic.setDuration(2000);
        editTextPassword.startAnimation(fadeInAnimationProgramatic);

        // Animacion trasladar XML de izquierda al centro
        Animation traslateXml = AnimationUtils.loadAnimation(this,R.anim.slide_from_left);
        textViewTitulo.setAnimation(traslateXml);

        buttonIngresar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(MainActivity.this, Home.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slid_from_right, R.anim.slide_to_left);
            }
        });

        buttonRegistro.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(MainActivity.this, Registro.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slid_from_right, R.anim.slide_to_left);
            }
        });
    }
}