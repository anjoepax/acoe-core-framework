package org.acoe.com.listener;

import org.testng.annotations.*;

public class Runner {

    @BeforeSuite
    public void setUpSuite() {
        System.out.println("Before suite in runner");
    }

    @AfterSuite
    public void tearDownSuite() {
        System.out.println("After suite in runner");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Before method in runner");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("After method in runner");
    }

    @Test
    public void test1() {
        System.out.println("Test 1");
    }

    @Test
    public void test2() {
        System.out.println("Test 2");
    }

    @Test
    public void test3() {
        System.out.println("Test 3");
    }
}
