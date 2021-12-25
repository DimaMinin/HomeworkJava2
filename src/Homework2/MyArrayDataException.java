package Homework2;

public class MyArrayDataException extends RuntimeException {

    public MyArrayDataException(int row, int col) {
        super("Неверное значение в " + (row + 1) + " ряду " + (col + 1) + " столбце!");
    }
}
