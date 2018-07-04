package com.hotelmolveno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @ComponentScan(basePackages = "com.hotelmolveno") // vragen aan Raymond
public class RoomSpringBoot {

    public static void main(String[] args) {
        SpringApplication.run(RoomSpringBoot.class, args);
    }
}