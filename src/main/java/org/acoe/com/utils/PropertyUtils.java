package org.acoe.com.utils;

import org.acoe.com.constants.FrameworkConstants;
import org.acoe.com.enums.ConfigProperties;
import org.acoe.com.enums.EnvironmentType;
import org.acoe.com.exceptions.FrameworkExceptions;
import org.acoe.com.exceptions.PropertyKeyNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {

    private PropertyUtils() {}

    private static final Properties property = new Properties();
    private static final Map<String, String> CONFIGMAP = new HashMap<>();

    static {
        FileInputStream file;
            try {
                String env = System.getProperty("env", "QA");
                switch(EnvironmentType.valueOf(env.toUpperCase().trim())) {
                    case QA:
                        file = new FileInputStream(FrameworkConstants.getQaConfigFilePath());
                        break;
                    case DEV:
                        file = new FileInputStream(FrameworkConstants.getDevConfigFilePath());
                        break;
                    case UAT:
                        file = new FileInputStream(FrameworkConstants.getUatConfigFilePath());
                        break;
                    case STG:
                        file = new FileInputStream(FrameworkConstants.getStgConfigFilePath());
                        break;
                    case INT:
                        file = new FileInputStream(FrameworkConstants.getIntConfigFilePath());
                        break;
                    case PRE_PROD:
                        file = new FileInputStream(FrameworkConstants.getPreProdConfigFilePath());
                        break;
                    case DEMO:
                        file = new FileInputStream(FrameworkConstants.getDemoConfigFilePath());
                        break;
                    case PROD:
                        file = new FileInputStream(FrameworkConstants.getProdConfigFilePath());
                        break;
                    case PRACTICE:
                        file = new FileInputStream(FrameworkConstants.getConfigFilepath());
                        break;
                    default:
                        throw new FrameworkExceptions("Unknown environment type: " + env.toUpperCase().trim());
                }
                property.load(file);
                for(Map.Entry<Object, Object> entry : property.entrySet()) {
                    CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
            }
        }
        catch(IOException e) {
           e.printStackTrace();
           System.exit(0);
        }
    }


    public static String get(ConfigProperties key) {
        if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
             throw new PropertyKeyNotFoundException("Property name: " + key + " is not found. Please check config.properties");
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }
}
