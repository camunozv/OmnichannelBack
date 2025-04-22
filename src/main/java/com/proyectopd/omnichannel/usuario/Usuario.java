package com.proyectopd.omnichannel.usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proyectopd.omnichannel.queja.Queja;
import com.proyectopd.omnichannel.rol.Rol;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Usuario {

    @Id
    private Integer idUsuario;
    private Integer idRol;

    @ManyToOne
    @JoinColumn(name = "idRol", nullable = false)
    private Rol rolUsuario;

    public Usuario() {
    }

    public Usuario(Integer idUsuario, Integer idRol, Rol rolUsuario) {
        this.idUsuario = idUsuario;
        this.idRol = idRol;
        this.rolUsuario = rolUsuario;
    }

    public Rol getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(Rol rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }
}
