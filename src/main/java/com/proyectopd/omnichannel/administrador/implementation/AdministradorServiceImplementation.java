package com.proyectopd.omnichannel.administrador.implementation;

import com.proyectopd.omnichannel.administrador.Administrador;
import com.proyectopd.omnichannel.administrador.AdministradorRepository;
import com.proyectopd.omnichannel.administrador.AdministradorService;

public class AdministradorServiceImplementation implements AdministradorService {

    AdministradorRepository administradorRepository;

    public AdministradorServiceImplementation(AdministradorRepository administradorRepository) {
        this.administradorRepository = administradorRepository;
    }

    @Override
    public boolean crearAdministrador(Administrador newAdministrador) {

        boolean created;

        try {
            administradorRepository.save(newAdministrador);
            created = true;
        } catch (Exception e) {
            created = false;
        }

        return created;
    }
}
