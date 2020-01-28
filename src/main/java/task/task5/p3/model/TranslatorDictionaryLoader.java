package task.task5.p3.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class TranslatorDictionaryLoader {
    private static Logger logger = LogManager.getLogger(TranslatorDictionaryLoader.class);
    private static String path = "D:\\Projects\\JavaWinter2019\\src\\main\\resources\\tasks\\task.task5\\p3\\model\\Pairs for translation.txt";

    static Map<String, String> load() {
        Map<String, String> dictionary = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "windows-1251"))) {
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
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return dictionary;
    }
}
