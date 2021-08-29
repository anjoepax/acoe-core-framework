package org.acoe.com.constants;

import org.acoe.com.enums.ConfigProperties;
import org.acoe.com.utils.PropertyUtils;

public final class FrameworkConstants {

    private FrameworkConstants(){ }

    private static final String CONFIG_FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/config/config.properties";
    private static final int EXPLICIT_WAIT = 30;
    private static final String EXTENT_REPORT_FOLDER_PATH = System.getProperty("user.dir") + "/extent-report-output/";
    private static String extentReportFilePath = "";

    public static String getExtentReportFilePath() throws Exception {
        if(extentReportFilePath.isEmpty()) {
            extentReportFilePath = createReportPath();
        }
        return extentReportFilePath;
    }

    private static String createReportPath() throws Exception {
        if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
            return EXTENT_REPORT_FOLDER_PATH + System.currentTimeMillis() + "/index.html";
        }else {
            return EXTENT_REPORT_FOLDER_PATH + "/index.html";
        }
    }

    public static int getExplicitWait() {
        return EXPLICIT_WAIT;
    }

    public static String getConfigFilepath() {
        return CONFIG_FILE_PATH;
    }

}
