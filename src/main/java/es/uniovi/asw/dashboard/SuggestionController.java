package es.uniovi.asw.dashboard;

import es.uniovi.asw.dbmanagement.model.Suggestion;

import java.util.List;

public interface SuggestionController {
    Suggestion getSuggestion(Long id);

    List<Suggestion> getAllSuggestions();
}
