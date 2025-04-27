package com.proyectopd.omnichannel.services.Implementation;

import com.proyectopd.omnichannel.models.Rol;
import com.proyectopd.omnichannel.repositories.RolRepository;
import com.proyectopd.omnichannel.services.RolService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImplementation implements RolService {

    RolRepository rolRepository;

    // Always write the constructor, bce the initialization of the rol service object
    // is handled during runtime.
    public RolServiceImplementation(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public boolean createNewRol(Rol newRol) {

        boolean created;

        try {
            rolRepository.save(newRol);
            created = true;
        } catch (Exception e) {
            created = false;
        }

        return created;
    }

    @Override
    public Rol getRolById(String rolName) {

        try {
            List<Rol> rolToReturn = rolRepository.getRolByNombreRol(rolName);
            return rolToReturn.get(0);
        } catch (Exception e) {
            return new Rol("NOT FOUND");
        }

    }
}
