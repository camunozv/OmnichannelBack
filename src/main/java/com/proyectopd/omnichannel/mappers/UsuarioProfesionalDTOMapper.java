package com.proyectopd.omnichannel.mappers;

import com.proyectopd.omnichannel.dtos.createuser.models.UsuarioProfesionalDTO;
import com.proyectopd.omnichannel.models.Profesional;
import com.proyectopd.omnichannel.models.Usuario;

public class UsuarioProfesionalDTOMapper {

    public UsuarioProfesionalDTOMapper() {
    }

    public static UsuarioProfesionalDTO mapProfesionalToUsuarioProfesionalDTO(Usuario usuario, Profesional profesional) {

        UsuarioProfesionalDTO usuarioProfesionalDTO = new UsuarioProfesionalDTO();

        usuarioProfesionalDTO.setApellido(profesional.getApellido());
        usuarioProfesionalDTO.setNombre(profesional.getNombre());
        usuarioProfesionalDTO.setId(usuario.getIdUsuario());
        usuarioProfesionalDTO.setRol(usuario.getRol().getNombreRol());
        usuarioProfesionalDTO.setCorreoElectronico(profesional.getCorreoElectronico());
        usuarioProfesionalDTO.setCantidadQuejasEncargadas(profesional.getCantidadQuejasEncargadas());

        return usuarioProfesionalDTO;
    }

    public static Profesional mapUsuarioProfesionalDTOToProfesional(UsuarioProfesionalDTO usuarioProfesionalDTO) {
        // Just in case it's required to be implemented.
        return null;
    }
}
