package org.traveloka.tests.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.traveloka.tests.pages.TravelokaPage;
import org.traveloka.tests.properties.TravelokaProperties;
import org.traveloka.tests.utils.CommonUtility;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

public class TravelokaSteps {

    CommonUtility commonUtility = new CommonUtility();

    TravelokaProperties travelokaProperties = new TravelokaProperties();

    TravelokaPage travelokaPage = new TravelokaPage();

    @Given("[travelokapage] User tried to open traveloka page")
    public void travelokapageUserTriedToOpenTravelokaPage() throws IOException{
        commonUtility.openPage(
                travelokaProperties.getProperties("defaultUrl"));
    }

    @When("[travelokapage] User click on Car Rental menu")
    public void travelokapageUserClickOnCarRentalMenu() {
        travelokaPage.clickCarRentalMenu();
    }

    @Then("[travelokapage] User choose city to {string}")
    public void travelokapageUserChooseCityToCity(String value) {
        travelokaPage.chooseCarRentalCity(value);
    }

    @Then("[travelokapage] User choose start date to {string}")
    public void travelokapageUserChooseStartDateToDate(String value) throws InterruptedException {
        travelokaPage.chooseDate(value);
        Thread.sleep(2000L);
    }

    @Then("[travelokapage] User choose end date to {string}")
    public void travelokapageUserChooseEndDateToEndDate(String value) throws InterruptedException {
        travelokaPage.chooseDate(value);
        Thread.sleep(2000L);
    }

    @Then("[travelokapage] User click on search button")
    public void travelokapageUserClickOnSearchButton(){
        travelokaPage.clickSearchButton();
    }

    @Then("[travelokapage] User click continue on chosen car")
    public void travelokapageUserClickContinueOnChosenCar() {
        travelokaPage.clickOnContinueChooseCar();
    }

    @And("[travelokapage] User wait for {int} seconds")
    public void travelokapageUserWaitForSeconds(int value) throws InterruptedException {
        Thread.sleep(value * 1000L);
    }

    @Then("[travelokapage] User click continue on chosen car rental")
    public void travelokapageUserClickContinueOnChosenCarRental() {
        travelokaPage.clickOnContinueChosenCarRental();
    }

    @Then("[travelokapage] User click on rental pickup location on {string}")
    public void travelokapageUserClickOnRentalPickupLocationOnRentalPickup(String value) throws InterruptedException {
        travelokaPage.clickOnRentalOfficeButton(value);
        Thread.sleep(2000);
    }

    @And("[travelokapage] User click on dropoff pickup location on {string}")
    public void travelokapageUserClickOnDropoffPickupLocationOnDropOffLocation(String value) throws InterruptedException {
        travelokaPage.clickOnRentalDropoffButton(value);
        Thread.sleep(2000);
    }

    @And("[travelokapage] User input additional request for dropoff Location with request {string}")
    public void travelokapageUserInputAdditionalRequestForDropoffLocationWithRequestRequests(String value) {
        travelokaPage.inputTextAdditionalRequestDropoff(value);
    }

    @And("[travelokapage] User click continue on product detail page")
    public void travelokapageUserClickContinueOnProductDetailPage() {
        travelokaPage.clickContinuePdp();
    }

    @Then("[travelokapage] User input contact name as {string}")
    public void travelokapageUserInputContactNameAsName(String value) throws IOException {
        value = value.equalsIgnoreCase("default") ? travelokaProperties.getProperties("defaultName") : value;
        travelokaPage.inputTextContactName(value);
    }

    @Then("[travelokapage] User input contact phone number as {string}")
    public void travelokapageUserInputContactPhoneNumberAsPhoneNumber(String value) throws IOException {
        value = value.equalsIgnoreCase("default") ? travelokaProperties.getProperties("defaultPhoneNumber") : value;
        travelokaPage.inputTextContactPhoneNumber(value);
    }

    @Then("[travelokapage] User input contact email as {string}")
    public void travelokapageUserInputContactEmailAsEmail(String value) throws IOException {
        value = value.equalsIgnoreCase("default") ? travelokaProperties.getProperties("defaultEmail") : value;
        travelokaPage.inputTextContactEmail(value);
    }

    @Then("[travelokapage] User choose driver punctuation as {string}")
    public void travelokapageUserChooseDriverPunctuationAs(String value) {
        travelokaPage.clickPunctuationDropdown(value);
    }

    @And("[travelokapage] User input driver full name as {string}")
    public void travelokapageUserInputDriverFullNameAsName(String value) throws IOException {
        value = value.equalsIgnoreCase("default") ? travelokaProperties.getProperties("defaultName") : value;
        travelokaPage.inputTextDriverName(value);
    }

    @And("[travelokapage] User input driver phone number as {string}")
    public void travelokapageUserInputDriverPhoneNumberAsPhoneNumber(String value) throws IOException {
        value = value.equalsIgnoreCase("default") ? travelokaProperties.getProperties("defaultPhoneNumber") : value;
        travelokaPage.inputTextDriverPhoneNumber(value);
    }

    @Then("[travelokapage] User click continue on contact page")
    public void travelokapageUserClickContinueOnContactPage() throws InterruptedException {
        travelokaPage.clickContinueButtonContactDetailsPage();
        Thread.sleep(2000);
    }

    @Then("[travelokapage] User input additional request for car as {string}")
    public void travelokapageUserInputAdditionalRequestForCarAsRequests(String value) {
        travelokaPage.inputTextSpecialRequestCar(value);
    }

    @And("[travelokapage] User click on check requirements for rental")
    public void travelokapageUserClickOnCheckRequirementsForRental() {
        travelokaPage.clickOnCheckRequirementsForRental();
    }

    @Then("[travelokapage] User click continue to payment")
    public void travelokapageUserClickContinueToPayment() {
        travelokaPage.clickContinueToPayment();
        travelokaPage.clickContinueBookingDetailsCorrect();
    }

    @Then("[travelokapage] User choose bank transfer as payment method")
    public void travelokapageUserChooseBankTransferAsPaymentMethod() {
        travelokaPage.clickOnBankTransferPaymentMethod();
    }

    @Then("[travelokapage] User click Pay with bank transfer")
    public void travelokapageUserClickPayWithBankTransfer() {
        travelokaPage.clickOnPayWithTransferButton();
    }

    @Then("[travelokapage] User should be redirected to payment confirmation page")
    public void travelokapageUserShouldBeRedirectedToPaymentConfirmationPage() {
        assertThat("URL is incorrect", commonUtility.getCurrentPageUrl(),
                containsString("payment/confirmation"));
    }
}
