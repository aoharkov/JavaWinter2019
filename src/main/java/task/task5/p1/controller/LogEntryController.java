package task.task5.p1.controller;

import task.task5.p1.model.LogEntry;
import task.task5.p1.model.LogEntryField;
import task.task5.p1.view.LogEntryInput;
import task.task5.p1.view.LogEntryView;

import java.util.ArrayList;
import java.util.List;

public class LogEntryController implements Runnable {
    private LogEntryView view;
    private LogEntryInput input;
    private List<LogEntry> journal;

    public LogEntryController() {
        view = new LogEntryView();
        input = new LogEntryInput();
        journal = new ArrayList<>();
    }

    @Override
    public void run() {
        readLogEntry();
        readLogEntry();
        view.printJournal(journal);
    }

    private void readLogEntry() {
        String surname = readField(LogEntryField.SURNAME);
        String name = readField(LogEntryField.NAME);
        String dateOfBirth = readField(LogEntryField.DATEOFBIRTH);
        String telephoneNumber = readField(LogEntryField.TELEPHONENUMBER);
        String homeAddress = readField(LogEntryField.HOMEADDRESS);
        journal.add(new LogEntry(surname, name, dateOfBirth, telephoneNumber, homeAddress));
    }

    private String readField(LogEntryField field) {
        view.viewData("Please enter " + field.name().toLowerCase());
        String str = input.nextLine();
        while (!field.validate(str)) {
            view.viewData("Please enter in the right format.\nFor example: " + field.getExample());
            str = input.nextLine();
        }
        return str;
    }
}
