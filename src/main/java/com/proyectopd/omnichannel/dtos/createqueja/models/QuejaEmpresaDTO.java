package com.proyectopd.omnichannel.dtos.createqueja.models;

import com.proyectopd.omnichannel.models.Empresa;


public class QuejaEmpresaDTO {

    // Datos de queja
    private String prioridad;
    private String tiempoMinimoRespuesta;
    private String descripcion;
    private String archivo;

    // Datos de entidades obligatorias
    private String tipoQueja;
    private String nombreEmpresa;

    public QuejaEmpresaDTO(String prioridad, String tiempoMinimoRespuesta, String descripcion, String archivo, String tipoQueja, String nombreEmpresa) {
        this.prioridad = prioridad;
        this.tiempoMinimoRespuesta = tiempoMinimoRespuesta;
        this.descripcion = descripcion;
        this.archivo = archivo;
        this.tipoQueja = tipoQueja;
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
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
