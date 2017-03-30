package es.uniovi.asw.dashboard.controllers;

import es.uniovi.asw.dbmanagement.model.Suggestion;

import java.util.List;

public interface SuggestionController {
    Suggestion getSuggestion(Long id);

    List<Suggestion> getAllSuggestions();
}
