package org.acoe.com.constants;

import org.acoe.com.enums.ConfigProperties;
import org.acoe.com.utils.PropertyUtils;

/**
 * Constants value used in the framework (e.g. excel file path, explicit wait timeout, properties file path)
 * @date September 23, 2021
 * @author Anthony Joseph Manigos
 */
public final class FrameworkConstants {

    private FrameworkConstants(){ }

    private static final String CONFIG_FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/config/config.properties";
    private static final String QA_CONFIG_FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/config/qa-env.properties";
    private static final String DEV_CONFIG_FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/config/dev-env.properties";
    private static final String UAT_CONFIG_FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/config/uat-env.properties";
    private static final String STG_CONFIG_FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/config/stg-env.properties";
    private static final String DEMO_CONFIG_FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/config/demo-env.properties";
    private static final String INT_CONFIG_FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/config/int-env.properties";
    private static final String PRE_PROD_CONFIG_FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/config/pre-prod-env.properties";
    private static final String PROD_CONFIG_FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/config/prod-env.properties";
    private static final String EXCEL_DATA_PATH = System.getProperty("user.dir") + "/src/test/resources/data/TestDataExcel.xlsx";
    private static final int EXPLICIT_WAIT = 30;
    private static final String EXTENT_REPORT_FOLDER_PATH = System.getProperty("user.dir") + "/extent-report-output/";
    private static String extentReportFilePath = "";
    private static final String RUN_MANAGER_DATA_SHEET = "RUNMANAGER";
    private static final String DATA_PROVIDER_SHEET = "DATA";

    public static String getExtentReportFilePath() {
        if(extentReportFilePath.isEmpty()) {
            extentReportFilePath = createReportPath();
        }
        return extentReportFilePath;
    }

    private static String createReportPath() {
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

    public static String getQaConfigFilePath() {
        return QA_CONFIG_FILE_PATH;
    }

    public static String getDevConfigFilePath() {
        return DEV_CONFIG_FILE_PATH;
    }

    public static String getUatConfigFilePath() {
        return UAT_CONFIG_FILE_PATH;
    }

    public static String getStgConfigFilePath() {
        return STG_CONFIG_FILE_PATH;
    }

    public static String getDemoConfigFilePath() {
        return DEMO_CONFIG_FILE_PATH;
    }

    public static String getIntConfigFilePath() {
        return INT_CONFIG_FILE_PATH;
    }

    public static String getProdConfigFilePath() {
        return PROD_CONFIG_FILE_PATH;
    }

    public static String getPreProdConfigFilePath() {return PRE_PROD_CONFIG_FILE_PATH;}

    public static String getExcelDataPath() {return EXCEL_DATA_PATH;}

    public static String getRunManagerDataSheet() {return RUN_MANAGER_DATA_SHEET;}

    public static String getDataProviderSheet() {return DATA_PROVIDER_SHEET;}

}
