package com.proyectopd.omnichannel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class TipoQueja {

    @Id
    private String tipoQueja;
    private Integer dias;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoQueja")
    private List<Queja> queja;

    public TipoQueja() {
    }

    public TipoQueja(String tipoQueja, Integer dias, List<Queja> queja) {
        this.tipoQueja = tipoQueja;
        this.dias = dias;
        this.queja = queja;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
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
