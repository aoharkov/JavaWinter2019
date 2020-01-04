package task5.p1.model.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum LogEntryField {
    SURNAME("[A-Z][a-z]*"),
    NAME("[A-Z][a-z]*"),
    DATEOFBIRTH("(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/(19[0-9]{2}|20[0-1][0-9])"),
    TELEPHONENUMBER("\\+[1-9]\\d{0,2}\\(\\d{3}\\)(\\d{3}(-\\d{2}){2}|(\\d{2}-){2}\\d{3})"),
    HOMEADDRESS("[A-Z][a-z]*( [A-Z][a-z]*)*, [1-9][0-9]*[a-z]*, [1-9][0-9]*[a-z]*");
    private Pattern pattern;

    LogEntryField(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    public boolean validate(String str) {
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
