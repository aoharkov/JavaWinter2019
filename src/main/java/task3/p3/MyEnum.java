package task3.p3;

public class MyEnum implements Comparable {
    private static MyEnum[] enumArray;
    private int ordinal;
    private String name;

    public static void createMyEnum(String[] names) {
        enumArray = new MyEnum[names.length];
        for (int i = 0; i < names.length; i++) {
            enumArray[i] = new MyEnum(i, names[i]);
        }
    }

    private MyEnum(int ordinal, String name) {
        this.ordinal = ordinal;
        this.name = name;
    }

    public static MyEnum[] values() {
        return enumArray;
    }

    public static MyEnum valueOf(String name) {
        MyEnum result = null;
        for (MyEnum myEnum : enumArray) {
            if (myEnum.name.equals(name)) {
                result = myEnum;
                break;
            }
        }
        if (result == null) {
            System.out.println("IllegalArgumentException in MyEnum.valueOf(...)");
        }
        return result;
    }

    @Override
    public int compareTo(Object o) {
        MyEnum other = (MyEnum) o;
        return this.ordinal - other.ordinal;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
