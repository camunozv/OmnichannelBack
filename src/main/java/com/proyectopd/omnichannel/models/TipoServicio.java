package com.proyectopd.omnichannel.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class TipoServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoServicio;
    private String nombreServicio;

    @OneToMany(mappedBy = "tipoServicio")
    private List<Empresa> empresa;

    public TipoServicio() {
    }

    public TipoServicio(Integer idTipoServicio, String nombreServicio, List<Empresa> empresa) {
        this.idTipoServicio = idTipoServicio;
        this.nombreServicio = nombreServicio;
        this.empresa = empresa;
    }

    public Integer getIdTipoServicio() {
        return idTipoServicio;
    }

    public void setIdTipoServicio(Integer idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
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
