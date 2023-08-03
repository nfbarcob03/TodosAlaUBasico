package unal.todosalau.formularioui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class FormularioIncidencia extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_incidencia);

        RadioGroup opcionesRadioGroup = findViewById(R.id.radiGroupUbication);

        EditText editTextDireccionCiudad = findViewById(R.id.editTextDireccionCiudad);
        EditText editTextIndicacionesCampo= findViewById(R.id.editTextIndicacionesCampo);

        opcionesRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                String opcionSeleccionada = radioButton.getText().toString();
                Toast.makeText(FormularioIncidencia.this,
                        "Seleccionaste " + opcionSeleccionada
                        +" Ingresa el resto de informacion solicitada", Toast.LENGTH_SHORT).show();

                if(radioButton.getId() == R.id.radioButtonCiudad){
                    editTextDireccionCiudad.setVisibility(View.VISIBLE);
                    editTextIndicacionesCampo.setVisibility(View.GONE);
                }else if (radioButton.getId() == R.id.radioButtonCampo){
                    editTextDireccionCiudad.setVisibility(View.GONE);
                    editTextIndicacionesCampo.setVisibility(View.VISIBLE);
                }

            }
        });
    }





}