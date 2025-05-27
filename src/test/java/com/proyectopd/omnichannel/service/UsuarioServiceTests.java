package com.proyectopd.omnichannel.service;

import com.proyectopd.omnichannel.models.Usuario;
import com.proyectopd.omnichannel.repositories.UsuarioRepository;
import com.proyectopd.omnichannel.services.Implementation.UsuarioServiceImplementation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

// Allow class and interface mocking
@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTests {

    // 1. Mock the clases used within the original service class
    @Mock
    private UsuarioRepository usuarioRepository;

    // 2. Make the system to test use the mocked classses.
    @InjectMocks
    private UsuarioServiceImplementation usuarioServiceImplementation;

    // 3. Write the test within a function
    @Test
    public void testGetUsuarioById() {

        Usuario usuarioTest = new Usuario();
        usuarioTest.setIdUsuario(1);

        when(usuarioRepository.findById(1)).thenReturn(Optional.of(usuarioTest));
        Usuario usuarioResult = usuarioServiceImplementation.getUsuarioById(1);

        assertEquals(usuarioTest.getIdUsuario(), usuarioResult.getIdUsuario());

        verify(usuarioRepository, times(1)).findById(1);
    }

    @Test
    public void testCreateUser() {

        Usuario usuarioTest = new Usuario();

        usuarioTest.setIdUsuario(1);

        boolean usuarioResult = usuarioServiceImplementation.createUsuario(usuarioTest);

        assert (usuarioResult);
    }

    @Test
    public void testDeleteUsuario() {
        Usuario usuarioTest = new Usuario();
        usuarioTest.setIdUsuario(1);

        boolean deleted = usuarioServiceImplementation.deleteUsuario(1);

        assert (deleted);
    }

}
