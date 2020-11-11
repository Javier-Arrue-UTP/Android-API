package com.example.proyectofiscmovil.Models;

public class Docentes {

    String cedula,nombreAsignatura,semestre,codGrupo;

    public Docentes(String cedula, String nombreAsignatura, String semestre, String codGrupo) {
        this.cedula = cedula;
        this.nombreAsignatura = nombreAsignatura;
        this.semestre = semestre;
        this.codGrupo = codGrupo;
    }

    public String getCodGrupo() {
        return codGrupo;
    }

    public void setCodGrupo(String codGrupo) {
        this.codGrupo = codGrupo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
}
