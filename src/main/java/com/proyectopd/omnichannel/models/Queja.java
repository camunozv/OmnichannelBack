package com.proyectopd.omnichannel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Queja {

    // Base fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQueja;
    private String tipoServicio;
    private int prioridad;
    private String tiempoMinimoRespuesta;
    private String descripcion;
    private String respuesta;
    private String documento;

    // Uncomment when the other entities are ready
    @JsonIgnore
    @JoinColumn(name = "idProfesional", nullable = true)
    @ManyToOne
    private Profesional profesional;

    @JsonIgnore
    @JoinColumn(name = "idEmpresa", nullable = true)
    @ManyToOne
    private Empresa empresa;

    public Queja() {
    }

    public Queja(Long idQueja, String tipoServicio, int prioridad, String tiempoMinimoRespuesta, String descripcion, String respuesta, String documento, Profesional profesional, Empresa empresa) {
        this.idQueja = idQueja;
        this.tipoServicio = tipoServicio;
        this.prioridad = prioridad;
        this.tiempoMinimoRespuesta = tiempoMinimoRespuesta;
        this.descripcion = descripcion;
        this.respuesta = respuesta;
        this.documento = documento;
        this.profesional = profesional;
        this.empresa = empresa;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Long getIdQueja() {
        return idQueja;
    }

    public void setIdQueja(Long idQueja) {
        this.idQueja = idQueja;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getTiempoMinimoRespuesta() {
        return tiempoMinimoRespuesta;
    }

    public void setTiempoMinimoRespuesta(String tiempoMinimoRespuesta) {
        this.tiempoMinimoRespuesta = tiempoMinimoRespuesta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
