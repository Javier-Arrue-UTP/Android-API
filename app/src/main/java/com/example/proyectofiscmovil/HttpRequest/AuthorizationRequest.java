package com.example.proyectofiscmovil.HttpRequest;

import android.content.Context;

import androidx.annotation.Nullable;

import com.android.volley.Request;

import java.util.Map;

public class AuthorizationRequest extends BaseRequest {
    public AuthorizationRequest(Context context) {
        super(context);
    }

    public void Login(@Nullable Map<String, Object> parameters, final CustomListener<Object> listener) throws Exception {
        try
        {
            this.ExecuteRequest(parameters,listener, "api", Request.Method.POST);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }
}
