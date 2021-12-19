package Homework1;

public class Wall implements Obstacle{
    private final String name = "wall";
    private int maxHeight;

    public Wall(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean compare(Member member) {
        if (member.getMaxJump() > this.maxHeight) {
            return true;
        } else {
            return false;
        }
    }

}
