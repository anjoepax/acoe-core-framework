package org.acoe.com.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class ExceptionPractice {

    public static void main(String[] args) {
        a();
    }

    private static void a() {
        b();
        c();
    }

    private static void b() {
        try {
            FileInputStream file = new FileInputStream("");
        }catch(FileNotFoundException e) {
            throw new RuntimeException("File is not found, terminating program");
        }
    }

    private static void c() {
        try {
            throw new SQLException();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

