package com.hotelmolveno.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.hotelmolveno") // vragen aan Raymond
public class RoomSpringBoot {

    public static void main(String[] args) {
        SpringApplication.run(RoomSpringBoot.class, args);
    }
}