package com.example.proyectofiscmovil.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.proyectofiscmovil.R;

public class MenuModuloDocentesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_modulo_docentes);
    }

    public void docentesEncuestadosBTN(View view) {
        Intent i = new Intent(getApplicationContext(), DocentesEncuestadosActivity.class);
        startActivity(i);
    }

    public void docentesSinContestarBTN(View view){

        Intent i = new Intent(getApplicationContext(), DocentesNoEncuestadosActivity.class);
        startActivity(i);

    }

    public void encuestaDocenesBTN(View view) {

        Intent i = new Intent(getApplicationContext(),SplashScreenEncuestaDocentes.class);
        startActivity(i);

    }


}