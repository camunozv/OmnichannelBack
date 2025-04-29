package com.proyectopd.omnichannel.dtos.createuser.models;

public class UsuarioEmpresaDTO {

    private Integer id;
    private String contrasenha;
    private String nombre;
    private String ciudad;
    private String tipoServicio;
    private String rol;

    public UsuarioEmpresaDTO(Integer id, String contrasenha, String nombre, String ciudad, String tipoServicio, String rol) {
        this.id = id;
        this.contrasenha = contrasenha;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.tipoServicio = tipoServicio;
        this.rol = rol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
