package com.proyectopd.omnichannel.dtos.createuser.models;

import com.proyectopd.omnichannel.dtos.createuser.UserDTO;

public class AdministradorProfesionalDTO implements UserDTO {

    private Integer id;
    private String nombre;
    private String apellido;
    private String contrasenha;
    private String rol;

    public AdministradorProfesionalDTO() {
    }

    public AdministradorProfesionalDTO(Integer id, String nombre, String apellido, String contrasenha, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasenha = contrasenha;
        this.rol = rol;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer Id) {
        this.id = Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
