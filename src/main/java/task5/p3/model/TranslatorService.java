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
        String[] words = text.toLowerCase().split("[^a-zA-Z]");
        for (String word : words) {
            if (!word.equals("") && !word.equals(" ")) {
                String translation = dictionary.getOrDefault(word, "");
                if (!translation.equals(" ")) {
                    if (!translation.equals("")) {
                        result.append(translation);
                        result.append(" ");
                    } else {
                        result.append("\"").append(word).append("\" ");
                    }
                }
            }
        }
        return result.toString().replaceAll("[\\s]{2,}", " ");
    }


}
