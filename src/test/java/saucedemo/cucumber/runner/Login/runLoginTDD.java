package saucedemo.cucumber.runner.Login;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/saucedemo/cucumber/features",
        glue = "saucedemo.cucumber.stepDef",
        plugin = {"html:target/HTML_report.html"},
        tags = "@TDD"
)

public class runLoginTDD {
}
