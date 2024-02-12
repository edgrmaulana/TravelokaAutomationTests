package org.traveloka.tests.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.traveloka.tests.pages.TravelokaPage;
import org.traveloka.tests.properties.TravelokaProperties;
import org.traveloka.tests.utils.CommonUtility;

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
    public void travelokapageUserClickOnRentalPickupLocationOnRentalPickup(String value){
        travelokaPage.clickOnRentalOfficeButton(value);
    }

    @Then("[travelokapage] User click on dropoff pickup location on {string}")
    public void travelokapageUserClickOnDropoffPickupLocationOnDropOffLocation(String value) throws InterruptedException {
        travelokaPage.clickOnRentalDropoffButton(value);
        Thread.sleep(100000);
    }
}
