package com.proyectopd.omnichannel.dtos.createuser.creators;

import com.proyectopd.omnichannel.dtos.createuser.CreateUserDTO;
import com.proyectopd.omnichannel.dtos.createuser.models.EmpresaDTO;

public class CreateEmpresaDTO extends CreateUserDTO {

    @Override
    public EmpresaDTO createNewUserDTO() {
        return new EmpresaDTO();
    }
}
