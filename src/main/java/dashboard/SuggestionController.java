package dashboard;

import dbmanagement.model.Suggestion;

import java.util.List;

public interface SuggestionController {
    Suggestion getSuggestion(Long id);

    List<Suggestion> getAllSuggestions();
}
