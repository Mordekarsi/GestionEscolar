package uv.fei.sistemadetutorias.domain;

import java.util.Objects;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cashd
 */
public class Academico {
    private int numeroDePersonal = -1;
    private String nombre = "";
    private String apellidoPaterno = "";
    private String apellidoMaterno = "";
    private String correoPersonal = "";
    private String correoInstitucional = "";

    public Academico() {
    }

    public int getNumeroDePersonal() {
        return numeroDePersonal;
    }

    public void setNumeroDePersonal(int numeroDePersonal) {
        this.numeroDePersonal = numeroDePersonal;
    }

    public String getNombre() {
        return nombre;
    }

    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreoPersonal() {
        return correoPersonal;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    @Override
    public boolean equals(Object object) {
        boolean isEquals = false;
        if (object == this){
            isEquals = true;
        }
        if (object != null && object instanceof Academico){
            Academico other = (Academico) object;
            isEquals = (this.getNumeroDePersonal() == (other.getNumeroDePersonal()) && this.getNombre().equals(other.getNombre()));
        }
        return isEquals;
    }

    @Override
    public String toString() {
        return nombre + " " + apellidoPaterno + " " + apellidoMaterno;
    }
    
    public String getNombreCompleto(){
        return nombre + " " + apellidoPaterno + " " + apellidoMaterno;
    }
    
    
}
