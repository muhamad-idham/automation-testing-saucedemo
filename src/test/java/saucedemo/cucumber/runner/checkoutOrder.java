package saucedemo.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/saucedemo/cucumber/features",
        glue = "saucedemo.cucumber.stepDef.checkoutOrder",
        plugin = {"html:target/HTML_report.html"},
        tags = "@CheckoutOrder"
)
public class checkoutOrder {
}
