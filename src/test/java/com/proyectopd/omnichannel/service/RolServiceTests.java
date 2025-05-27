package com.proyectopd.omnichannel.service;

import com.proyectopd.omnichannel.models.Rol;
import com.proyectopd.omnichannel.repositories.RolRepository;
import com.proyectopd.omnichannel.services.Implementation.RolServiceImplementation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RolServiceTests {

    @Mock
    private RolRepository rolRepository;

    @InjectMocks
    private RolServiceImplementation rolServiceImplementation;

    @Test
    public void testCreateNewRol() {
        Rol rol = new Rol();
        rol.setNombreRol("Administrador");

        boolean created = rolServiceImplementation.createNewRol(rol);

        assert (created);
    }

    @Test
    public void testGetRolById() {
        ArrayList<Rol> listOfRol = new ArrayList<>();
        Rol rol = new Rol();
        rol.setNombreRol("Administrador");
        listOfRol.add(rol);

        when(rolRepository.getRolByNombreRol("Administrador")).thenReturn(listOfRol);

        Rol rolToReturn = rolServiceImplementation.getRolById("Administrador");

        assertEquals(rol.getNombreRol(), rolToReturn.getNombreRol());
        verify(rolRepository, times(1)).getRolByNombreRol("Administrador");
    }

    @Test
    public void testDeleteRol() {
        Rol rol = new Rol();
        rol.setNombreRol("Administrador");

        doNothing().when(rolRepository).deleteRolByNombreRol("Administrador");

        boolean deleted = rolServiceImplementation.deleteRol("Administrador");

        assertEquals(true, deleted);
        verify(rolRepository, times(1)).deleteRolByNombreRol("Administrador");
    }

}
