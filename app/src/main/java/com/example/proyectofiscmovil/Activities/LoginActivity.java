package com.example.proyectofiscmovil.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyectofiscmovil.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.android.volley.Request.Method.POST;

public class LoginActivity extends AppCompatActivity
{

    private EditText cedula, clave;
    private TextView tvCedula, tvRol;

    RequestQueue queue;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.inicializarControles();
    }

    private void inicializarControles()
    {
        cedula = findViewById(R.id.edCedula);
        clave = findViewById(R.id.edClave);

        tvCedula = findViewById(R.id.tvCedula);
        tvRol = findViewById(R.id.tvRol);
    }


    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btnLogear:

                if(!cedula.getText().toString().isEmpty()||!clave.getText().toString().isEmpty())
                {
                    validadUsuario("http://192.168.0.109/conectarBDFisc/pruebaConsultarUsuario.php");
                }
                else
                    {
                    Toast.makeText(LoginActivity.this, "No deje espacios en blancos", Toast.LENGTH_SHORT).show();
                    }

                break;

        }
    }

    private void validadUsuario(String URL)
    {
        StringRequest stringRequest = new StringRequest(POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                if(!response.isEmpty())
                {
                    enviarDatos("http://192.168.0.109/conectarBDFisc/buscar_rol.php?cedula="+cedula.getText().toString()+"");

                }else {
                    Toast.makeText(LoginActivity.this, "Usuario o Pass Erradas", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(LoginActivity.this, "Hay un errpr "+error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String,String> parametros = new HashMap<String, String>();
                parametros.put("cedula",cedula.getText().toString());
                parametros.put("clave",clave.getText().toString());
                return parametros;
            }
        };

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }

    public void enviarDatos(String URL)
    {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response)
            {
                JSONObject jsonObject = null;
                try
                {
                    jsonObject = response.getJSONObject(0);
                    tvCedula.setText(jsonObject.getString("cedula"));
                    int rolsito = jsonObject.getInt("id_rol_usuario");
                    String ced = jsonObject.getString("cedula");
                    tvRol.setText(String.valueOf((jsonObject.getInt("id_rol_usuario"))));

                    Toast.makeText(getApplicationContext(),"LOGEADO", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
                    intent.putExtra("rol",rolsito);
                    intent.putExtra("cedula", ced);
                    startActivity(intent);
                }
                catch (JSONException e)
                {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {

            }
        });
        queue = Volley.newRequestQueue(this);
        queue.add(jsonArrayRequest);
    }
}