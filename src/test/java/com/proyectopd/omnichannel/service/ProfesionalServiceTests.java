package com.proyectopd.omnichannel.service;

import com.proyectopd.omnichannel.models.Profesional;
import com.proyectopd.omnichannel.models.Usuario;
import com.proyectopd.omnichannel.repositories.ProfesionalRepository;
import com.proyectopd.omnichannel.repositories.UsuarioRepository;
import com.proyectopd.omnichannel.services.Implementation.ProfesionalServiceImplementation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProfesionalServiceTests {

    @Mock
    UsuarioRepository usuarioRepository;

    @Mock
    ProfesionalRepository profesionalRepository;

    @InjectMocks
    ProfesionalServiceImplementation profesionalServiceImplementation;

    @Test
    public void testCreateProfesional() {
        Profesional newProfesional = new Profesional();
        newProfesional.setNombre("Nuevo Profesional");
        newProfesional.setIdProfesional(1);

        when(profesionalRepository.save(newProfesional)).thenReturn(newProfesional);
        boolean created = profesionalServiceImplementation.crearProfesional(newProfesional);

        assertEquals(true, created);

        verify(profesionalRepository, times(1)).save(newProfesional);
    }

    @Test
    public void testGetProfesionalById() {
        Profesional newProfesional = new Profesional();
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        newProfesional.setNombre("Nuevo Profesional");
        newProfesional.setUsuario(usuario);
        newProfesional.setIdProfesional(1);

        when(usuarioRepository.findById(1)).thenReturn(Optional.of(usuario));
        when(profesionalRepository.findProfesionalByUsuario_IdUsuario(1)).thenReturn(newProfesional);

        Profesional profesionalTest = profesionalServiceImplementation.getProfesionalById(1);

        assertEquals(newProfesional, profesionalTest);

        verify(usuarioRepository, times(1)).findById(1);
        verify(profesionalRepository, times(1)).findProfesionalByUsuario_IdUsuario(1);
    }

    @Test
    public void testDeleteProfesionalById() {
        Profesional newProfesional = new Profesional();
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        newProfesional.setNombre("Nuevo Profesional");
        newProfesional.setUsuario(usuario);
        newProfesional.setIdProfesional(1);

        doNothing().when(profesionalRepository).deleteProfesionalByUsuario(usuario);
        doNothing().when(usuarioRepository).deleteUsuarioByIdUsuario(1);

        when(usuarioRepository.findById(1)).thenReturn(Optional.of(usuario));

        boolean deleted = profesionalServiceImplementation.deleteProfesionalById(1);

        assertEquals(true, deleted);

        verify(profesionalRepository, times(1)).deleteProfesionalByUsuario(usuario);
        verify(usuarioRepository, times(1)).deleteUsuarioByIdUsuario(1);
    }

    @Test
    public void testGetAllFreeProfesionales() {
        ArrayList<Profesional> listOfProfesionales = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Profesional profesional = new Profesional();
            profesional.setNombre("Profesional " + i);
            profesional.setCantidadQuejasEncargadas(2);
            listOfProfesionales.add(profesional);
        }

        when(profesionalRepository.findProfesionalsByCantidadQuejasEncargadasIsLessThan(3)).thenReturn(listOfProfesionales);

        ArrayList<Profesional> listOfProfesionalesTest = (ArrayList<Profesional>) profesionalServiceImplementation.getAllFreeProfesionales();

        assertEquals(listOfProfesionales, listOfProfesionalesTest);

        verify(profesionalRepository, times(1)).findProfesionalsByCantidadQuejasEncargadasIsLessThan(3);
    }

}
