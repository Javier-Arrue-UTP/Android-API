package com.example.proyectofiscmovil.Models;

public class Asignaturas {

    int idAsignatura;
    String codAsignatura,nombre;

    public Asignaturas(int idAsignatura, String codAsignatura, String nombre) {
        this.idAsignatura = idAsignatura;
        this.codAsignatura = codAsignatura;
        this.nombre = nombre;
    }


    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getCodAsignatura() {
        return codAsignatura;
    }

    public void setCodAsignatura(String codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    public String toString() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
