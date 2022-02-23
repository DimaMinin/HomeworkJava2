package Homework_6_Java3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Homework_6_testTask1 {

    private Homework_6 homework6;

    @Before
    public void prepare() {
        homework6 = new Homework_6();
    }

    @Test(expected = RuntimeException.class)
    public void test1() {
        homework6.task1(new int[] {});
    }

    @Test(expected = RuntimeException.class)
    public void test2() {
        homework6.task1(new int[] {1, 2, 3, 5, 6});
    }

    @Test
    public void test3() {
        Assert.assertArrayEquals(new int[] {1, 2, 3}, homework6.task1(new int[] {5, 5, 5, 4, 1, 2, 3}));
    }

}
