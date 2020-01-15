package interviewpreparation.enums;

public enum DaysOfWeek {
    SUNDAY, MONDAY(true), TUESDAY, WEDNESDAY(true), THURSDAY, FRIDAY(true), SATURDAY;

    private boolean flag;

    DaysOfWeek() {
    }

    DaysOfWeek(boolean flag) {
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public DaysOfWeek nextDay() {
        DaysOfWeek[] days = DaysOfWeek.values();
        return days[(this.ordinal() + 1) % days.length];
    }
}
