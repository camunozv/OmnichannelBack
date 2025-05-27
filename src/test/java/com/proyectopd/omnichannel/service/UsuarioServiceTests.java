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
        Optional<Usuario> usuarioResult = usuarioRepository.findById(1);

        assertEquals(usuarioTest, usuarioResult.get());

        verify(usuarioRepository, times(1)).findById(1);
    }

    @Test
    public void testCreateUser() {

        Usuario usuarioTest = new Usuario();

        usuarioTest.setIdUsuario(1);

        boolean usuarioResult = usuarioServiceImplementation.createUsuario(usuarioTest);

        assert(usuarioResult);
        verify(usuarioRepository, times(1)).findById(1);
    }

    /*@Test
    // Not implemented, since i dont want to alter the already implemented delete method.
    // Specifically i dont want to alter the return type, for me it's just fine.
    public void testDeleteUser() {

        Usuario usuarioTest = new Usuario();

        usuarioTest.setIdUsuario(1);

        when(usuarioRepository.deleteUsuarioByIdUsuario(usuarioTest.getIdUsuario())).then(usuarioRepository.findBy(usuarioTest.getIdUsuario())).thenReturn(Optional.of(usuarioTest));

        Usuario usuarioResult = usuarioRepository.save(usuarioTest);
        assertEquals(usuarioTest, usuarioResult);

        verify(usuarioRepository, times(1)).findById(1);

    }*/

}
