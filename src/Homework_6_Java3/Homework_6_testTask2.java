package Homework_6_Java3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Homework_6_testTask2 {

    private Homework_6 homework6;

    @Before
    public void prepare() {
        homework6 = new Homework_6();
    }

    @Test
    public void test1() {
        Assert.assertTrue(homework6.task2(new int[] {1, 2, 3, 4}));
    }

    @Test
    public void test2() {
        Assert.assertFalse(homework6.task2(new int[] {1, 2, 3}));
    }

    @Test
    public void test3() {
        Assert.assertTrue(homework6.task2(new int[] {1, 4, 1}));
    }

}
