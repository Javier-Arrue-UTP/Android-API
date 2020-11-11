package com.example.proyectofiscmovil.HttpRequest;
import android.content.Context;
import androidx.annotation.Nullable;
import com.android.volley.Request;
import java.util.Map;

public class TestRequest extends BaseRequest {
    public TestRequest(Context context) {
        super(context);
    }

    public void GetUser(@Nullable Map<String, Object> parameters, final CustomListener<Object> listener) throws Exception {
        try
        {
            this.ExecuteRequest(parameters,listener, "users", Request.Method.GET);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }
}
