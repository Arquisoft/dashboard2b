package es.uniovi.asw;


import es.uniovi.asw.dbmanagement.model.Suggestion;
import es.uniovi.asw.util.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner demo(Producer producer) {
        return (args) -> {
            Suggestion s = producer.insertSuggestion(new Suggestion("Prueba1"));

            while (true) {
                Thread.sleep(5000);
                producer.simulateVotes(s.getId());

            }
        };
    }
}