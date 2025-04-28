package com.proyectopd.omnichannel.dtos.createuser.creators;

import com.proyectopd.omnichannel.dtos.createuser.CreateUserDTO;
import com.proyectopd.omnichannel.dtos.createuser.models.UsuarioAdministradorDTO;

public class CreateAdministradorProfesionalDTO extends CreateUserDTO {

    @Override
    public UsuarioAdministradorDTO createNewUserDTO() {
        return new UsuarioAdministradorDTO();
    }
}
