package com.proyectopd.omnichannel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Queja {

    @Id
    private Integer idQueja;
    private String prioridad;
    // tiempoMinimoRespuesta should be refactored to Date datatype
    @Column(name = "tiempoMinimoRespuesta")
    private LocalDate tiempoMinimoRespuesta;
    // descripcion should be refactored to Long text instead of varchar(255)
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    // archivo should be refactored to Long text instead of varchar(255) since
    // we want to store a base64 string within the data base.
    @Column(columnDefinition = "TEXT")
    private String archivo;

    @OneToOne
    @JoinColumn(name = "idRespuesta", nullable = true)
    @JsonIgnore
    private Respuesta respuesta;

    @ManyToOne
    @JoinColumn(name = "tipoQueja", nullable = false)
    private TipoQueja tipoQueja;

    @JsonIgnore
    @JoinColumn(name = "idProfesional")
    @ManyToOne
    private Profesional profesional;

    @JsonIgnore
    @JoinColumn(name = "nombreEmpresa", nullable = false)
    @ManyToOne
    private Empresa empresa;

    public Queja() {
    }

    public Queja(Integer idQueja, String prioridad, LocalDate tiempoMinimoRespuesta, String descripcion, String archivo, TipoQueja tipoQueja, Profesional profesional, Empresa empresa, Respuesta respuesta) {
        this.idQueja = idQueja;
        this.prioridad = prioridad;
        this.tiempoMinimoRespuesta = tiempoMinimoRespuesta;
        this.descripcion = descripcion;
        this.archivo = archivo;
        this.tipoQueja = tipoQueja;
        this.profesional = profesional;
        this.empresa = empresa;
        this.respuesta = respuesta;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public TipoQueja getTipoQueja() {
        return tipoQueja;
    }

    public void setTipoQueja(TipoQueja tipoQueja) {
        this.tipoQueja = tipoQueja;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
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

    public Integer getIdQueja() {
        return idQueja;
    }

    public void setIdQueja(Integer idQueja) {
        this.idQueja = idQueja;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public LocalDate getTiempoMinimoRespuesta() {
        return tiempoMinimoRespuesta;
    }

    public void setTiempoMinimoRespuesta(LocalDate tiempoMinimoRespuesta) {
        this.tiempoMinimoRespuesta = tiempoMinimoRespuesta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}