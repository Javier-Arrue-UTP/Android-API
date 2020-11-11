package com.example.proyectofiscmovil.HttpRequest;
import android.content.Context;
import android.net.wifi.WifiManager;
import androidx.annotation.Nullable;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONObject;
import java.util.Map;

public class BaseRequest {
    private static BaseRequest instance = null;
    private static final String prefixURL = "http://127.0.0.1:8000/";
    public RequestQueue requestQueue;
    WifiManager wifi;

    public BaseRequest(Context context)
    {
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        wifi.setWifiEnabled(true);
    }

    public void ExecuteRequest(@Nullable Map<String, Object> parameters, final CustomListener<Object> listener, String sufixURL, int httpMethod) throws Exception {
        if(!wifi.isWifiEnabled())
        {
            throw new Exception("WIFI is not enable.");
        }

        String url = prefixURL + sufixURL;
        JSONObject jsonObject = getJSONObject(parameters);
        JsonObjectRequest request = new JsonObjectRequest(
                httpMethod,
                url,
                jsonObject,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response)
                    {
                    Respond res = new Respond(ResponseStatus.OK, response.toString(), "");
                    listener.getResult(res);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                    Respond res = new Respond(ResponseStatus.ERROR, "", error.getMessage());
                    listener.getResult(res);
                    }
                });

        requestQueue.add(request);
    }

    private JSONObject getJSONObject(@Nullable Map<String, Object> parameters) {
        JSONObject jsonObject = null;
        if(parameters != null)
        {
            jsonObject = new JSONObject(parameters);
        }
        return jsonObject;
    }
}
