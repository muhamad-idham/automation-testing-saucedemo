package saucedemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User see Saucedemo login page")
    public void user_see_saucedemo_login_page(){

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        // Assertion
        String loginPageAssert = driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @When("User input username")
    public void userInputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("User input password")
    public void userInputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("User click login button")
    public void userClickLoginButton() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("User see the product page")
    public void userSeeTheProductPage() {
        // Assertion
        String page = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
        Assert.assertEquals(page, "Products");

        // Close
        driver.close();
    }

    @When("User input invalid username")
    public void userInputInvalidUsername() {
        driver.findElement(By.id("user-name")).sendKeys("wrong_user");
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        String errorLogin = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");

        // Close
        driver.close();
    }

    @And("User input invalid password")
    public void userInputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("failed_password");
    }

    @When("User input locked out username")
    public void userInputLockedOutUsername() {
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
    }

    @Then("User get error locked out message")
    public void userGetErrorLockedOutMessage() {
        String lockedLogin = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(lockedLogin, "Epic sadface: Sorry, this user has been locked out.");

        // Close
        driver.close();
    }

    @When("User input (.*) as username$")
    public void userInputUsernameAsUsername(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @And("User input (.*) as password$")
    public void userInputPasswordAsPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("User verify (.*) login result$")
    public void userVerifyStatusLoginResult(String status) {
        // Assertion
        if(status.equals("success")) { // Jika Success
            driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]"));
            String page = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
            Assert.assertEquals(page, "Products");
        }
        else if(status.equals("locked")) { // Jika Locked Out
            String lockedLogin = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
            Assert.assertEquals(lockedLogin, "Epic sadface: Sorry, this user has been locked out.");
        }
        else { // Jika Failed
            String errorLogin = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
            Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
        }
        driver.close();
    }
}
