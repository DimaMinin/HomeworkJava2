package Homework1;
import java.util.Random;

public class TestRoad {

    private static Random rand;
    private static Member[] member;
    private static Obstacle[] obstacles;

    public static void main(String[] args) {
        rand = new Random();
        member = new Member[3];
        obstacles = new Obstacle[5];

        createMembers(rand, member);
        createObstacles(rand, obstacles);

        game(member, obstacles);
    }

    private static void game(Member[] member, Obstacle[] obstacles) {
        for (int i = 0; i < member.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                if (obstacles[j].compare(member[i])) {
                    System.out.println(member[i].getName() + " Success");
                } else {
                    System.out.println(member[i].getName() + " Fail");
                    break;
                }
            }
        }
    }

    private static void createObstacles(Random rand, Obstacle[] obstacles) {
        boolean isWall;
        int maxHeight;
        int distance;
        for (int i = 0; i < obstacles.length; i++) {
            distance = rand.nextInt(50);
            maxHeight = rand.nextInt(50);
            isWall = rand.nextBoolean();
            if (isWall) {
                obstacles[i] = new Wall(maxHeight);
            } else {
                obstacles[i] = new Treadmill(distance);
            }
        }
    }

    private static void createMembers(Random rand, Member[] member) {
        int maxRun = rand.nextInt(50);
        int maxJump = rand.nextInt(50);
        member[0] = new Human("Misha", maxJump, maxRun);

        maxRun = rand.nextInt(50);
        maxJump = rand.nextInt(50);
        member[1] = new Cat("Barsik", maxJump, maxRun);

        maxRun = rand.nextInt(50);
        maxJump = rand.nextInt(50);
        member[2] = new Robot("New0264", maxJump, maxRun);
    }
}
