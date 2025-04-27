package com.proyectopd.omnichannel.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Rol {

    @Id
    private String nombreRol;

    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuario; // This kind of memebers don't need to be specified
    // when posting a new user.

    public Rol() {
    }

    public Rol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}
