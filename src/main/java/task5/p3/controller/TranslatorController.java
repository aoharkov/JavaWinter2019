package task5.p3.controller;

import task5.p3.model.TranslatorService;
import task5.p3.view.TranslatorInput;
import task5.p3.view.TranslatorView;

public class TranslatorController implements Runnable {
    private TranslatorInput input;
    private TranslatorView view;
    private TranslatorService service;

    public TranslatorController() {
        input = new TranslatorInput();
        view = new TranslatorView();
        service = new TranslatorService();
    }

    @Override
    public void run() {
        String testText = "My name is Artem.\n" +
                "This text I use to test my program.\n" +
                "First, I wake up. Then, I get dressed.\n" +
                "I walk to school. I do not ride a bike.\n" +
                "I do not ride the bus. I like to go to school.\n" +
                "It rains. I do not like rain.\n" +
                "I eat lunch. I eat a sandwich and an apple.\n";
        view.viewData("Initial text:");
        view.viewData(testText);
        view.viewData("Translated text:");
        view.viewData(service.translateText(testText));
        view.viewData("Translated text after we add a few new pairs of translation:");
        service.addPair("artem", "aртём");
        service.addPair("a", " ");
        service.addPair("an", " ");
        service.addPair("the", " ");
        service.addPair("rains", "дожди");
        view.viewData(service.translateText(testText));
    }
}
