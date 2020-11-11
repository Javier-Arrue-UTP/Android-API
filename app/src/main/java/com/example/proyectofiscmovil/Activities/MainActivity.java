package com.example.proyectofiscmovil.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.proyectofiscmovil.R;

public class MainActivity extends AppCompatActivity {

    private Button goLogin;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void inicializarControles(){
        goLogin = findViewById(R.id.btnLogin);
    }


    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:
                intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
