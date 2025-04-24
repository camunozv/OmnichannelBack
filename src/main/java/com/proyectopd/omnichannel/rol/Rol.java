package com.proyectopd.omnichannel.rol;

import com.proyectopd.omnichannel.usuario.Usuario;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;
    private String nombreRol;

    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuario;

    public Rol() {
    }

    public Rol(Integer idRol, String nombreRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}
