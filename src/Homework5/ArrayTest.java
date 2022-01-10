package Homework5;

public class ArrayTest {

    static final int size = 10000000;
    static final int halfSize = size/2;

    public static void main(String[] args) {

        first();

        second();

    }

    private static void first() {
        float[] array = new float[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1.0f;
        }
        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println(timeEnd - timeStart);
    }

    private static void second() {
        float[] array = new float[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1.0f;
        }

        long timeStart = System.currentTimeMillis();

        float[] leftArray = new float[halfSize];
        float[] rightArray = new float[halfSize];
        System.arraycopy(array, 0, leftArray, 0, halfSize);
        System.arraycopy(array, halfSize, leftArray, 0, halfSize);

        MyThread thread1 = new MyThread(leftArray);
        MyThread thread2 = new MyThread(rightArray);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(leftArray, 0, array, 0, leftArray.length);
        System.arraycopy(rightArray, 0, array, (thread1.getArray()).length, (thread2.getArray()).length);

        long timeEnd = System.currentTimeMillis();

        System.out.println(timeEnd - timeStart);

    }

}
