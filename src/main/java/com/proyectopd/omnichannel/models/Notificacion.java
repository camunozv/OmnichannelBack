package com.proyectopd.omnichannel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Notificacion {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNotificacion;
    private String textoNotificacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    @JsonIgnore
    private Usuario usuario;

    public Notificacion() {
    }

    public Notificacion(Integer idNotificacion, String textoNotificacion, Usuario usuario) {
        this.idNotificacion = idNotificacion;
        this.textoNotificacion = textoNotificacion;
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(Integer idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getTextoNotificacion() {
        return textoNotificacion;
    }

    public void setTextoNotificacion(String textoNotificacion) {
        this.textoNotificacion = textoNotificacion;
    }
}
