package Homework_7_Java3;

import Homework_7_Java3.annotations.AfterSuite;
import Homework_7_Java3.annotations.BeforeSuite;
import Homework_7_Java3.annotations.Test;

public class Tests {

    @BeforeSuite
    public void initialize() {
        System.out.println("Method initialize has been started");
    }

    @Test(priority = 3)
    public void test1() {
        System.out.println("Test 1 has been started");
    }

    @Test(priority = 7)
    public void test2() {
        System.out.println("Test 2 has been started");
    }

    @Test(priority = 10)
    public void test3() {
        System.out.println("Test 3 has been started");
    }

    @Test(priority = 8)
    public void test4() {
        System.out.println("Test 4 has been started");
    }

    @Test
    public void test5() {
        System.out.println("Test 5 has been started");
    }

    @AfterSuite
    public void end() {
        System.out.println("Method end has been started");
    }

}
