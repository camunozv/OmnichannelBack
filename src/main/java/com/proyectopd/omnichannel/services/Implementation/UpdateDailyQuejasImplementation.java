package com.proyectopd.omnichannel.services.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class UpdateDailyQuejasImplementation {

    @Autowired
    private QuejaServiceImplementation quejaService;

    //@Scheduled(cron = "0 0 0 * * ?")// Runs at midnight every day
    @Scheduled(initialDelay = 300000) // For testing the method
    public void updateQuejasDaily() {
        System.out.println("Updating quejas daily");
        quejaService.assignProfesional();
    }

}
