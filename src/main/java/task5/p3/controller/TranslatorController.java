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
        String testPhrase = "London is the capital of Great Britain.";
        view.viewData(service.translate(testPhrase));
        service.addPair("Great", "Великий");
        view.viewData(service.translate(testPhrase));

    }
}
