package es.uniovi.asw;


import es.uniovi.asw.dashboard.controllers.SuggestionController;
import es.uniovi.asw.dbmanagement.model.Suggestion;
import es.uniovi.asw.util.ProducerDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}