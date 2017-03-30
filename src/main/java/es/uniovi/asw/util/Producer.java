package es.uniovi.asw.util;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
        ObjectNode node = JsonNodeFactory.instance.objectNode(); // initializing
        node.put("Created", ":D"); // building
        log.info(
                "Saved new suggestion - id:" + s.getId() + ", title:" + s
                        .getTitle());
        producer.send("exampleTopic", node.toString());
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
