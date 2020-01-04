package task5.p1.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum LogEntryField {
    SURNAME(
            "[A-Z][a-z]*",
            "Surname"),
    NAME(
            "[A-Z][a-z]*",
            "Name"),
    DATEOFBIRTH(
            "(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/(19[0-9]{2}|20[0-1][0-9])",
            "01/01/2001"),
    TELEPHONENUMBER(
            "\\+[1-9]\\d{0,2}\\(\\d{3}\\)(\\d{3}(-\\d{2}){2}|(\\d{2}-){2}\\d{3})",
            "+380(098)765-43-21 or +380(098)76-54-321"),
    HOMEADDRESS(
            "[A-Z][a-z]*( [A-Z][a-z]*)*, [1-9][0-9]*[a-z]*, [1-9][0-9]*[a-z]*",
            "Wall Street, 1a, 16");
    private Pattern pattern;
    private String example;

    LogEntryField(String pattern, String example) {
        this.pattern = Pattern.compile(pattern);
        this.example = example;
    }

    public boolean validate(String str) {
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public String getExample() {
        return example;
    }
}
