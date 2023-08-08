package com.msvc.partners;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsvcPartnersApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsvcPartnersApplication.class, args);
    }

}
