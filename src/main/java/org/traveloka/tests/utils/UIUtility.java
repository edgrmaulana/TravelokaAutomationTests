package org.traveloka.tests.utils;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
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

    protected Boolean isElementDisabledByWebElementFacade(WebElementFacade webElementFacade){
        return webElementFacade.getAttribute("class").contains("disabled");
    }

    protected void switchToIFrame(){
        getDriver().switchTo().frame(
                getDriver().findElement(By.xpath("//iframe[contains(@src, 'sandbox.midtrans')]")));
    }

    protected void inputText(String text, WebElementFacade webElementFacade){
        webElementFacade.clear();
        webElementFacade.sendKeys(text);
    }

    protected void scrollPage(String value){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript(String.format("window.scrollBy(0,%s)", value), "");
    }

    protected void switchTo3DSIFrame(){
        getDriver().switchTo().frame(
                getDriver().findElement(By.xpath("//iframe[contains(@src, '3ds')]")));
    }

    protected String getTextByWebElementFacade(WebElementFacade webElementFacade){
        return webElementFacade.getText();
    }

    protected void deleteText(WebElementFacade webElementFacade){
        webElementFacade.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
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

    public static void main(String[] args) {
        Calendar date = Calendar.getInstance();
        TimeZone timeZone = TimeZone.getTimeZone("GMT+7");
        date.setTimeZone(timeZone);

        String script = "//div[@dir='auto' and contains(text(), '%s')]";
        script = String.format(script, date.get(Calendar.DAY_OF_MONTH) + 5);

        System.out.println(script);
    }
}
