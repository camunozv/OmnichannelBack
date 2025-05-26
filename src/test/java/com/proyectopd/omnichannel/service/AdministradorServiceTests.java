package com.proyectopd.omnichannel.service;

import com.proyectopd.omnichannel.dtos.createuser.models.UsuarioAdministradorDTO;
import com.proyectopd.omnichannel.models.Administrador;
import com.proyectopd.omnichannel.models.Usuario;
import com.proyectopd.omnichannel.repositories.AdministradorRepository;
import com.proyectopd.omnichannel.services.Implementation.AdministradorServiceImplementation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AdministradorServiceTests {

    @Mock
    private AdministradorRepository administradorRepository;

    @InjectMocks
    private AdministradorServiceImplementation administradorServiceImplementation;

    @Test
    public void testSaveAdministrador() {
        Administrador adminNuevo = new Administrador();
        adminNuevo.setNombre("Nuevo Administrador");
        adminNuevo.setIdAdministrador(1);

        when(administradorRepository.save(adminNuevo)).thenReturn(adminNuevo);

        Administrador adminTest = administradorServiceImplementation.crearAdministrador(adminNuevo);

        assertEquals(adminNuevo, adminTest);

        verify(administradorRepository, times(1)).save(adminNuevo);
    }

    @Test
    public void testGetAdminById() {

        Administrador adminNuevo = new Administrador();
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        adminNuevo.setNombre("Nuevo Administrador");
        adminNuevo.setUsuario(usuario);
        adminNuevo.setIdAdministrador(1);

        when(administradorRepository.getAdministradorByIdAdministrador(1)).thenReturn(adminNuevo);

        UsuarioAdministradorDTO adminTest = administradorServiceImplementation.getAdministradorById(1);

        assertEquals(adminNuevo.getUsuario().getIdUsuario(), adminTest.getId());
        assertEquals(adminNuevo.getNombre(), adminTest.getNombre());

        verify(administradorRepository, times(1)).getAdministradorByIdAdministrador(1);

    }
}
