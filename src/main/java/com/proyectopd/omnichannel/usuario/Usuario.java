package com.proyectopd.omnichannel.usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proyectopd.omnichannel.administrador.Administrador;
import com.proyectopd.omnichannel.profesional.Profesional;
import com.proyectopd.omnichannel.queja.Queja;
import com.proyectopd.omnichannel.rol.Rol;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Usuario {

    @Id
    private Integer idUsuario;

    @OneToOne(mappedBy = "usuario")
    private Administrador administrador;

    @OneToOne(mappedBy = "usuario")
    private Profesional profesional;

    @ManyToOne
    @JoinColumn(name = "idRol", nullable = false)
    private Rol rol;

    public Usuario() {
    }

    public Usuario(Integer idUsuario, Administrador administrador, Profesional profesional, Rol rol) {
        this.idUsuario = idUsuario;
        this.administrador = administrador;
        this.profesional = profesional;
        this.rol = rol;
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
