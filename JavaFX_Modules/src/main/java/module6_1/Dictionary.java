package module6_1;

import java.util.*;

public class Dictionary {
    private final Map<String, String> data = new HashMap<>();

    public void addWord(String word, String meaning) {
        data.put(word.toLowerCase(), meaning);
    }

    public String getMeaning(String word) throws NoSuchElementException {
        String meaning = data.get(word.toLowerCase());
        if (meaning == null) throw new NoSuchElementException("Word not found: " + word);
        return meaning;
    }
}