package Homework2;

public class TestException {

    private static final int SIZE = 4;
    private static String digit = "1";
    private static String[][] table;

    public static void main(String[] args) {

        table = new String[SIZE][SIZE];

        String[][] correctTable = createCorrectTable(table);
        String[][] incorrectValueTable = createIncorrectValueTable(table);
        String[][] incorrectDataTable = createIncorrectDataTable(table);

        try {
            int sum = sumArray(incorrectDataTable);
            System.out.println(sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String[][] createCorrectTable (String[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = digit;
                int conversion = Integer.parseInt(digit);
                int newDigit = conversion + 1;
                digit = Integer.toString(newDigit);
            }
        }
        String[][] correctTable = new String[SIZE][SIZE];
        for (int i = 0; i < correctTable.length; i++) {
            for (int j = 0; j < correctTable[i].length; j++) {
                correctTable[i][j] = table[i][j];
            }
        }
        return correctTable;
    }

    private static String[][] createIncorrectValueTable (String[][] table) {
        String[][] incorrectValueTable = new String[SIZE][SIZE - 1];
        for (int i = 0; i < incorrectValueTable.length; i++) {
            for (int j = 0; j < incorrectValueTable[i].length; j++) {
                incorrectValueTable[i][j] = table[i][j];
            }
        }
        return incorrectValueTable;
    }

    private static String[][] createIncorrectDataTable (String[][] table) {
        String[][] incorrectDataTable = new String[SIZE][SIZE];
        for (int i = 0; i < incorrectDataTable.length; i++) {
            for (int j = 0; j < incorrectDataTable[i].length; j++) {
                incorrectDataTable[i][j] = table[i][j];
            }
        }
        incorrectDataTable[2][3] = "Error";
        return incorrectDataTable;
    }

    private static int sumArray (String[][] table) {
        checkSize(table);
        int count = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                try {
                    int value = Integer.parseInt(table[i][j]);
                    count += value;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return count;
    }

    private static void checkSize (String[][] table) {
        if (table.length != SIZE) {
            throw new MyArraySizeException();
        }

        for (int i = 0; i < table.length; i++) {
            if (table[i].length != SIZE) {
                throw new MyArraySizeException();
            }
        }
    }
}
