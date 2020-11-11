package com.example.proyectofiscmovil.HttpRequest;

public class Respond {
    private ResponseStatus mResponseStatus;
    private String RespondMessage;
    private String ErrorMessage;

    public Respond(ResponseStatus responseStatus, String respondMessage, String errorMessage) {
        mResponseStatus = responseStatus;
        RespondMessage = respondMessage;
        ErrorMessage = errorMessage;
    }

    public ResponseStatus getResponseStatus() {
        return mResponseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        mResponseStatus = responseStatus;
    }

    public String getRespondMessage() {
        return RespondMessage;
    }

    public void setRespondMessage(String respondMessage) {
        RespondMessage = respondMessage;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }
}
