package task5.p3.model;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TranslatorDictionaryLoader {
    private static String path = "D:\\Projects\\JavaWinter2019\\src\\main\\java\\task5\\p3\\model\\Pairs for translation.txt";

    public static Map<String, String> load() {
        Map<String, String> dictionary = new HashMap<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "windows-1251"));
            String line = reader.readLine();
            while (line != null) {
                String[] translation = line.split("( -- )|,|\\(|\\)|;|!");
                if (translation.length >= 2) {
                    if (!dictionary.containsKey(translation[0])) {
                        dictionary.put(translation[0], translation[1]);
                    }
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dictionary;
    }
}
