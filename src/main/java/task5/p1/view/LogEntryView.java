package task5.p1.view;

import task5.p1.model.LogEntry;

import java.util.List;

public class LogEntryView {
    public static final String DELIMITER = "----------------------------";

    public void viewData(String message) {
        System.out.println(message);
    }

    public void printJournal(List<LogEntry> journal) {
        for (LogEntry entry : journal) {
            viewData(entry.toString());
        }
    }
}
