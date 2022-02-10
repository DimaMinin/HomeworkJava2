package Homework_4_Java3;

public class Letters {

    private Object mon = new Object();
    private String currentLetter = "A";

    public static void main(String[] args) {

        Letters waitNotifyObject = new Letters();

        Thread thread1 = new Thread(waitNotifyObject::printA);
        Thread thread2 = new Thread(waitNotifyObject::printB);
        Thread thread3 = new Thread(waitNotifyObject::printC);

        thread1.start();
        thread2.start();
        thread3.start();

    }


    private void printA () {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != "A") {
                        mon.wait();
                    }
                    System.out.print(currentLetter);
                    currentLetter = "B";
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printB () {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != "B") {
                        mon.wait();
                    }
                    System.out.print(currentLetter);
                    currentLetter = "C";
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printC () {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != "C") {
                        mon.wait();
                    }
                    System.out.print(currentLetter);
                    currentLetter = "A";
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
