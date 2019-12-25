package task3.p3;

public class Main {
    public static void main(String[] args) {
        String[] seasonNames = {"SPRING", "SUMMER", "AUTUMN", "WINTER"};
        MyEnum.createMyEnum(seasonNames);
        singleValueDemo();
        allValuesDemo();
    }

    private static void singleValueDemo() {
        System.out.println("singleValueDemo:");
        MyEnum myEnum = MyEnum.valueOf("WINTER");
        if (myEnum != null) {
            System.out.println(myEnum);
            System.out.println(
                    String.format("Name = %s, ordinal = %d",
                            myEnum.getName(), myEnum.getOrdinal()));
        }
    }

    private static void allValuesDemo() {
        System.out.println("allValuesDemo:");
        for (MyEnum myEnum : MyEnum.values()) {
            System.out.print(myEnum + " ");
        }
        System.out.println();
    }

}
