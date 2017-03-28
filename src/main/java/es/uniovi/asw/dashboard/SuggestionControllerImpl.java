package es.uniovi.asw.dashboard;

import es.uniovi.asw.dbmanagement.SuggestionData;
import es.uniovi.asw.dbmanagement.model.Suggestion;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;
import java.util.List;

@ManagedBean
public class SuggestionControllerImpl implements SuggestionController {
    @Autowired
    private SuggestionData data;

    @Override
    public Suggestion getSuggestion(Long id) {
        return data.getSuggestionData(id);
    }

    @Override
    public List<Suggestion> getAllSuggestions() {
        return data.getAllSuggestionsData();
    }
}
