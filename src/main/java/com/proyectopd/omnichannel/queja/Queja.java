package com.proyectopd.omnichannel.queja;

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
    /*@ManyToOne
    private Usuario usuario;*/

    /*@ManyToOne
    private Empresa empresa;*/

    public Queja() {
    }

    // Create constructor when the other entities are ready.

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
