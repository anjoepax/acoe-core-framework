package org.acoe.com.listener;

import org.acoe.com.constants.FrameworkConstants;
import org.acoe.com.utils.ExcelUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Method interceptor listener that modifies the test annotations at the runtime, for displaying data in the extent report
 * @date September 23, 2021
 * @author Anthony Joseph Manigos
 */
public final class MethodInterceptor implements IMethodInterceptor {

    /**
     * The intercept method that intercepts the test method attributes in the runtime
     * @param methods - test methods
     * @param context - test context
     * @return - returns the list of results
     */
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        List<Map<String, String>> list = ExcelUtils.getTestDetails(FrameworkConstants.getRunManagerDataSheet());
        List<IMethodInstance> result = new ArrayList<>();

        for (IMethodInstance method : methods) {
            for (Map<String, String> stringStringMap : list) {
                if ((method.getMethod().getMethodName().equalsIgnoreCase(stringStringMap.get("testname"))) &&
                (stringStringMap.get("execute").equalsIgnoreCase("yes"))) {
                        method.getMethod().setDescription(stringStringMap.get("testdescription"));
                        method.getMethod().setInvocationCount(Integer.parseInt(stringStringMap.get("count")));
                        method.getMethod().setPriority(Integer.parseInt(stringStringMap.get("priority")));
                        result.add(method);
                }
            }
        }
        return result;
    }
}
