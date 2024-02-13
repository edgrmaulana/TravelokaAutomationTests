package org.traveloka.tests.pages;

import net.serenitybdd.core.pages.WebElementFacade;
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

    @FindBy(xpath = "//*[@id='__next']/div/div[5]/div/div[4]/div/div[2]/div[2]/div[1]")
    WebElementFacade continueChosenCarProvider;


    @FindBy(xpath = "//div[@role='radio']//div[@dir='auto' and contains(text(), 'Rental Office')]")
    WebElementFacade rentalOfficeButton;

    @FindBy(xpath = "//*[@id='RENTAL_DROPOFF_LOCATION']/div/div/div[5]/div[1]/div[2]/div")
    WebElementFacade rentalDropOffLocation;

    @FindBy(xpath = "//textarea[@placeholder='Additional notes (optional)']")
    WebElementFacade inputAdditionalRequestDropOff;

    @FindBy(xpath = "//*[@id='__next']/div/div[5]/div/div[1]/div/div[5]/div[3]/div")
    WebElementFacade continueButtonPdp;

    @FindBy(xpath = "//*[@id='__next']/div[2]/div[2]/div[1]/div[2]/div/div/div/div[2]/div[1]/div/div[1]/input")
    WebElementFacade inputContactName;

    @FindBy(xpath = "//*[@id='__next']/div[2]/div[2]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[1]/div[1]/input")
    WebElementFacade inputContactPhoneNumber;

    @FindBy(xpath = "//*[@id='__next']/div[2]/div[2]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[2]/div/div[1]/input")
    WebElementFacade inputContactEmail;

    @FindBy(xpath = "//*[@id='adultForm0']/div/div/div[2]/div[2]/div/div[1]/input")
    WebElementFacade driverName;

    @FindBy(xpath = "//*[@id='adultForm0']/div/div/div[2]/div[3]/div[1]/input")
    WebElementFacade driverPhoneNumber;

    @FindBy(xpath = "//*[@id='__next']/div[2]/div[2]/div[1]/div[4]/div/div/div/div[2]")
    WebElementFacade continueButtonContactDetails;

    @FindBy(xpath = "//*[@id='__next']/div[2]/div[2]/div[1]/div[9]/div/div/div[3]/div[1]/textarea")
    WebElementFacade specialRequestCar;

    @FindBy(xpath = "//*[@id='__next']/div[2]/div[2]/div[1]/div[14]/div/div/div")
    WebElementFacade continueToPaymentButton;

    @FindBy(xpath = "//*[@id='__next']/div/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/div[7]/div[2]")
    WebElementFacade buttonPayWithTransfer;

//  choosing absolute xpath because seems like no unique identifier found

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
            scrollPage("200");
            clickByWebElementFacade(rentalDropOffLocation);
            clickByXPath("//*[@id='RENTAL_DROPOFF_LOCATION']/div/div/div[5]/div[2]/div/div/div[1]/div/div[1]/input");
            clickByXPath("//*[@id='RENTAL_DROPOFF_LOCATION']/div/div/div[5]/div[2]/div/div/div[1]/div/div[2]/div/div/div/div[3]/div[1]/h3");
        }
    }

    public void inputTextAdditionalRequestDropoff(String value){
        if (!value.isBlank()){
            inputText(value, inputAdditionalRequestDropOff);
        }
    }

    public void clickContinuePdp(){
        scrollPage("200");
        clickByWebElementFacade(continueButtonPdp);
    }

    public void inputTextContactName(String value){
        clickByWebElementFacade(inputContactName);
        inputText(value, inputContactName);
    }

    public void inputTextContactPhoneNumber(String value){
        clickByWebElementFacade(inputContactPhoneNumber);
        inputText(value, inputContactPhoneNumber);
    }

    public void inputTextContactEmail(String value){
        clickByWebElementFacade(inputContactEmail);
        inputText(value, inputContactEmail);
    }

    public void clickPunctuationDropdown(String value){
        scrollPage("500");
        clickByXPath("//*[@id='adultForm0']/div/div/div[2]/div[1]/div/div/select");
        if (value.equalsIgnoreCase("mr")){
            clickByXPath("//*[@id='adultForm0']/div/div/div[2]/div[1]/div/div/select//option[1]");
        }
    }

    public void inputTextDriverName(String value){
        clickByWebElementFacade(driverName);
        inputText(value, driverName);
    }

    public void inputTextDriverPhoneNumber(String value){
        clickByWebElementFacade(driverPhoneNumber);
        inputText(value, driverPhoneNumber);
    }

    public void clickContinueButtonContactDetailsPage(){
        clickByWebElementFacade(continueButtonContactDetails);
    }

    public void inputTextSpecialRequestCar(String value){
        scrollPage("500");
        clickByWebElementFacade(specialRequestCar);
        inputText(value, specialRequestCar);
    }

    public void clickOnCheckRequirementsForRental(){
        scrollPage("100");
        clickByXPath("//*[@id='__next']/div[2]/div[2]/div[1]/div[11]/div/div/div/div[2]");
        clickByXPath("/html/body/div[2]/div/div[2]/div/div[2]/div/div[1]/div[2]");
        clickByXPath("/html/body/div[2]/div/div[2]/div/div[2]/div/div[3]/div[2]");
    }

    public void clickContinueToPayment(){
        scrollPage("500");
        clickByWebElementFacade(continueToPaymentButton);
    }

    public void clickContinueBookingDetailsCorrect(){
        clickByXPath("/html/body/div[2]/div/div[2]/div/div[2]/div/div[3]/div[2]");
    }

    public void clickOnBankTransferPaymentMethod(){
        clickByXPath("//*[@id='__next']/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/div/div/div[3]/div/div");
    }

    public void clickOnPayWithTransferButton(){
        clickByWebElementFacade(buttonPayWithTransfer);
    }
}
