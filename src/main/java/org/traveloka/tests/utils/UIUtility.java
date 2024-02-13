package org.traveloka.tests.utils;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class UIUtility extends PageObject {

    protected void clickByWebElementFacade(WebElementFacade webElementFacade){
        webElementFacade.click();
    }

    protected void clickByXPath(String xpath){
        List<WebElementFacade> listElement = findAll(By.xpath(xpath));

        for (int i = 0; i < listElement.size();i++){
            if (listElement.get(i).isClickable()){
                listElement.get(i).click();
                break;
            }
        }
    }

    protected void inputText(String text, WebElementFacade webElementFacade){
        webElementFacade.clear();
        webElementFacade.sendKeys(text);
    }

    protected void scrollPage(String value){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript(String.format("window.scrollBy(0,%s)", value), "");
    }

    protected void clickDateByXPath(String xpath, String value) {
        Calendar date = Calendar.getInstance();
        TimeZone timeZone = TimeZone.getTimeZone("GMT+7");
        date.setTimeZone(timeZone);

        if (value.equalsIgnoreCase("current+2")){
            xpath = String.format(xpath, date.get(Calendar.DAY_OF_MONTH) + 2);
        } else if (value.equalsIgnoreCase("current+5")){
            xpath = String.format(xpath, date.get(Calendar.DAY_OF_MONTH) + 5);
        }
        System.out.println(xpath);
        List<WebElementFacade> webElementFacade = findAll(By.xpath(xpath));

        for (int i = 0; i < webElementFacade.size(); i++){
            if (webElementFacade.get(i).isClickable()){
                webElementFacade.get(i).click();
                break;
            }
        }
    }

    protected void clickWithSequenceByXPath(int value){
        for (int i = 1; i <= value; i++){
            String xpath = "//div[@id='grid']//div[(text()='" + i + "')]";
            WebElementFacade webElementFacade = findBy(xpath);
            webElementFacade.click();
        }
    }
}
