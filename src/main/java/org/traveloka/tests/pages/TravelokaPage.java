package org.traveloka.tests.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.mockito.internal.matchers.Find;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.traveloka.tests.utils.UIUtility;

public class TravelokaPage extends UIUtility {

    @FindBy(xpath = "//div[@dir='auto' and contains(text(), 'Car Rental')]")
    WebElementFacade carRentalMenu;

    @FindBy(xpath = "//input[@data-testid='rental-search-form-date-input-start']")
    WebElementFacade startDate;

    @FindBy(xpath = "//input[@data-testid='rental-search-form-date-input-end']")
    WebElementFacade endDate;

    @FindBy(xpath = "//div[@data-testid='rental-search-form-cta']")
    WebElementFacade searchButton;

    @FindBy(xpath = "//input[@data-testid='rental-search-form-location-input']")
    WebElementFacade carRentalCity;

    @FindBy(xpath = "//div[@aria-label='Jakarta']//h3[@role='heading']")
    WebElementFacade chosenCity;
    // can format cities to fit inputted cities, but will not do that because of short time

    @FindBy(xpath = "//*[@id='__next']/div/div[5]/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[3]/div")
    WebElementFacade continueChooseCar;
    //choosing absolute xpath because seems like no unique identifier found

    @FindBy(xpath = "//*[@id='__next']/div/div[5]/div/div[4]/div/div[2]/div[2]/div[1]")
    WebElementFacade continueChosenCarProvider;
    //choosing absolute xpath because seems like no unique identifier found

    @FindBy(xpath = "//div[@role='radio']//div[@dir='auto' and contains(text(), 'Rental Office')]")
    WebElementFacade rentalOfficeButton;

    @FindBy(xpath = "//*[@id='RENTAL_DROPOFF_LOCATION']//div[@role='radio']//div[@dir='auto' and contains(text(), 'Other Locations')]")
    WebElementFacade rentalDropOffLocation;

    @FindBy(css = "//input[@placeholder='Search location or address' and @value='']")
    WebElementFacade inputLocationDropOff;


//    ----------------> Click Action

    public void clickCarRentalMenu(){
        clickByWebElementFacade(carRentalMenu);
    }

    public void chooseDate(String value) throws InterruptedException {
        if (value.equalsIgnoreCase("current+2")){
            clickByWebElementFacade(startDate);
        } else if (value.equalsIgnoreCase("current+5")){
            clickByWebElementFacade(endDate);
        }
        Thread.sleep(1000);
        clickDateByXPath("//div[@data-year='2024' and @data-month='1']//div[@dir='auto' and contains(text(), '%s')]", value);
    }

    public void clickSearchButton(){
        clickByWebElementFacade(searchButton);
    }

    public void chooseCarRentalCity(String value){
        clickByWebElementFacade(carRentalCity);
        inputText(value, carRentalCity);
        clickByWebElementFacade(chosenCity);
    }

    public void clickOnContinueChooseCar(){
        clickByWebElementFacade(continueChooseCar);
    }

    public void clickOnContinueChosenCarRental(){
        clickByWebElementFacade(continueChosenCarProvider);
    }

    public void clickOnRentalOfficeButton(String value){
        if (value.equalsIgnoreCase("office")){
            scrollPage("520");
            clickByWebElementFacade(rentalOfficeButton);
            clickByXPath("//*[@id='RENTAL_PICKUP_LOCATION']/div/div/div[3]/div[2]/div/div/div[1]/div[1]/div/div[2]");
            clickByXPath("//div[@dir='auto' and contains(text(), 'Jayamahe Jakarta Pool')]");
        }
    }

    public void clickOnRentalDropoffButton(String value){
        if (value.equalsIgnoreCase("otherlocation")){
            scrollPage("40");
            clickByWebElementFacade(rentalDropOffLocation);
            inputText("Jakarta", inputLocationDropOff);
            clickByXPath("//*[@id='RENTAL_DROPOFF_LOCATION']//div[@aria-label='Jakarta']");
        }
    }

}
