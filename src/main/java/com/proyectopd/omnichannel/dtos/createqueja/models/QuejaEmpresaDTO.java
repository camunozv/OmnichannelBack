package com.proyectopd.omnichannel.dtos.createqueja.models;

import com.proyectopd.omnichannel.models.Empresa;

import java.time.LocalDate;


public class QuejaEmpresaDTO {

    // Datos de queja
    private Integer idQueja;
    private String estado;
    private LocalDate tiempoMinimoRespuesta;
    private String descripcion;
    private String archivo;

    // Datos de entidades obligatorias
    private String tipoQueja;
    private String nombreEmpresa;

    public QuejaEmpresaDTO() {
    }

    public QuejaEmpresaDTO(Integer idQueja, String estado, LocalDate tiempoMinimoRespuesta, String descripcion, String archivo, String tipoQueja, String nombreEmpresa) {
        this.idQueja = idQueja;
        this.estado = estado;
        this.tiempoMinimoRespuesta = tiempoMinimoRespuesta;
        this.descripcion = descripcion;
        this.archivo = archivo;
        this.tipoQueja = tipoQueja;
        this.nombreEmpresa = nombreEmpresa;
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

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getTipoQueja() {
        return tipoQueja;
    }

    public void setTipoQueja(String tipoQueja) {
        this.tipoQueja = tipoQueja;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
}
