package com.example.proyectofiscmovil.HttpRequest;

import android.content.Context;

import androidx.annotation.Nullable;

import com.android.volley.Request;

import java.util.Map;

public class BusinessmanRequest extends BaseRequest{
    public BusinessmanRequest(Context context) {
        super(context);
    }

    public void PostBusinessmanRepond(@Nullable Map<String, Object> parameters, final CustomListener<Object> listener) throws Exception {
        try
        {
            this.ExecuteRequest(parameters,listener, "api/enviar", Request.Method.POST);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

    public void GetSurvey(@Nullable Map<String, Object> parameters, final CustomListener<Object> listener) throws Exception {
        try
        {
            this.ExecuteRequest(parameters,listener, "api", Request.Method.GET);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

    public void GetSurveyStatistics(@Nullable Map<String, Object> parameters, final CustomListener<Object> listener) throws Exception {
        try
        {
            this.ExecuteRequest(parameters,listener, "api/menu/emp/estadisticas", Request.Method.GET);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }
}
