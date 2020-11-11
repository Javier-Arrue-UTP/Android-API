package com.example.proyectofiscmovil.HttpRequest;

import android.content.Context;

import androidx.annotation.Nullable;

import com.android.volley.Request;

import java.util.Map;

public class GroupRequest extends BaseRequest {
    public GroupRequest(Context context) {
        super(context);
    }

    public void GetGroupList(@Nullable Map<String, Object> parameters, final CustomListener<Object> listener) throws Exception {
        try
        {
            this.ExecuteRequest(parameters,listener, "api/gruposLista", Request.Method.GET);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }
}
