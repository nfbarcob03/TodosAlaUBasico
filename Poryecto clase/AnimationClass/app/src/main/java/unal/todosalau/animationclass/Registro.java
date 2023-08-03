package unal.todosalau.animationclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    EditText editTextNombre;
    EditText editTextTelefono;
    EditText editTextCorreoRegistro;
    EditText editTextContraseñaRegistro;
    CheckBox checkBoxTerminos;
    Button buttonFinalizaRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextTelefono = findViewById(R.id.editTextTelefono);
        editTextCorreoRegistro = findViewById(R.id.editTextCorreoRegistro);
        editTextContraseñaRegistro = findViewById(R.id.editTextContraseñaRegistro);
        checkBoxTerminos = findViewById(R.id.checkBoxTerminos);
        buttonFinalizaRegistro = findViewById(R.id.buttonFinalizaRegistro);

        checkBoxTerminos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBoxTerminos.isChecked() ==true) {
                    buttonFinalizaRegistro.setTextColor(Color.WHITE);
                }else{
                    buttonFinalizaRegistro.setTextColor(Color.GRAY);
                }
            }
        });

        buttonFinalizaRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean pasaValidaciones = true;
                if(editTextNombre.getText().length()<=0){
                    Toast.makeText(Registro.this,"El nombre es obligatorio",
                            Toast.LENGTH_SHORT).show();
                    pasaValidaciones = false;
                    editTextNombre.setBackgroundColor(Color.RED);
                }else {
                    editTextNombre.setBackgroundColor(Color.WHITE);
                }
                if(editTextCorreoRegistro.getText().length()<=0){
                    Toast.makeText(Registro.this,"El Correo es obligatorio",
                            Toast.LENGTH_SHORT).show();
                    pasaValidaciones = false;
                    editTextCorreoRegistro.setBackgroundColor(Color.RED);
                }else {
                    editTextCorreoRegistro.setBackgroundColor(getResources().getColor(R.color.transparent));
                    editTextCorreoRegistro.setTextColor(Color.BLACK);
                }
                if(editTextContraseñaRegistro.getText().length()<=0){
                    Toast.makeText(Registro.this,"La contraseña es obligatoria",
                            Toast.LENGTH_SHORT).show();
                    pasaValidaciones = false;
                    editTextContraseñaRegistro.setBackgroundColor(Color.RED);

                }else {
                    editTextContraseñaRegistro.setBackgroundColor(Color.WHITE);
                }
                if(checkBoxTerminos.isChecked()==true && pasaValidaciones == true){
                    Intent intent =  new Intent(Registro.this,Home.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slid_from_right, R.anim.slide_to_left);
                }else{
                    Toast.makeText(Registro.this,
                            "Aceptar los terminos y condiciones es OBLIGATORIO",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}