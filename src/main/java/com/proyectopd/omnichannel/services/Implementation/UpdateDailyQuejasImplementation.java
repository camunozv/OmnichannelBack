package com.proyectopd.omnichannel.services.Implementation;

import com.proyectopd.omnichannel.services.QuejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class UpdateDailyQuejasImplementation {


    @Autowired
    private QuejaService quejaService;

    @Scheduled(cron = "0 0 0 * * ?") // Runs at midnight every day
    public void updateQuejasDaily() {
        quejaService.updateDailyQuejas();
    }

}
