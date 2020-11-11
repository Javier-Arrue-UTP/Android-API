package com.example.proyectofiscmovil.HttpRequest;

import android.content.Context;

import androidx.annotation.Nullable;

import com.android.volley.Request;

import java.util.Map;

public class SurveyRequest extends  BaseRequest {
    public SurveyRequest(Context context) {
        super(context);
    }

    public void PostProfessorSurvey(@Nullable Map<String, Object> parameters, final CustomListener<Object> listener) throws Exception {
        try
        {
            this.ExecuteRequest(parameters,listener, "api/guardarEncuestaDocentes", Request.Method.GET);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

    public void GetIsSurveyRespond(@Nullable Map<String, Object> parameters, final CustomListener<Object> listener) throws Exception {
        try
        {
            this.ExecuteRequest(parameters,listener, "allest", Request.Method.GET);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

    public void GetGraduateSurveyRespond(@Nullable Map<String, Object> parameters, final CustomListener<Object> listener) throws Exception {
        try
        {
            this.ExecuteRequest(parameters,listener, "egresado", Request.Method.GET);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

    public void PostGraduateSurvey(@Nullable Map<String, Object> parameters, final CustomListener<Object> listener) throws Exception {
        try
        {
            this.ExecuteRequest(parameters,listener, "enviar-encuesta", Request.Method.GET);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }
}
