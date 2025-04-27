package com.proyectopd.omnichannel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    private Integer idUsuario;
    private String contrasenha;

    @OneToOne(mappedBy = "usuario")
    @JsonIgnore
    private Administrador administrador;

    @OneToOne(mappedBy = "usuario")
    @JsonIgnore
    private Profesional profesional;

    @ManyToOne
    @JoinColumn(name = "idRol", nullable = false)
    private Rol rol;

    public Usuario() {
    }

    public Usuario(Integer idUsuario, String contrasenha, Administrador administrador, Profesional profesional, Rol rol) {
        this.idUsuario = idUsuario;
        this.contrasenha = contrasenha;
        this.administrador = administrador;
        this.profesional = profesional;
        this.rol = rol;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

}
