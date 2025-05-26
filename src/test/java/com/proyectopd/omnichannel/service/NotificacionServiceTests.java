package com.proyectopd.omnichannel.service;

import com.proyectopd.omnichannel.models.Notificacion;
import com.proyectopd.omnichannel.models.Usuario;
import com.proyectopd.omnichannel.repositories.NotificacionRepository;
import com.proyectopd.omnichannel.repositories.UsuarioRepository;
import com.proyectopd.omnichannel.services.Implementation.NotificacionServiceImplementation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NotificacionServiceTests {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private NotificacionRepository notificacionRepository;

    @InjectMocks
    private NotificacionServiceImplementation notificacionServiceImplementation;

    @Test
    public void testGetAllNotificacionesUsuario() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);

        ArrayList<Notificacion> listOfNotifs = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Notificacion notificacion = new Notificacion();
            notificacion.setIdNotificacion(i);
            notificacion.setTextoNotificacion("Notificacion " + i);
            notificacion.setUsuario(usuario);
            listOfNotifs.add(notificacion);
        }

        usuario.setNotificaciones(listOfNotifs);

        when(usuarioRepository.findById(1)).thenReturn(Optional.of(usuario));
        when(notificacionRepository.getNotificacionsByUsuarioEquals(usuario)).thenReturn(listOfNotifs);

        ArrayList<Notificacion> listOfNotifsTest = (ArrayList<Notificacion>) notificacionServiceImplementation.getAllNotificacionesUsuario(1);

        assertEquals(listOfNotifs, listOfNotifsTest);

        verify(usuarioRepository, times(1)).findById(1);
        verify(notificacionRepository, times(1)).getNotificacionsByUsuarioEquals(usuario);

    }

    @Test
    public void testGetNotificacionById() {

        Notificacion notificacion = new Notificacion();
        notificacion.setIdNotificacion(1);
        notificacion.setTextoNotificacion("Notificacion de prueba");

        when(notificacionRepository.getNotificacionByIdNotificacion(1)).thenReturn(notificacion);

        Notificacion returnNotificacion = notificacionServiceImplementation.getNotificacionById(1);

        assertEquals(notificacion, returnNotificacion);

        verify(notificacionRepository, times(1)).getNotificacionByIdNotificacion(1);
    }

    @Test
    public void deleteNotificacionById() {
        doNothing().when(notificacionRepository).deleteNotificacionByIdNotificacionEquals(1);

        boolean deleted = notificacionServiceImplementation.deleteNotificacionById(1);

        assertEquals(true, deleted);

        verify(notificacionRepository, times(1)).deleteNotificacionByIdNotificacionEquals(1);
    }

}
