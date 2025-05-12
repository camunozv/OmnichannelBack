package com.proyectopd.omnichannel.dtos.createuser.models;

public class UsuarioProfesionalDTO {

    private Integer id;
    private String contrasenha;
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private Integer telefonoMovil;
    private Integer cantidadQuejasEncargadas;
    private String rol;

    public UsuarioProfesionalDTO() {
    }

    public UsuarioProfesionalDTO(Integer id, String contrasenha, String nombre, String apellido, String correoElectronico, Integer telefonoMovil, Integer cantidadQuejasEncargadas, String rol) {
        this.id = id;
        this.contrasenha = contrasenha;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.telefonoMovil = telefonoMovil;
        this.cantidadQuejasEncargadas = cantidadQuejasEncargadas;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Integer getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(Integer telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public Integer getCantidadQuejasEncargadas() {
        return cantidadQuejasEncargadas;
    }

    public void setCantidadQuejasEncargadas(Integer cantidadQuejasEncargadas) {
        this.cantidadQuejasEncargadas = cantidadQuejasEncargadas;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
