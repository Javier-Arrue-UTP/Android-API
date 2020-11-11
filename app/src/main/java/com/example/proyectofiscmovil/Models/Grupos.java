package com.example.proyectofiscmovil.Models;

public class Grupos {
    int id_grupo;
    String cod_grupo;
    String turno;
    String semestre;
    String año;
    String id_carrera;
    String id_sede;

    public Grupos(int id_grupo, String cod_grupo, String turno, String semestre, String año, String id_carrera, String id_sede) {
        this.id_grupo = id_grupo;
       this.cod_grupo = cod_grupo;
        this.turno = turno;
        this.semestre = semestre;
        this.año = año;
        this.id_carrera = id_carrera;
        this.id_sede = id_sede;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String toString() {
        return cod_grupo;
    }

    public void setCod_grupo(String cod_grupo) {
        this.cod_grupo = cod_grupo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(String id_carrera) {
        this.id_carrera = id_carrera;
    }

    public String getId_sede() {
        return id_sede;
    }

    public void setId_sede(String id_sede) {
        this.id_sede = id_sede;
    }
}
