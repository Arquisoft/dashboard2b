package dashboard;

import dbmanagement.SuggestionData;
import dbmanagement.model.Suggestion;

import java.util.List;

public class SuggestionControllerImpl implements SuggestionController {

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
