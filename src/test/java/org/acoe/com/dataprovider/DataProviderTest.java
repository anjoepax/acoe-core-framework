package org.acoe.com.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {

    @Test(dataProvider = "getData3")
    public void test1(Employee employee) {
       System.out.println("Entering username: " + employee.getEmployeeName());
       System.out.println("Entering password: " + employee.getEmployeeIdNo());
       System.out.println("Clicking login");
    }

    @Test(dataProvider = "getData3")
    public void test2(String username, String password) {
        System.out.println("Testing username: " + username);
        System.out.println("Testing password: " + password);
    }

    @DataProvider
    public Object[] getData3(Method method) {
        if(method.getName().equalsIgnoreCase("test1")) {
            return new Employee[] {
                    new Employee("Amuthan", "1131017"),
                    new Employee("Anthony", "236378")
            };
        }else if(method.getName().equalsIgnoreCase("test2")) {
            return new Object[][] {
                    {"Amuthan", "AmuthanPassword"},
                    {"Sakthivel", "Sakthivel Password"},
                    {"Testing mini bytes", "TMB Password"}
            };
        }

        return null;
    }
}
