package unal.todosalau.animationclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    Button buttonRegistroConsumo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        buttonRegistroConsumo = findViewById(R.id.buttonRegistroConsumo);

        buttonRegistroConsumo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(Home.this,FormularioGastoAgua.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slid_from_right, R.anim.slide_to_left);
            }
        });
    }
}