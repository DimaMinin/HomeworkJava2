package Homework6.helper;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Process implements Runnable{

    private Scanner scan;
    private DataOutputStream out;
    String message;

    public Process(Scanner scan, DataOutputStream out) {
        this.scan = scan;
        this.out = out;
    }

    @Override
    public void run() {
        try {
            while (true) {
                message = scan.nextLine();
                out.writeUTF(message);
                out.flush();
                if (message.equals("end")) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
