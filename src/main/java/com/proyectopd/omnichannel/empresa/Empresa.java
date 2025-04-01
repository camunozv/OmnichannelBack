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
    @OneToMany
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
