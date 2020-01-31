package com.bank.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class ApplicationMessenger {
    private Locale locale;
    private ResourceBundle resource;

    public ApplicationMessenger() {
        this.locale = new Locale("en", "US");
        this.resource = ResourceBundle.getBundle("text", locale);
    }

    public String getMessage(String messageKey) {
        return resource.getString(messageKey);
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        this.resource = ResourceBundle.getBundle("text", locale);
    }
}
