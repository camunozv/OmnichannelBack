package com.proyectopd.omnichannel.dtos.createuser.creators;

import com.proyectopd.omnichannel.dtos.createuser.CreateUserDTO;
import com.proyectopd.omnichannel.dtos.createuser.models.AdministradorProfesionalDTO;

public class CreateAdministradorProfesionalDTO extends CreateUserDTO {

    @Override
    public AdministradorProfesionalDTO createNewUserDTO() {
        return new AdministradorProfesionalDTO();
    }
}
