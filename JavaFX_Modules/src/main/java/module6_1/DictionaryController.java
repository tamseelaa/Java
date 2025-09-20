package module6_1;

public class DictionaryController {
    private final Dictionary dictionary;

    public DictionaryController(Dictionary dictionary) {
        this.dictionary = dictionary;
        // temporary hardcoded words
        dictionary.addWord("java", "A high-level programming language.");
        dictionary.addWord("python", "A programming language known for simplicity.");
        dictionary.addWord("dictionary", "A reference book or resource with words and meanings.");
    }

    public String searchWord(String word) {
        if (word == null || word.isBlank()) {
            return "Please enter a word.";
        }
        try {
            return dictionary.getMeaning(word);
        } catch (Exception e) {
            return "Word not found in dictionary.";
        }
    }
}
