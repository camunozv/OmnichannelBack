package com.proyectopd.omnichannel.service;

import com.proyectopd.omnichannel.services.Implementation.NotificacionAdminImplementation;
import com.proyectopd.omnichannel.services.Implementation.QuejaServiceImplementation;
import com.proyectopd.omnichannel.services.Implementation.UpdateDailyQuejasImplementation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UpdateDailyQuejasTests {

    @Mock
    private QuejaServiceImplementation quejaService;

    @Mock
    private NotificacionAdminImplementation notificacionAdminService;

    @InjectMocks
    private UpdateDailyQuejasImplementation updateDailyQuejasImplementation;

    @Test
    public void testUpdateDailyQuejas() {
        when(quejaService.updateDailyQuejas()).thenReturn(true);
        when(quejaService.assignProfesional()).thenReturn(true);

        when(notificacionAdminService.createNotificacion("Se han actualizado las quejas diarias correctamente.")).thenReturn(true);
        when(notificacionAdminService.createNotificacion("Se han asignado profesionales a las quejas correctamente.")).thenReturn(true);

        boolean updatedQuejasSuccessfully = updateDailyQuejasImplementation.updateQuejasDaily();

        assert (updatedQuejasSuccessfully);

        verify(quejaService, times(1)).updateDailyQuejas();
        verify(quejaService, times(1)).assignProfesional();

        verify(notificacionAdminService, times(1)).createNotificacion("Se han actualizado las quejas diarias correctamente.");
        verify(notificacionAdminService, times(1)).createNotificacion("Se han asignado profesionales a las quejas correctamente.");

    }
}
