package org.acoe.com.dataprovider;

import org.testng.annotations.DataProvider;

public final class Employee {

    private final String employeeName;
    private final String employeeIdNo;

    protected Employee(final String employeeName, final String employeeIdNo) {
        this.employeeName = employeeName;
        this.employeeIdNo = employeeIdNo;
    }

    public String getEmployeeName() {
        return this.employeeName;
    }

    public String getEmployeeIdNo() {
        return this.employeeIdNo;
    }

    @DataProvider(name = "dummy3")
    public static Object[] getData3() {
        return new Employee[] {
                new Employee("Anthony Joseph", "1131017"),
                new Employee("John Nicko", "224647")
        };
    }
}
