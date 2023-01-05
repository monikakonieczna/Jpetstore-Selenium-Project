package com.jpetstore.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Util PropertyReader class which helps in getting property values from 'config.property' file.
 */
public class PropertyReader {

    private static volatile PropertyReader propInstance;

    private PropertyReader(){

    }

    /**
     * Method to return PropertyReader Instance
     * @return PropertyReader Instance
     */
    public static synchronized PropertyReader getInstance(){

        if(propInstance == null){

            propInstance = new PropertyReader();
        }
        return propInstance;
    }


    /**
     * Method to return property value
     * @param propertyName
     * @return property value or null
     */
    public String getPropertyValueByKey(String propertyName){

        Properties prop = new Properties();


        try {
            InputStream inputStream = getClass()
                    .getClassLoader().getResourceAsStream("config.properties");
            prop.load(inputStream);

            if(prop.getProperty(propertyName) !=null){
                return prop.getProperty(propertyName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
