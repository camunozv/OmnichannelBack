package com.proyectopd.omnichannel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Must create the database again to make this work.
    private Integer idRespuesta;
    // textoRespuesta needs to be refactored to long text instead of varchar(255)
    @Column(columnDefinition = "TEXT")
    private String textoRespuesta;

    @OneToOne
    @JoinColumn(name = "idQueja", nullable = false)
    @JsonIgnore
    private Queja queja;

    public Respuesta() {
    }

    public Respuesta(Integer idRespuesta, String textoRespuesta, Queja queja) {
        this.idRespuesta = idRespuesta;
        this.textoRespuesta = textoRespuesta;
        this.queja = queja;
    }

    public Integer getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getTextoRespuesta() {
        return textoRespuesta;
    }

    public void setTextoRespuesta(String textoRespuesta) {
        this.textoRespuesta = textoRespuesta;
    }

    public Queja getQueja() {
        return queja;
    }

    public void setQueja(Queja queja) {
        this.queja = queja;
    }
}
