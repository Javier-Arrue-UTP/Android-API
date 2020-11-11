package com.example.proyectofiscmovil.HttpRequest;

import android.content.Context;

import androidx.annotation.Nullable;

import com.android.volley.Request;

import java.util.Map;

public class ProfessorRequest extends BaseRequest {
    public ProfessorRequest(Context context)
    {
        super(context);
    }

    public void GetProfessorList(@Nullable Map<String, Object> parameters, final CustomListener<Object> listener) throws Exception
    {
        try
        {
            this.ExecuteRequest(parameters,listener, "api/listaDocentes", Request.Method.GET);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

    public void PostProfessor(@Nullable Map<String, Object> parameters, final CustomListener<Object> listener) throws Exception
    {
        try
        {
            this.ExecuteRequest(parameters,listener, "api/listaDocentes", Request.Method.POST);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

    public void GetProfessorThatRespondToASurvey(@Nullable Map<String, Object> parameters, final CustomListener<Object> listener) throws Exception
    {
        try
        {
            this.ExecuteRequest(parameters,listener, "api/docentesRespondido", Request.Method.GET);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

    public void GetProfessorThatNotRespondAnySurvey(@Nullable Map<String, Object> parameters, final CustomListener<Object> listener) throws Exception {
        try
        {
            this.ExecuteRequest(parameters,listener, "api/docentesSinResponder", Request.Method.GET);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

    public void GetValidateProfessor(@Nullable Map<String, Object> parameters, final CustomListener<Object> listener) throws Exception {
        try
        {
            this.ExecuteRequest(parameters,listener, "api/validarDocente", Request.Method.POST);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }
}
