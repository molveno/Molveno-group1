package com.hotelmolveno;

import com.hotelmolveno.controller.AppController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
        AppController appController = new AppController();
        appController.run();
    }
}