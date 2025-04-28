package com.proyectopd.omnichannel.services.Implementation;

import com.proyectopd.omnichannel.dtos.createuser.creators.CreateAdministradorProfesionalDTO;
import com.proyectopd.omnichannel.dtos.createuser.models.AdministradorProfesionalDTO;
import com.proyectopd.omnichannel.models.Administrador;
import com.proyectopd.omnichannel.repositories.AdministradorRepository;
import com.proyectopd.omnichannel.services.AdministradorService;
import com.proyectopd.omnichannel.services.UsuarioService;
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
            System.out.println("hola");
            administradorRepository.save(newAdministrador);
            return newAdministrador;
        } catch (Exception e) {
            return new Administrador("NOT CREATED");
        }

    }

    @Override
    public AdministradorProfesionalDTO getAdministradorById(Integer administradorId) {

        try {
            Administrador originalAdmin = administradorRepository.getAdministradorByIdAdministrador(administradorId);
            AdministradorProfesionalDTO adminToReturn = new CreateAdministradorProfesionalDTO().createNewUserDTO();

            adminToReturn.setId(originalAdmin.getUsuario().getIdUsuario());
            adminToReturn.setNombre(originalAdmin.getNombre());
            adminToReturn.setApellido(originalAdmin.getApellido());
            adminToReturn.setRol("Administrador");

            return adminToReturn;
        } catch (Exception e) {
            return new AdministradorProfesionalDTO();
        }
    }
}
