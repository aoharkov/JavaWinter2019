package task5.p3.model;

import java.util.HashMap;
import java.util.Map;

public class TranslatorDictionaryLoader {
    public static Map<String, String> load(){
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("is", "");
        dictionary.put("the", "");
        dictionary.put("capital", "столица");
        dictionary.put("of", "");
        return dictionary;
    }
}
