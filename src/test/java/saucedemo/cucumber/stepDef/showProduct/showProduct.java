package saucedemo.cucumber.stepDef.showProduct;

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

public class showProduct {
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

    @When("User input standard username")
    public void userInputStandardUsername() {
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

    @And("User click product title")
    public void userClickProductTitle() {
        driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]")).click();
    }

    @Then("User see the product")
    public void userSeeTheProduct() {
        String product = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]")).getText();
        Assert.assertEquals(product, "Sauce Labs Backpack");
    }

    @When("User click back to products button")
    public void userClickBackToProductsButton() {
        driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();
    }

    @Then("User see the product page")
    public void userSeeTheProductPage() {
        // Assertion
        String page = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
        Assert.assertEquals(page, "Products");

        // Close
        driver.close();
    }

    @And("User click product image")
    public void userClickProductImage() {
        driver.findElement(By.xpath("//img[@src='/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg']")).click();
    }

    @When("User input problem username")
    public void userInputProblemUsername() {
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
    }

    @And("User click wrong product title")
    public void userClickWrongProductTitle() {
        driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]")).click();
    }

    @And("User click wrong product image")
    public void userClickWrongProductImage() {
        driver.findElement(By.xpath("//img[@src='/static/media/sl-404.168b1cce.jpg']")).click();
    }

    @Then("User see the different product")
    public void userSeeTheDifferentProduct() {
        String product = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Fleece Jacket')]")).getText();
        Assert.assertEquals(product, "Sauce Labs Backpack");
    }
}
