package org.automation;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by shantonu on 5/9/16.
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/Reports/calculator","json:target/Reports/calculator.json" }
        , features = {"src/test/resources/org/automation/calculator.feature"}
        , glue = {""})
public class CucumberTest {
}
