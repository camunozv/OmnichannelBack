package com.proyectopd.omnichannel.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class TipoServicio {

    @Id
    private String nombreServicio;

    @OneToMany(mappedBy = "tipoServicio")
    private List<Empresa> empresa;

    public TipoServicio() {
    }

    public TipoServicio(String nombreServicio, List<Empresa> empresa) {
        this.nombreServicio = nombreServicio;
        this.empresa = empresa;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public List<Empresa> getEmpresa() {
        return empresa;
    }

    public void setEmpresa(List<Empresa> empresa) {
        this.empresa = empresa;
    }
}
