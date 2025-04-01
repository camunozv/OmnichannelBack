package com.proyectopd.omnichannel.queja;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proyectopd.omnichannel.empresa.Empresa;
import com.proyectopd.omnichannel.usuario.Usuario;
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

    // Uncomment when the other entities are ready
    @JsonIgnore
    @ManyToOne
    private Usuario usuario;

    @JsonIgnore
    @ManyToOne
    private Empresa empresa;

    public Queja() {
    }

    public Queja(Long idQueja, String tipoServicio, int prioridad, String tiempoMinimoRespuesta, String descripcion, Usuario usuario, Empresa empresa) {
        this.idQueja = idQueja;
        this.tipoServicio = tipoServicio;
        this.prioridad = prioridad;
        this.tiempoMinimoRespuesta = tiempoMinimoRespuesta;
        this.descripcion = descripcion;
        this.usuario = usuario;
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
}
