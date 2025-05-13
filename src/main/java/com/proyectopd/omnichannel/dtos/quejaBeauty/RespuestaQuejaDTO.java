package com.proyectopd.omnichannel.dtos.quejaBeauty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proyectopd.omnichannel.models.Empresa;
import com.proyectopd.omnichannel.models.Profesional;
import com.proyectopd.omnichannel.models.Respuesta;
import com.proyectopd.omnichannel.models.TipoQueja;
import jakarta.persistence.*;

import java.time.LocalDate;

public class RespuestaQuejaDTO {

    private Integer idQueja;
    private String estado;
    private LocalDate tiempoMinimoRespuesta;
    private String descripcion;
    private String archivo;
    private String textoRespuesta;

    public RespuestaQuejaDTO() {
    }

    public RespuestaQuejaDTO(Integer idQueja, String estado, LocalDate tiempoMinimoRespuesta, String descripcion, String archivo, String textoRespuesta) {
        this.idQueja = idQueja;
        this.estado = estado;
        this.tiempoMinimoRespuesta = tiempoMinimoRespuesta;
        this.descripcion = descripcion;
        this.archivo = archivo;
        this.textoRespuesta = textoRespuesta;
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

    public String getTextoRespuesta() {
        return textoRespuesta;
    }

    public void setTextoRespuesta(String textoRespuesta) {
        this.textoRespuesta = textoRespuesta;
    }
}
