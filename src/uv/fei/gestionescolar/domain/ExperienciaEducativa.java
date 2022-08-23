/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uv.fei.gestionescolar.domain;

import java.util.Objects;

/**
 *
 * @author cashd
 */
public class ExperienciaEducativa {
    private int nrc = 0;
    private String nombre = "";
    private String dias = "";
    private String horarioInicio = "";
    private String horarioFin = "";
    private String ubicacion = "";

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getHorarioFin() {
        return horarioFin;
    }

    public void setHorarioFin(String horarioFin) {
        this.horarioFin = horarioFin;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    public ExperienciaEducativa() {
    }

    public ExperienciaEducativa(int nrc, String nombre) {
        this.nrc = nrc;
        this.nombre = nombre;
    }


    public int getNrc() {
        return nrc;
    }

    public void setNrc(int nrc) {
        this.nrc = nrc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return  nombre;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ExperienciaEducativa other = (ExperienciaEducativa) obj;
        if (this.nrc != other.nrc) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }
    
    
}
