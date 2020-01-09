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
        String testText = "My name is Artem. This text I use to test my program. First, I wake up. Then, I get dressed. I walk to school. I do not ride a bike. I do not ride the bus. I like to go to school. It rains. I do not like rain. I eat lunch. I eat a sandwich and an apple.";
        view.viewData("Initial text:");
        view.viewData(testText);
        view.viewData("Translated text:");
        view.viewData(service.translate(testText));
        view.viewData("Translated text after we add a few new pairs of translation:");
        service.addPair("artem", "aртём");
        service.addPair("a", " ");
        service.addPair("an", " ");
        service.addPair("the", " ");
        view.viewData(service.translate(testText));
    }
}
