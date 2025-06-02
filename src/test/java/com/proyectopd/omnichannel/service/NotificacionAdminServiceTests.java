package com.proyectopd.omnichannel.service;

import com.proyectopd.omnichannel.models.NotificacionAdmin;
import com.proyectopd.omnichannel.repositories.NotificacionAdminRepository;
import com.proyectopd.omnichannel.services.Implementation.NotificacionAdminImplementation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NotificacionAdminServiceTests {

    @Mock
    NotificacionAdminRepository notificacionAdminRepository;

    @InjectMocks
    NotificacionAdminImplementation notificacionAdminImplementation;

    @Test
    public void testGetAllNotificacionesAdmin() {

        ArrayList<NotificacionAdmin> listOfNotificaciones = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            NotificacionAdmin notificacion = new NotificacionAdmin();
            notificacion.setIdNotificacion(i);
            notificacion.setTextoNotificacion("Notificacion " + i);
            listOfNotificaciones.add(notificacion);
        }

        when(notificacionAdminRepository.findAll()).thenReturn(listOfNotificaciones);

        ArrayList<NotificacionAdmin> returnNotificaciones = (ArrayList<NotificacionAdmin>) notificacionAdminImplementation.getAllNotificaciones();

        assertEquals(listOfNotificaciones, returnNotificaciones);

        verify(notificacionAdminRepository, times(1)).findAll();

    }

    @Test
    public void testCreateNotificacion() {

        NotificacionAdmin notificacion = new NotificacionAdmin();
        notificacion.setTextoNotificacion("Notificacion de prueba");

        // Evitar la validación estricta
        lenient().when(notificacionAdminRepository.save(notificacion)).thenReturn(notificacion);

        boolean createdNotificacion = notificacionAdminImplementation.createNotificacion("Notificacion de prueba");

        assertEquals(true, createdNotificacion);

        verify(notificacionAdminRepository, times(1)).save(any(NotificacionAdmin.class));
    }

    @Test
    public void testDeleteNotificacion() {
        doNothing().when(notificacionAdminRepository).deleteById(1);

        boolean deletedNotificacion = notificacionAdminImplementation.deleteNotificacion(1);

        assertEquals(true, deletedNotificacion);

        verify(notificacionAdminRepository, times(1)).deleteById(1);
    }


    @Test
    public void testGetNotificacionById() {
        NotificacionAdmin notificacion = new NotificacionAdmin();
        notificacion.setIdNotificacion(1);
        notificacion.setTextoNotificacion("Notificacion de prueba");

        when(notificacionAdminRepository.findById(1)).thenReturn(Optional.of(notificacion));

        NotificacionAdmin returnNotificacion = notificacionAdminImplementation.getNotificacionById(1);

        assertEquals(notificacion, returnNotificacion);

        verify(notificacionAdminRepository, times(1)).findById(1);
    }

}
