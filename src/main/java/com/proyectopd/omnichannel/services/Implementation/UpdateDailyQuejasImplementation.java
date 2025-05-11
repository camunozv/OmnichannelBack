package com.proyectopd.omnichannel.services.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class UpdateDailyQuejasImplementation {

    @Autowired
    private QuejaServiceImplementation quejaService;

    @Autowired
    private NotificacionServiceImplementation notificacionService;

    //@Scheduled(cron = "0 0 0 * * ?")// Runs at midnight every day
    //@Scheduled(initialDelay = 300000) // For testing the method
    @Scheduled(fixedRate = 300000) // Executes the method every 5 minutes
    public void updateQuejasDaily() {

        boolean var1 = quejaService.updateDailyQuejas();

        if (var1) {
            notificacionService.createNotificacion("Se han actualizado las quejas diarias correctamente.");
        } else {
            notificacionService.createNotificacion("No se han podido actualizar las quejas diarias.");
        }

        boolean var2 = quejaService.assignProfesional();
        if (var2) {
            notificacionService.createNotificacion("Se han asignado profesionales a las quejas correctamente.");
        } else {
            notificacionService.createNotificacion("No se han podido asignar todas las quejas, no hay profesionales disponibles.");
        }

    }

}
