package com.proyectopd.omnichannel.models;

import jakarta.persistence.*;

@Entity
public class NotificacionAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNotificacion;
    @Column(columnDefinition = "TEXT")
    private String textoNotificacion;

    public NotificacionAdmin() {
    }

    public NotificacionAdmin(Integer idNotificacion, String textoNotificacion) {
        this.idNotificacion = idNotificacion;
        this.textoNotificacion = textoNotificacion;
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
