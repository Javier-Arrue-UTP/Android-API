package com.example.proyectofiscmovil.HttpRequest;
import android.content.Context;
import androidx.annotation.Nullable;
import com.android.volley.Request;
import java.util.Map;

public class QuestionRequest extends BaseRequest{

    public QuestionRequest(Context context)
    {
        super(context);
    }

    public void GetProfessorQuestionList(@Nullable Map<String, Object> parameters, final CustomListener<Object> listener) throws Exception
    {
        try
        {
            this.ExecuteRequest(parameters,listener, "api/preguntasDocentes",Request.Method.GET);
        }
        catch (Exception ex)
        {

            throw ex;
        }
    }

    public void GetProfessorQuestion(@Nullable Map<String, Object> parameters, final CustomListener<Object> listener) throws Exception
    {
        try {
            this.ExecuteRequest(parameters, listener, "api/preguntaDocentes", Request.Method.GET);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

    public void PostProfessorQuestion(@Nullable Map<String, Object> parameters, final CustomListener<Object> listener) throws Exception
    {
        try {
            this.ExecuteRequest(parameters, listener, "api/preguntaDocentes", Request.Method.POST);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

    public void DeleteProfessorQuestion(@Nullable Map<String, Object> parameters, final CustomListener<Object> listener) throws Exception
    {
        try {
            this.ExecuteRequest(parameters, listener, "api/preguntaDocentes", Request.Method.DELETE);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

    public void PutProfessorQuestionDescription(@Nullable Map<String, Object> parameters, final CustomListener<Object> listener) throws Exception
    {
        try {
            this.ExecuteRequest(parameters, listener, "api/preguntaDocentes", Request.Method.PUT);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

    public void OutProfessorQuestionOption(@Nullable Map<String, Object> parameters, final CustomListener<Object> listener) throws Exception
    {
        try {
            this.ExecuteRequest(parameters, listener, "api/actualizarPreguntaDocente", Request.Method.PUT);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

    public void DeleteProfessorQuestionOption(@Nullable Map<String, Object> parameters, final CustomListener<Object> listener) throws Exception
    {
        try {
            this.ExecuteRequest(parameters, listener, "api/actualizarPreguntaDocente", Request.Method.DELETE);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }
}
