package org.acoe.com.utils;

import org.acoe.com.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataProviderUtils {

    private static List<Map<String, String>> list = new ArrayList<>();

    @DataProvider(parallel = true)
    public static Object[] getData(Method m) {
        String testName = m.getName();

        if(list.isEmpty()) {
            list = ExcelUtils.getTestDetails(FrameworkConstants.getDataProviderSheet());
        }

        List<Map<String, String>> smallList = new ArrayList<>();

        for (Map<String, String> stringStringMap : list) {
            if ((stringStringMap.get("testname").equalsIgnoreCase(testName)) &&
                    (stringStringMap.get("execute").equalsIgnoreCase("yes"))) {
                    smallList.add(stringStringMap);
            }
        }
        return smallList.toArray();
    }
}
