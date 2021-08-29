package org.acoe.com.practice;

public class EnumRunner {

    public static void main(String[] args) {
        System.out.println(Severity.CRITICAL);

        Severity severity = Severity.CRITICAL;

        if(Severity.valueOf("CRITICAL") == Severity.CRITICAL) {
            System.out.println("Critical");
        }else if(Severity.valueOf("LOW") == Severity.LOW) {
            System.out.println("Low");
        }
    }
}
