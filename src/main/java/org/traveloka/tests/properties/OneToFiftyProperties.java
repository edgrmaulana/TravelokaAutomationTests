package org.traveloka.tests.properties;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class OneToFiftyProperties {

    public String getProperties(String value) throws IOException {
        FileReader pathprop = new FileReader("src/test/resources/application.properties");
        Properties prop = new Properties();
        prop.load(pathprop);
        String properties = String.format("onetofifty.%s", value);
        return prop.getProperty(properties);
    }
}
