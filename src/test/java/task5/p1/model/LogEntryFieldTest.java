package task5.p1.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LogEntryFieldTest {
    @Parameterized.Parameter
    public LogEntryField logEntryField;
    @Parameterized.Parameter(1)
    public boolean expected;
    @Parameterized.Parameter(2)
    public String str;

    @Parameterized.Parameters(name= "{index}: {2} ({1})")
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {LogEntryField.SURNAME, true, "Oharkov"},
                {LogEntryField.NAME, true, "Artem"},
                {LogEntryField.DATEOFBIRTH, true, "01/02/2003"},
                {LogEntryField.TELEPHONENUMBER, true, "+380(098)765-43-21"},
                {LogEntryField.TELEPHONENUMBER, true, "+380(098)76-54-321"},
                {LogEntryField.TELEPHONENUMBER, true, "+44(098)765-43-21"},
                {LogEntryField.HOMEADDRESS, true, "Fleet Street, 1, 16"},
                {LogEntryField.HOMEADDRESS, true, "Fleet Street, 1a, 16"},
                {LogEntryField.SURNAME, false, "0harkov"},
                {LogEntryField.NAME, false, "@rtem"},
                {LogEntryField.DATEOFBIRTH, false, "00/02/2003"},
                {LogEntryField.DATEOFBIRTH, false, "1/2/2003"},
                {LogEntryField.DATEOFBIRTH, false, "01/20/2003"},
                {LogEntryField.DATEOFBIRTH, false, "01/02/2030"},
                {LogEntryField.TELEPHONENUMBER, false, "+38(098)7654-321"},
                {LogEntryField.TELEPHONENUMBER, false, "+380(098)765-4-3-21"},
                {LogEntryField.TELEPHONENUMBER, false, "+38(098)765-4321"},
                {LogEntryField.HOMEADDRESS, false, "Fleet Street 1, 16"},
                {LogEntryField.HOMEADDRESS, false, "Fleet Street, 1"}
        });
    }

    @Test
    public void validate() {
        assertEquals(expected, logEntryField.validate(str));
    }
}