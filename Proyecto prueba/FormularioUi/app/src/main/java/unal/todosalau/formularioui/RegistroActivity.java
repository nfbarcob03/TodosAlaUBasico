package unal.todosalau.formularioui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Button buttonLogin = findViewById(R.id.buttonLogin);

        CheckBox checkBox = findViewById(R.id.checkBoxTemrinos);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox.isChecked()==true){
                    buttonLogin.setTextColor(Color.WHITE);
                }else{
                    buttonLogin.setTextColor(Color.GRAY);
                }
                //buttonLogin.setEnabled(checkBox.isChecked());

            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(checkBox.isChecked()==true){
                    Intent intent = new Intent(RegistroActivity.this, Home.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                }else{
                    Toast.makeText(RegistroActivity.this,
                            "Debe aceptar terminos y condiciones primero!", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        this.overridePendingTransition(R.anim.slide_from_left,
                R.anim.slide_to_right);
    }


}