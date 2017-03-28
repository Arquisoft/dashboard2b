package es.uniovi.asw.util;

import es.uniovi.asw.Application;
import es.uniovi.asw.dbmanagement.SuggestionRepository;
import es.uniovi.asw.dbmanagement.model.Suggestion;
import es.uniovi.asw.hello.producers.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;

@ManagedBean
public class Producer {

    @Autowired
    private SuggestionRepository repository;
    @Autowired
    private KafkaProducer producer;

    private Logger log = LoggerFactory.getLogger(Application.class);

    public Suggestion insertSuggestion(Suggestion s) {
        s = repository.save(s);
        log.info(
                "Saved new suggestion - id:" + s.getId() + ", title:" + s
                        .getTitle());
        producer.send("exampleTopic", "Created:" + s.getId());
        return s;
    }


    public void simulateVotes(Long id) {
        Suggestion s = repository.findOne(id);
        int numberOfVotes = s.vote();
        repository.save(s);
        log.info(
                "Voted suggestion - id:" + s.getId() + ", title:" + s
                        .getTitle() + ", votes:" + s.getNumberOfVotes());
        producer.send("exampleTopic", "Voted:" + id);
    }
}
