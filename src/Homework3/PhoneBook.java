package Homework3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    private  List<String> phoneNumber = new ArrayList<>();
    private Map<String, List<String>> phoneBook = new HashMap<>();


    public void add (String name, String number) {
        if (phoneBook.containsKey(name)) {
            phoneNumber = phoneBook.get(name);
            phoneNumber.add(number);
            phoneBook.put(name, phoneNumber);
        } else {
            phoneNumber = new ArrayList<>();
            phoneNumber.add(number);
            phoneBook.put(name, phoneNumber);
        }
    }


    public List<String> get (String name) {
        return phoneBook.get(name);
    }

}
