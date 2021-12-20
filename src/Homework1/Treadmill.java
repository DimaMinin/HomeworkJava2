package Homework1;

public class Treadmill implements Obstacle{

    private final String name = "road";
    private int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean compare(Member member) {
        if (member.getMaxRun() > this.distance) {
            return true;
        } else {
            return false;
        }
    }
}
