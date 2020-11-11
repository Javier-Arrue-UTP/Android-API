package com.example.proyectofiscmovil.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectofiscmovil.R;

public class EncuestaDocenteContestadaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta_docente_contestada);
    }

    public void NuevaEncuesta(View view){
        Intent i = new Intent(getApplicationContext(), EncuestaDocentesActivity.class);
        startActivity(i);
    }

    public void MenuEncuestas(View view){
        //Intent i = new Intent(getApplicationContext(),DocentesEncuestados.class);
        //startActivity(i);

        Intent i = new Intent(getApplicationContext(), DocentesEncuestadosActivity.class);
        startActivity(i);
    }


}
