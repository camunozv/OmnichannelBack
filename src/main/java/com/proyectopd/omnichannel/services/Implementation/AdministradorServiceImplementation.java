package com.proyectopd.omnichannel.services.Implementation;

import com.proyectopd.omnichannel.models.Administrador;
import com.proyectopd.omnichannel.repositories.AdministradorRepository;
import com.proyectopd.omnichannel.services.AdministradorService;
import org.springframework.stereotype.Service;

@Service
public class AdministradorServiceImplementation implements AdministradorService {

    AdministradorRepository administradorRepository;

    public AdministradorServiceImplementation(AdministradorRepository administradorRepository) {
        this.administradorRepository = administradorRepository;
    }

    @Override
    public Administrador crearAdministrador(Administrador newAdministrador) {

        try {
            administradorRepository.save(newAdministrador);
            return newAdministrador;
        } catch (Exception e) {
            return new Administrador("NOT CREATED");
        }

    }

    @Override
    public Administrador getAdministradorById(Integer administradorId) {

        try {
            Administrador adminToReturn = administradorRepository.getAdministradorByIdAdministrador(administradorId);
            return adminToReturn;
        } catch (Exception e) {
            return new Administrador("NOT FOUND");
        }
    }
}
