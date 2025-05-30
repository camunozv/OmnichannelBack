package com.proyectopd.omnichannel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Queja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idQueja;

    private String estado;

    @Column(name = "tiempoMinimoRespuesta")
    private LocalDate tiempoMinimoRespuesta;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(columnDefinition = "TEXT")
    private String archivo;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
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

    public Queja(Integer idQueja, String estado, LocalDate tiempoMinimoRespuesta, String descripcion, String archivo, Respuesta respuesta, TipoQueja tipoQueja, Profesional profesional, Empresa empresa) {
        this.idQueja = idQueja;
        this.estado = estado;
        this.tiempoMinimoRespuesta = tiempoMinimoRespuesta;
        this.descripcion = descripcion;
        this.archivo = archivo;
        this.respuesta = respuesta;
        this.tipoQueja = tipoQueja;
        this.profesional = profesional;
        this.empresa = empresa;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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