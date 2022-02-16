package Homework_5_Java3;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Service {

    private final CyclicBarrier waitForPrepareBarrier;
    private FinishNotifier finishNotifier;

    public Service(int carCount, FinishNotifier finishNotifier, Runnable afterStartAction) {
        this.waitForPrepareBarrier = new CyclicBarrier(carCount + 1, afterStartAction);
        this.finishNotifier = finishNotifier;
    }

    public Car createCar(Race race, int speed) {
        return new Car(race, speed, waitForPrepareBarrier, finishNotifier);
    }

    public void awaitingAllCarsStarted() {
        try {
            waitForPrepareBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }


}