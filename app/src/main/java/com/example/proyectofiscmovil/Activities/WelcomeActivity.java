package com.example.proyectofiscmovil.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectofiscmovil.R;

public class WelcomeActivity extends AppCompatActivity
{
    private TextView tvCedula, tvRol;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        this.inicializarControles();
    }

    private void inicializarControles()
    {
        tvCedula = findViewById(R.id.tvCedula);
        tvRol = findViewById(R.id.tvRol);

        this.showDate();
    }

    private void showDate()
    {

        intent = getIntent();
        int rol = intent.getIntExtra("rol",0);
        String ced = intent.getStringExtra("cedula");

        tvCedula.setText(ced);
        tvRol.setText(String.valueOf(rol));
        Toast.makeText(getApplicationContext(), "El rol es: " + rol + " La cedula es: "+ ced, Toast.LENGTH_LONG).show();
    }


}