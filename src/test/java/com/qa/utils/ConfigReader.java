package com.qa.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Logger log= LoggerFactory.getLogger(ConfigReader.class);

    private static Properties properties=new Properties();


    public static void initialize()
    {
        String configPath="configurations/config.properties";
        try (InputStream resource = TestResourceLoader.getResource(configPath);)
        {
            properties.load(resource);
            log.info("All Default Properties in Property Files are");
            for (String key:properties.stringPropertyNames()) {
                if(System.getProperties().containsKey(key))
                {
                    properties.setProperty(key,System.getProperty(key));
                }
                log.info("{} = {}",key,properties.getProperty(key).toString());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String getValueFromKey(String key)
    {
        log.info("Value for Key - {} is {}",key,properties.get(key).toString());
        return properties.get(key).toString();
    }




}
