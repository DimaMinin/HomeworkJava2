package Homework5;

public class MyThread extends Thread {

    private float[] array;

    public MyThread(float[] array) {
        this.array = array;
    }

    public float[] getArray() {
        return array;
    }

    @Override
    public void run() {
        count();
    }

    private void count () {
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = (float)(this.array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

}
