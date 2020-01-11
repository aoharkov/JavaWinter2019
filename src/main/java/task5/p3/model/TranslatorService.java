package task5.p3.model;

import java.text.BreakIterator;
import java.util.Locale;
import java.util.Map;

public class TranslatorService {
    private Map<String, String> dictionary;

    public TranslatorService() {
        dictionary = TranslatorDictionaryLoader.load();
    }

    public void addPair(String eng, String rus) {
        dictionary.put(eng, rus);
    }

    public String translateText(String text) {
        StringBuilder result = new StringBuilder();
        String[] words = text.toLowerCase().split("(?<=[^a-zA-Z])");
        for (String word : words) {
            if (word.length() > 1) {
                String translation = dictionary.getOrDefault(word.substring(0, word.length() - 1), "");
                if (!translation.equals("")) {
                    result.append(translation);
                } else {
                    result.append("\"").append(word, 0, word.length() - 1).append("\"");
                }
                result.append(word.charAt(word.length() - 1));
            } else {
                result.append(word);
            }
        }
        return result.toString().replaceAll("[\\s]{2,}", " ");
    }


}
