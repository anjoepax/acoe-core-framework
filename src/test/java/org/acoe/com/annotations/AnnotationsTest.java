package org.acoe.com.annotations;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class AnnotationsTest {

    @Test(description = "Testing is cool")
    public void testingTestMethod(Method method) {
        System.out.println(method.getAnnotation(Test.class).description());
    }
}
