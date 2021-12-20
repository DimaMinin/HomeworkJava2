package Homework1;

public class Cat implements Member{

    private  String name;
    private int maxRun;
    private int maxJump;

    public Cat(String name, int maxJump, int maxRun) {
        this.maxJump = maxJump;
        this.maxRun = maxRun;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMaxJump() {
        return maxJump;
    }

    @Override
    public int getMaxRun() {
        return maxRun;
    }

    @Override
    public void run() {
        System.out.println(this.name + " пробежал");
    }
    @Override
    public void jump() {
        System.out.println(this.name + " перепрыгнул");
    }
}
