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
    private String contrasenha;
    private Integer quejasEncargadas;

    @OneToOne
    @JoinColumn(name = "idUsuario", nullable = false) // nullable = false -> doesnt allow null values in foreignkey values.
    private Usuario usuario;

    @OneToMany(mappedBy = "profesional")
    @JsonIgnore
    private List<Queja> quejas;

    public Profesional() {
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

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
