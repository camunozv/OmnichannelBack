package com.proyectopd.omnichannel.empresa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proyectopd.omnichannel.queja.Queja;
import com.proyectopd.omnichannel.tipoServicio.TipoServicio;
import com.proyectopd.omnichannel.usuario.Usuario;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpresa;

    private String nombre;
    private String ciudad;
    private String contrasenha;

    @OneToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario idUsuario;

    @OneToMany(mappedBy = "empresa") // Mapped by indicates who is the owner entity in the relationship
    @JsonIgnore
    private List<Queja> quejas;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idTipoServicio", nullable = false)
    private TipoServicio tipoServicio;

    public Empresa() {
    }

    public Empresa(Integer idEmpresa, String nombre, String ciudad, String contrasenha, Usuario idUsuario, List<Queja> quejas, TipoServicio tipoServicio) {
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.contrasenha = contrasenha;
        this.idUsuario = idUsuario;
        this.quejas = quejas;
        this.tipoServicio = tipoServicio;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
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

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }
}

/*
package com.proyectopd.omnichannel.empresa;

import com.proyectopd.omnichannel.queja.Queja;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nit;
    private String nombre;
    private String direccionOficinaPrincipal;
    private String ciudad;
    private String barrio;
    private String departamento;
    private String tipoDeServicio;

    // Pending Json Ignore and mapping
    @OneToMany(mappedBy = "empresa")
    private List<Queja> quejas;

    public Empresa() {
    }

    public Empresa(Long nit, String nombre, String direccionOficinaPrincipal, String ciudad, String barrio, String departamento, String tipoDeServicio, List<Queja> quejas) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccionOficinaPrincipal = direccionOficinaPrincipal;
        this.ciudad = ciudad;
        this.barrio = barrio;
        this.departamento = departamento;
        this.tipoDeServicio = tipoDeServicio;
        this.quejas = quejas;
    }

    public Long getNit() {
        return nit;
    }

    public void setNit(Long nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccionOficinaPrincipal() {
        return direccionOficinaPrincipal;
    }

    public void setDireccionOficinaPrincipal(String direccionOficinaPrincipal) {
        this.direccionOficinaPrincipal = direccionOficinaPrincipal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTipoDeServicio() {
        return tipoDeServicio;
    }

    public void setTipoDeServicio(String tipoDeServicio) {
        this.tipoDeServicio = tipoDeServicio;
    }

    public List<Queja> getQuejas() {
        return quejas;
    }

    public void setQuejas(List<Queja> quejas) {
        this.quejas = quejas;
    }
}
*/
