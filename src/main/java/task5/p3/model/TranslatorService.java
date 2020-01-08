package task5.p3.model;

import java.util.Map;

public class TranslatorService {
    private Map<String, String> dictionary;

    public TranslatorService() {
        dictionary = TranslatorDictionaryLoader.load();
    }

    public void addPair(String eng, String rus) {
        dictionary.put(eng, rus);
    }

    public String translate(String text) {
        StringBuilder result = new StringBuilder();
        String[] words = text.split("[^a-zA-Z]");
        for (String word : words) {
            String translation = dictionary.getOrDefault(word, word);
            if (!translation.equals("") && !translation.equals(" ")) {
                result.append(translation);
                result.append(" ");
            }
        }
        return result.toString();
    }


}
