package com.proyectopd.omnichannel.rol.implementation;

import com.proyectopd.omnichannel.rol.Rol;
import com.proyectopd.omnichannel.rol.RolRepository;
import com.proyectopd.omnichannel.rol.RolService;
import org.springframework.stereotype.Service;

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
}
