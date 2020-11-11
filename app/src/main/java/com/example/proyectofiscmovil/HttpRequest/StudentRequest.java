package com.example.proyectofiscmovil.HttpRequest;

import android.content.Context;

import androidx.annotation.Nullable;

import com.android.volley.Request;

import java.util.Map;

public class StudentRequest extends BaseRequest{

    public StudentRequest(Context context) {
        super(context);
    }

    public void GetSurveyStudents(@Nullable Map<String, Object> parameters, final CustomListener<Object> listener) throws Exception
    {
        try
        {
            this.ExecuteRequest(parameters,listener, "api/encuesta/estudiantes", Request.Method.GET);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

    public void GetSurveyedGroups(@Nullable Map<String, Object> parameters, final CustomListener<Object> listener) throws Exception
    {
        try
        {
            this.ExecuteRequest(parameters,listener, "api/salones_encuestados/estudiantes", Request.Method.GET);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

    public void GetGroupsNotSurveyed(@Nullable Map<String, Object> parameters, final CustomListener<Object> listener) throws Exception
    {
        try
        {
            this.ExecuteRequest(parameters,listener, "api/salones_no_encuestados/estudiantes", Request.Method.GET);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }
}
