package com.jk.hr.fantasy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class FantasyHorseracingApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(FantasyHorseracingApplication.class, args);

    }
}