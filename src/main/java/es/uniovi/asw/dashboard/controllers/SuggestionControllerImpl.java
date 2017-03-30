package es.uniovi.asw.dashboard.controllers;

import es.uniovi.asw.dbmanagement.SuggestionData;
import es.uniovi.asw.dbmanagement.model.Suggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.ManagedBean;
import java.util.List;

@ManagedBean
public class SuggestionControllerImpl implements SuggestionController {
    @Autowired
    private SuggestionData data;

    @RequestMapping(path = "/suggestion/{id}", method = RequestMethod.GET)
    @Override
    public Suggestion getSuggestion(@PathVariable Long id) {
        return data.getSuggestionData(id);
    }

    @RequestMapping(path = "/suggestion", method = RequestMethod.GET)
    @Override
    public List<Suggestion> getAllSuggestions() {
        return data.getAllSuggestionsData();
    }
}
