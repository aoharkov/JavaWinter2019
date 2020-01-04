package task5.p1.model;

import java.util.Objects;

public class LogEntry {
    private String surname;
    private String name;
    private String dateOfBirth;
    private String telephoneNumber;
    private String homeAddress;

    public LogEntry(String surname, String name, String dateOfBirth, String telephoneNumber, String homeAddress) {
        this.surname = surname;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.telephoneNumber = telephoneNumber;
        this.homeAddress = homeAddress;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogEntry)) return false;
        LogEntry logEntry = (LogEntry) o;
        return surname.equals(logEntry.surname) &&
                name.equals(logEntry.name) &&
                dateOfBirth.equals(logEntry.dateOfBirth) &&
                Objects.equals(telephoneNumber, logEntry.telephoneNumber) &&
                Objects.equals(homeAddress, logEntry.homeAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, dateOfBirth, telephoneNumber, homeAddress);
    }

    @Override
    public String toString() {
        return surname + ", " + name + ", " + dateOfBirth + ", " + telephoneNumber + ", " + homeAddress;
    }
}
