package com.proyectopd.omnichannel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class TipoQueja {

    @Id
    private String tipoQueja;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "idQueja", nullable = true)
    private List<Queja> queja;

    public TipoQueja() {
    }

    public TipoQueja(String tipoQueja, List<Queja> queja) {
        this.tipoQueja = tipoQueja;
        this.queja = queja;
    }

    public String getTipoQueja() {
        return tipoQueja;
    }

    public void setTipoQueja(String tipoQueja) {
        this.tipoQueja = tipoQueja;
    }

    public List<Queja> getQueja() {
        return queja;
    }

    public void setQueja(List<Queja> queja) {
        this.queja = queja;
    }
}
