package unal.todosalau.animationclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class FormularioGastoAgua extends AppCompatActivity {

    EditText ediTextMinutosCorriendoAgua;

    RadioGroup radioGroupConoceFlujo;

    EditText ediTextFlujoLitrosSegundo;

    Button buttonCalcularConsumo;

    final double  flujoGenerico = 0.2;

    double flujo = 0;

    boolean siConoceFlujo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_gasto_agua);
        radioGroupConoceFlujo = findViewById(R.id.radioGroupConoceFlujo);
        ediTextMinutosCorriendoAgua = findViewById(R.id.ediTextMinutosCorriendoAgua);
        ediTextFlujoLitrosSegundo = findViewById(R.id.ediTextFlujoLitrosSegundo);
        buttonCalcularConsumo = findViewById(R.id.buttonCalcularConsumo);

        radioGroupConoceFlujo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);


                if(radioButton.getId() == R.id.radioButtonSiConoce){
                    ediTextFlujoLitrosSegundo.setVisibility(View.VISIBLE);
                    siConoceFlujo = true;
                }else if(radioButton.getId() == R.id.radioButtonNoConoce){
                    Toast.makeText(FormularioGastoAgua.this,
                            "Se hara el calculo por defecto con un flujo generico de" + flujoGenerico,
                            Toast.LENGTH_LONG).show();
                    ediTextFlujoLitrosSegundo.setVisibility(View.GONE);
                    siConoceFlujo = false;
                    flujo = flujoGenerico;
                }
            }

        });

        buttonCalcularConsumo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Boolean pasaValidaciones = true;
                if(ediTextMinutosCorriendoAgua.getText().length()<=0){
                    Toast.makeText(FormularioGastoAgua.this,"El tiempo de consumo es obligatorio (en minutos)",
                            Toast.LENGTH_SHORT).show();
                    pasaValidaciones = false;
                }
                if(siConoceFlujo == true){
                    if(ediTextFlujoLitrosSegundo.getText().length()<=0){
                        Toast.makeText(FormularioGastoAgua.this,"Si conoce el flujo de la llave debe colocar un valor (en Litros/Segundo)",
                                Toast.LENGTH_SHORT).show();
                        pasaValidaciones = false;
                    }else{
                        flujo = Double.parseDouble(ediTextFlujoLitrosSegundo.getText().toString());
                    }
                }

                if(pasaValidaciones == true){

                    double gasto = Double.parseDouble(ediTextMinutosCorriendoAgua.getText().toString()) * flujo;
                    Toast.makeText(FormularioGastoAgua.this,
                            "Se registra el gasto de "+ gasto + " litros de agua! Ahorra!!",
                            Toast.LENGTH_LONG).show();
                }


            }
        });

    }
}