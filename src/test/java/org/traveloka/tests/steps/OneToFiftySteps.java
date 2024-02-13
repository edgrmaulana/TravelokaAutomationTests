package org.traveloka.tests.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.traveloka.tests.pages.OneToFiftyPage;
import org.traveloka.tests.properties.OneToFiftyProperties;
import org.traveloka.tests.utils.CommonUtility;

import java.io.IOException;

public class OneToFiftySteps {

    CommonUtility commonUtility = new CommonUtility();

    OneToFiftyProperties oneToFiftyProperties = new OneToFiftyProperties();

    OneToFiftyPage oneToFiftyPage = new OneToFiftyPage();

    @Given("[onetofifty] User tried to open onetofifty page")
    public void UserTriedToOpenOneToFiftyPage() throws IOException {
        commonUtility.openPage(
                oneToFiftyProperties.getProperties("defaultUrl"));
    }


    @Then("[onetofifty] user start to click on the number one to fifty as much as {int}")
    public void onetofiftyUserStartToClickOnTheNumberOneToFiftyAsMuchAs(int value) {
        oneToFiftyPage.clickOnGrid(value);
    }
}
