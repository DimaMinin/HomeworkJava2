package Homework_6_Java3;

import java.util.Arrays;

public class Homework_6 {

    public int[] task1 (int[] array) {
        for (int i = array.length - 1; i >=0; i--) if (array[i] == 4) return Arrays.copyOfRange(array, i + 1, array.length);
        throw new RuntimeException();
    }

    public  boolean task2 (int[] array) {
        boolean digit1 = false;
        boolean digit4 = false;
        for (int digit : array) {
            if (digit == 1) digit1 = true;
            if (digit == 4) digit4 = true;
        }
        return digit1 && digit4;
    }

}
