package com.proyectopd.omnichannel.usuario;
import com.proyectopd.omnichannel.queja.Queja;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cedula;
    private String nombres;
    private String apellidos;
    private String direccion;
    private int estrato;
    private String barrio;
    private String ciudad;
    private String departamento;

    // Pending to add mapping and json ignore
    @OneToMany
    private List<Queja> misQuejas;

    public Usuario() {
    }

    public Usuario(Long cedula, String nombres, String apellidos, String direccion, int estrato, String barrio, String ciudad, String departamento, List<Queja> misQuejas) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.estrato = estrato;
        this.barrio = barrio;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.misQuejas = misQuejas;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEstrato() {
        return estrato;
    }

    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public List<Queja> getMisQuejas() {
        return misQuejas;
    }

    public void setMisQuejas(List<Queja> misQuejas) {
        this.misQuejas = misQuejas;
    }
}
