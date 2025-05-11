package com.proyectopd.omnichannel.services.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class UpdateDailyQuejasImplementation {

    @Autowired
    private QuejaServiceImplementation quejaService;

    //@Scheduled(cron = "0 0 0 * * ?")// Runs at midnight every day
    //@Scheduled(initialDelay = 300000) // For testing the method
    @Scheduled(fixedRate = 300000) // Executes the method every 5 minutes
    public boolean updateQuejasDaily() {

        boolean var1 = quejaService.updateDailyQuejas();
        boolean var2 = quejaService.assignProfesional();

        // ¿Que pasa ahora sino puedo asignar un profesional a todas las quejas?
        return quejaService.assignProfesional();
    }

}
