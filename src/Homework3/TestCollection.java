package Homework3;

import java.util.*;

public class TestCollection {

    public static void main(String[] args) {
        createArrayCountWords();

        testPhoneBook();

    }

    private static void testPhoneBook() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Верёвкин", "89765585664");
        phoneBook.add("Антонов", "87976876671");
        phoneBook.add("Игнатьев", "89098792361");
        phoneBook.add("Алёхин", "85456795857");
        phoneBook.add("Новиков", "85336457601");
        phoneBook.add("Новиков", "85347114223");
        phoneBook.add("Антонов", "85332221143");

        System.out.println(phoneBook.get("Антонов"));
        System.out.println(phoneBook.get("Новиков"));
        System.out.println(phoneBook.get("Игнатьев"));
    }

    private static void createArrayCountWords () {
        Map<String, Integer> stringIntegerHashMap = new HashMap<>();
        List<String> stringList = new ArrayList<>();
        stringList.add("игры");
        stringList.add("имя");
        stringList.add("музыка");
        stringList.add("погода");
        stringList.add("мышка");
        stringList.add("компьютер");
        stringList.add("погода");
        stringList.add("игры");
        stringList.add("музыка");
        stringList.add("качели");

        for (int i = 0; i < stringList.size(); i++) {
            if (stringIntegerHashMap.containsKey(stringList.get(i))) {
                stringIntegerHashMap.put(stringList.get(i), stringIntegerHashMap.get(stringList.get(i)) + 1);
            } else {
                stringIntegerHashMap.put(stringList.get(i), 1);
            }
        }
        System.out.println(stringIntegerHashMap);
    }

}
