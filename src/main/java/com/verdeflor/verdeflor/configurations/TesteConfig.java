package com.verdeflor.verdeflor.configurations;

import com.verdeflor.verdeflor.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("homologacao")
public class TesteConfig {
    @Autowired
    DBService dbService;

    private boolean instanciarDB() throws ParseException {
        this.dbService.instanciarDB();
        return true;
    }
}
