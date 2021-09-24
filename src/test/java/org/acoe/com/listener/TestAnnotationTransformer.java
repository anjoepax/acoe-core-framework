package org.acoe.com.listener;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestAnnotationTransformer implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        Map<String, Object> test1 = new HashMap<>();
        test1.put("name", "test1");
        test1.put("count", "5");
        test1.put("enabled", false);

        Map<String, Object> test2 = new HashMap<>();
        test2.put("name", "test2");
        test2.put("count", "2");
        test1.put("enabled", true);

        List<Map<String, Object>> list = new ArrayList<>();
        list.add(test1);
        list.add(test2);

        for (Map<String, Object> stringObjectMap : list) {
            if (testMethod.getName().equalsIgnoreCase(String.valueOf(stringObjectMap.get("name")))) {
                if (stringObjectMap.get("enabled").equals(false)) {
                    annotation.setEnabled(false);
                } else {
                    annotation.setInvocationCount(
                            Integer.parseInt((String) stringObjectMap.get("count"))
                    );
                }
            }
        }
    }
}
