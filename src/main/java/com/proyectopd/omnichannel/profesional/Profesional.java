package com.proyectopd.omnichannel.profesional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proyectopd.omnichannel.queja.Queja;
import com.proyectopd.omnichannel.usuario.Usuario;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Profesional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProfesional;

    private String nombre;
    private String apellido;
    private String correoElectronico;
    private Integer telefonoMovil;
    private Integer cantidadQuejasEncargadas;

    // Since we specified join column and not mapped by
    // means this entity contains within its data a foreign key, that
    // cannot be null
    @OneToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    // nullable = false -> doesnt allow null values in foreignkey values.
    private Usuario usuario; // This object i think it's just fot the query that involves geting the user

    @OneToMany(mappedBy = "profesional")
    @JsonIgnore
    private List<Queja> quejas;

    public Profesional() {
    }

    public Profesional(Integer idProfesional, String nombre, String apellido, String correoElectronico, Integer telefonoMovil, Integer cantidadQuejasEncargadas, Usuario usuario, List<Queja> quejas) {
        this.idProfesional = idProfesional;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.telefonoMovil = telefonoMovil;
        this.cantidadQuejasEncargadas = cantidadQuejasEncargadas;
        this.usuario = usuario;
        this.quejas = quejas;
    }

    public Integer getCantidadQuejasEncargadas() {
        return cantidadQuejasEncargadas;
    }

    public void setCantidadQuejasEncargadas(Integer cantidadQuejasEncargadas) {
        this.cantidadQuejasEncargadas = cantidadQuejasEncargadas;
    }

    public List<Queja> getQuejas() {
        return quejas;
    }

    public void setQuejas(List<Queja> quejas) {
        this.quejas = quejas;
    }

    public Integer getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(Integer idProfesional) {
        this.idProfesional = idProfesional;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
