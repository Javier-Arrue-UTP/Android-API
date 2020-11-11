package com.example.proyectofiscmovil.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyectofiscmovil.Models.Asignaturas;
import com.example.proyectofiscmovil.Models.Grupos;
import com.example.proyectofiscmovil.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class EncuestaDocentesActivity extends AppCompatActivity {
    private RequestQueue mQueue;
    private Spinner gruposSpinner,asignaturasSpinner,spinSemestre;;
    private LinearLayout linearLayout;
    EditText cedulaTxt;
    Button btnEnviar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta_docentes);

        inicalizarControles();
        grupos();
        asignaturas();
    }


    private void inicalizarControles() {

        cedulaTxt = (EditText)findViewById(R.id.cedula);

        mQueue = Volley.newRequestQueue(this);

        spinSemestre = findViewById(R.id.spinnerSemestre);
        gruposSpinner = (Spinner) findViewById(R.id.spinnerGrupos);
        asignaturasSpinner = (Spinner) findViewById(R.id.spinnerAsignaturas);

        linearLayout = (LinearLayout) findViewById(R.id.activity_prueba);

        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        this.LoadSpinnerSemestre();
    }

    public void validacionDocente(View view){

        Grupos grupo = (Grupos) gruposSpinner.getSelectedItem();
        Asignaturas asignatura = (Asignaturas) asignaturasSpinner.getSelectedItem();

        String cedula = cedulaTxt.getText().toString();
        String grupos = Integer.toString(grupo.getId_grupo());
        String asignaturas = Integer.toString(asignatura.getIdAsignatura());

        Toast.makeText(this, "Validando...", Toast.LENGTH_LONG).show();


        validacionAPI(cedula,grupos,asignaturas);


    }

    /*Validacion del docente
    * Se validara lo siguiente:
    * 1. Si la cedula existe.
    * 2. Si ya contesto la encuesta para: la asignatura, grupo y el año.
    * 3. Si escogio la asignatura y grupo que le corresponde.
    * */
    private void validacionAPI(String cedula, String grupo, String asignatura){

        String url = "http://192.168.0.6/ProyectoFinal/api/docentes/validarDocente";


        Map<String, String> params = new HashMap<String, String>();
        params.put("cedula", cedula);
        params.put("asignaturas", asignatura);
        params.put("grupos", grupo);

        JsonObjectRequest request = new JsonObjectRequest (Request.Method.POST, url, new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {

                            String mensaje = response.getString("Mensaje");
                            String validacion = response.getString("validacion");

                            Toast.makeText(EncuestaDocentesActivity.this, response.toString(), Toast.LENGTH_SHORT).show();

                            /*El API devolvera un mensaje:
                            * Si el campo "Validacion" es *Si*, se le permite realizar la encuesta
                            * En cambio si devuelve *No*, no lo dejara continuar.
                            * */
                            if(validacion.equals("Si")){
                                Toast.makeText(getApplicationContext(), "Encuesta Generada", Toast.LENGTH_LONG).show();
                                //Una vez validado, se genera la encuesta.
                               preguntas();
                               btnEnviar.setVisibility(View.VISIBLE);

                            }else{
                                Toast.makeText(EncuestaDocentesActivity.this, mensaje, Toast.LENGTH_LONG).show();
                            }


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


    /*Lista de Grupos que iran en el Spinner.*/
    private void grupos() {
        String url = "http://192.168.0.6/ProyectoFinal/api/docentes/gruposLista";

        final ArrayList<Grupos> gruposLista = new ArrayList<Grupos>();

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {

                            for(int i = 0 ; i<response.length(); i++){
                                JSONObject resultado = response.getJSONObject(i);

                                int id_grupo = resultado.getInt("id_grupo");
                                String cod_grupo = resultado.getString("cod_grupo");
                                String turno = resultado.getString("turno");
                                String semestre = resultado.getString("semestre");
                                String año = resultado.getString("año");
                                String id_carrera = resultado.getString("id_carrera");
                                String id_sede = resultado.getString("id_sede");

                                gruposLista.add(new Grupos(id_grupo,cod_grupo,turno,semestre,año,id_carrera,id_sede));
                            }
                            ArrayAdapter<Grupos> adapter = new ArrayAdapter<>(getApplicationContext(),
                                    R.layout.support_simple_spinner_dropdown_item,gruposLista);

                            gruposSpinner.setAdapter(adapter);

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

    //Listado de Asignaturas que iran en el Spinner
    private void asignaturas() {
        String url = "http://192.168.0.6/ProyectoFinal/api/docentes/asignaturasLista";

        final ArrayList<Asignaturas> asignaturaLista = new ArrayList<Asignaturas>();

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {

                            for(int i = 0 ; i<response.length(); i++){

                                JSONObject resultado = response.getJSONObject(i);

                                int idAsignatura = resultado.getInt("id_asignatura");
                                String codAsignatura = resultado.getString("cod_asignatura");
                                String nombre = resultado.getString("nombre");

                                asignaturaLista.add(new Asignaturas(idAsignatura,codAsignatura,nombre));

                            }
                            ArrayAdapter<Asignaturas> adapter = new ArrayAdapter<>(getApplicationContext(),
                                    R.layout.support_simple_spinner_dropdown_item,asignaturaLista);

                            asignaturasSpinner.setAdapter(adapter);


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

    //Preguntas que conforman la encuesta.
    private void preguntas() {

        String url = "http://192.168.0.6/ProyectoFinal/api/docentes/preguntasDocentes";


        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {

                            int idActual = -1;

                            LinearLayout nuevoLayout = new LinearLayout(getApplicationContext());
                            //Seteando Orientacion del nuevo layout
                            nuevoLayout.setOrientation(LinearLayout.VERTICAL);
                            //Y tambien el width y height
                            nuevoLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

                            /*Durante el Bucle es importante validar que no muestre preguntas repetidas.
                            * Esto sucede debido a la consulta que se realiza a la Base de datos.
                            * */
                            for(int i = 0 ; i<response.length(); i++){

                                JSONObject resultado = response.getJSONObject(i);

                                //Capturo resultados
                                int idPregunta = resultado.getInt("id_pregunta");
                                String descripPreg = resultado.getString("descrip_preg");
                                String tipoPreg = resultado.getString("tipo_preg");

                                //Elementos que seran generados Dinamicamente:
                                //Descripcion de la pregunta
                                TextView pregunta = new TextView(getApplicationContext());
                                //Descripcion de opcion
                                TextView opDescripcion = new TextView(getApplicationContext());
                                //Campo para escribir
                                EditText respuesta = new EditText(getApplicationContext());
                                //Grupo de botones radio
                                RadioGroup radioGroup = new RadioGroup(getApplicationContext());
                                RadioGroup.LayoutParams layoutParams;
                                radioGroup.setOrientation(RadioGroup.VERTICAL);

                                //Validacion para no mostrar preguntas repetidas
                                if(idActual != idPregunta){
                                    //Actualiza el id de pregunta.
                                    idActual = idPregunta;

                                    //Se setea la descripcion de la pregunta.
                                    // Esto debe suceder una ves por pregunta
                                    pregunta.setText(descripPreg);
                                    pregunta.setId(idPregunta); //ID de la pregunta
                                    pregunta.setTextColor(Color.BLACK);
                                    pregunta.setTextSize(15.f);

                                    //Añade la descripcion de la pregunta a la vista
                                    linearLayout.addView(pregunta);

                                    //Si la pregunta es abierta muestra un campo para escribir
                                    if(tipoPreg.equals("A")){
                                        respuesta.setId(i);
                                        //Añade el campo a la vista.
                                        linearLayout.addView(respuesta);
                                    }else{
                                        // Si la pregunta es cerrada:
                                        /* Debe validarse que tipo de pregunta cerrada es (CR o CC).
                                            Se crea un bucle interno, aqui se listaran las OPCIONES de la pregunta.
                                        * */
                                        for(int j = 0; j<response.length();j++){

                                            //Actualiza el resultado, ya que esta en otro bucle.
                                            resultado = response.getJSONObject(j);

                                            //Captura la descripcion de la OPCION.
                                            String descripOpcion = resultado.getString("descrip_opcion");

                                            //Opcion de pregunta Radio Button
                                            RadioButton radioButton = new RadioButton(getApplicationContext());
                                            //Opcion de pregunta CheckBox
                                            CheckBox checkBox = new CheckBox(getApplicationContext());

                                            //Validacion para que solo muestre las OPCIONES de la pregunta ACTUAL.
                                            //Si el ID de la pregunta actual es 35, entonces solo mostrará las opciones
                                            // que esten relacionadas con ese ID.
                                            if(idActual == resultado.getInt("id_pregunta") && !tipoPreg.equals("A")){

                                                //Primero revisa si tiene algun campo para escribir
                                                if(descripOpcion.equals("Otros escriba")){
                                                    respuesta.setId(j);
                                                    opDescripcion.setText("Otros escriba");
                                                    opDescripcion.setTextSize(12.f);
                                                    opDescripcion.setTextColor(Color.BLACK);
                                                    linearLayout.addView(opDescripcion);
                                                    linearLayout.addView(respuesta);

                                                }else{ //Si no tiene ahora verifica que tipo de pregunta cerrada es
                                                    //CR = Pregunta cerrada de unica seleccion
                                                    if(resultado.getString("tipo_preg").equals("CR")){
                                                        radioButton.setId(j);
                                                        radioButton.setText(descripOpcion);
                                                        layoutParams = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT,RadioGroup.LayoutParams.WRAP_CONTENT);
                                                        radioGroup.addView(radioButton,layoutParams);

                                                    }else{
                                                        //CC = Pregunta cerrada de seleccion multiple (CheckBox)
                                                        checkBox.setId(j);
                                                        checkBox.setText(descripOpcion);
                                                        checkBox.setTag(descripOpcion);

                                                        linearLayout.addView(checkBox);
                                                    }
                                                }


                                            }

                                        }
                                        //Añade las opciones de una seleccion a el layout.
                                        linearLayout.addView(radioGroup);

                                    }

                                }

                            }

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


    private void LoadSpinnerSemestre(){
        ArrayAdapter<CharSequence> adapterXML = ArrayAdapter.createFromResource
                (this, R.array.Semestre,R.layout.support_simple_spinner_dropdown_item);
        ArrayAdapter<String> adapterList = new ArrayAdapter<>
                (this,R.layout.support_simple_spinner_dropdown_item);
        spinSemestre.setAdapter(adapterXML);
    }

    //boton para enviar encuesta
    public void EnviarEncuesta(View view){
        //String asignaturaSeleccionado = spinAsignatura.getSelectedItem().toString();
        //String carreraSeleccionado = spinCarrera.getSelectedItem().toString();
        //String semestreSeleccionado = spinSemestre.getSelectedItem().toString();

        try{
            if(/*spinAsignatura.getSelectedItemPosition() == 0 || spinCarrera.getSelectedItemPosition() == 0  ||*/ spinSemestre.getSelectedItemPosition() == 0){
                Toast.makeText(this, "Debes seleccionar la Asignatura, Carrera y Semestre.", Toast.LENGTH_LONG).show();
            }else{
                Intent i = new Intent(getApplicationContext(), EncuestaDocenteContestadaActivity.class);
                startActivity(i);
            }
        }
        catch(Exception e){ Toast.makeText(this, "Error crack "+e, Toast.LENGTH_SHORT).show();
        }
    }


}