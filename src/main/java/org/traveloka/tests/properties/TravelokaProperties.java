package org.traveloka.tests.properties;

import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@Component("org.traveloka.tests.properties.TravelokaProperties")
public class TravelokaProperties {

    public String getProperties(String value) throws IOException {
        FileReader pathprop = new FileReader("src/test/resources/application.properties");
        Properties prop = new Properties();
        prop.load(pathprop);
        String properties = String.format("traveloka.%s", value);
        return prop.getProperty(properties);
    }
}
