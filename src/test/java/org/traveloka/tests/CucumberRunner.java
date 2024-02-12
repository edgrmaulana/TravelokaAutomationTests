package org.traveloka.tests;

import cucumber.runtime.SerenityObjectFactory;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = {"org.traveloka.tests.steps",
                "org.traveloka.tests.hooks"},
        objectFactory = SerenityObjectFactory.class,
        stepNotifications = true,
        tags = "@TravelokaTestsFeature")
public class CucumberRunner {

}
