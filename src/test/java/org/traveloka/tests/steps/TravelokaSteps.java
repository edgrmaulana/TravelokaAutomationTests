package org.traveloka.tests.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.traveloka.tests.properties.TravelokaProperties;
import org.traveloka.tests.utils.CommonUtility;

import java.io.IOException;

public class TravelokaSteps {

//    @Autowired
//    CommonUtility commonUtility;

    CommonUtility commonUtility = new CommonUtility();

    TravelokaProperties travelokaProperties = new TravelokaProperties();
//    @Autowired
//    TravelokaProperties travelokaProperties;

    @Given("[travelokapage] User tried to open traveloka page")
    public void travelokapageUserTriedToOpenTravelokaPage() throws IOException {
        commonUtility.openPage(
                travelokaProperties.getProperties("defaultUrl"));
    }

    @When("[travelokapage] User click on Car Rental menu")
    public void travelokapageUserClickOnCarRentalMenu() {
        System.out.println("hello");
    }
}