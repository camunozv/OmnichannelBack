package com.proyectopd.omnichannel.dtos.createuser.models;

import com.proyectopd.omnichannel.dtos.createuser.UserDTO;

public class EmpresaDTO implements UserDTO {

    private Integer id;
    private String nombre;
    private String ciudad;
    private String tipoServicio;

    public EmpresaDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
}
