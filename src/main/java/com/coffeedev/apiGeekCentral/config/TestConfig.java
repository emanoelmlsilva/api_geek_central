package com.coffeedev.apiGeekCentral.config;

import com.coffeedev.apiGeekCentral.services.BDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private BDService bdService;

    @Bean
    public boolean instantiateDatabase() throws ParseException {
        bdService.instantiateTestDatabase();
        return true;
    }
}
