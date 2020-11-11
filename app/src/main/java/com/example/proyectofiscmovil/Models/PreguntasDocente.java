package com.example.proyectofiscmovil.Models;

public class PreguntasDocente {

    private int idPregunta;
    private String descripPreg, tipoPreg, descripOpcion;

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getDescripPreg() {
        return descripPreg;
    }

    public void setDescripPreg(String descripPreg) {
        this.descripPreg = descripPreg;
    }

    public String getTipoPreg() {
        return tipoPreg;
    }

    public void setTipoPreg(String tipoPreg) {
        this.tipoPreg = tipoPreg;
    }

    public String getDescripOpcion() {
        return descripOpcion;
    }

    public void setDescripOpcion(String descripOpcion) {
        this.descripOpcion = descripOpcion;
    }
}
