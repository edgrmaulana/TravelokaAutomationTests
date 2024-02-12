package org.traveloka.tests.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.core.steps.UIInteractions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

@Component("org.traveloka.tests.utils.CommonUtility")
public class CommonUtility extends UIInteractions {

    public ChromeOptions initializeChrome(){
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("start-maximized");

        return chromeOptions;
    }
    public void openPage(String url){
        setDriver(new ChromeDriver(initializeChrome()));
        openUrl(url);
    }
}
