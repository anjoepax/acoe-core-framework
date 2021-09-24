package org.acoe.com.listener;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMethodInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        //List of all the test that testng going to execute test1, test2, test3
        List<IMethodInstance> result = new ArrayList<>();

        Map<String, String> test1 = new HashMap<>();
        test1.put("name", "test1");
        test1.put("count", "5");

        Map<String, String> test2 = new HashMap<>();
        test2.put("name", "test2");
        test2.put("count", "2");

        List<Map<String, String>> list = new ArrayList<>();
        list.add(test1);
        list.add(test2);

        for (IMethodInstance method : methods) {
            for (Map<String, String> stringMap : list) {
                if (method.getMethod().getMethodName()
                        .equalsIgnoreCase(stringMap.get("name"))) {
                    method.getMethod().setInvocationCount(Integer.parseInt(stringMap.get("count")));
                    result.add(method);
                }
            }
        }

        return result;
    }
}
