package com.proyectopd.omnichannel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OmnichannelApplication {

    public static void main(String[] args) {
        SpringApplication.run(OmnichannelApplication.class, args);
    }

}
