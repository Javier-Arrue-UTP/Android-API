package com.example.proyectofiscmovil.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyectofiscmovil.Adapters.DocentesListViewAdapter;
import com.example.proyectofiscmovil.Models.Docentes;
import com.example.proyectofiscmovil.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DocentesEncuestadosActivity extends AppCompatActivity {

    ListView listaDocentesEncuestados;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docentes_encuestados);
        
        inicializarControles();

        docentesListViewApi();
    }



    private void inicializarControles() {

        listaDocentesEncuestados = findViewById(R.id.listaDocentesEncuestados);
        mQueue = Volley.newRequestQueue(this);

    }

    private void docentesListViewApi() {

        final List<Docentes> list = new ArrayList<>();

        String url = "http://192.168.0.6/ProyectoFinal/api/docentes/docentesRespondido";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {

                            String cedula, grupo, asignatura, semestre;

                            for(int i = 0 ; i<response.length(); i++){

                                JSONObject resultado = response.getJSONObject(i);

                                cedula = resultado.getString("cedula");
                                asignatura = resultado.getString("nombre");
                                grupo = resultado.getString("cod_grupo");
                                semestre = resultado.getString("semestre");

                                list.add(new Docentes(cedula,asignatura,semestre,grupo));

                            }

                            DocentesListViewAdapter adapter = new DocentesListViewAdapter(getApplicationContext(),list);
                            listaDocentesEncuestados.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        request.setRetryPolicy(new DefaultRetryPolicy(
                15000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        mQueue.add(request);


    }

}