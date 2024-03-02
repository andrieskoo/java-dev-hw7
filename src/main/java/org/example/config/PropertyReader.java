package org.example.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class PropertyReader {
    private static final Logger loger = LogManager.getLogger();
    public static String getH2ConnectionFromProperties() {
        try (InputStream inputStream = PropertyReader.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            Objects.requireNonNull(inputStream, "Unable to find application properties");
            Properties properties = new Properties();

            properties.load(inputStream);
            return  new StringBuilder(properties.getProperty("h2.db.driver"))
                    .append(":")
                    .append(properties.getProperty("h2.db.host"))
                    .append(properties.getProperty("h2.db.database"))
//                    .append(properties.getProperty("h2.db.username"))
//                    .append(properties.getProperty("h2.db.password"))
                    .toString();
        }
        catch (Exception e){
            loger.error("Cannot read properties " + e.getMessage());
            return null;
        }
    }
}
