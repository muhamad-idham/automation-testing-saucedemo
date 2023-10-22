package saucedemo.cucumber.stepDef.filterProduct;

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

public class filterProduct {
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

    @And("User click filter button")
    public void userClickFilterButton() {
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")).click();
    }

    @And("User click filter sort by name z to a option")
    public void userClickFilterSortByNameZToAOption() {
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[2]")).click();
    }

    @Then("User see the product with descending name")
    public void userSeeTheProductWithDescendingName() {
        String option2 = driver.findElement(By.xpath("//span[@class='active_option']")).getText();
        Assert.assertEquals(option2, "Name (Z to A)");
        String desc = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[@class='inventory_item_description']/div[@class='inventory_item_label']/a/div")).getText();
        Assert.assertEquals(desc, "Test.allTheThings() T-Shirt (Red)");
    }

    @And("User click filter sort by name a to z option")
    public void userClickFilterSortByNameAToZOption() {
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[1]")).click();
    }

    @Then("User see the product with ascending name")
    public void userSeeTheProductWithAscendingName() {
        String option1 = driver.findElement(By.xpath("//span[@class='active_option']")).getText();
        Assert.assertEquals(option1, "Name (A to Z)");
        String asc = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[@class='inventory_item_description']/div[@class='inventory_item_label']/a/div")).getText();
        Assert.assertEquals(asc, "Sauce Labs Backpack");

        // Close
        driver.close();
    }

    @And("User click filter sort by price low to high option")
    public void userClickFilterSortByPriceLowToHighOption() {
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]")).click();
    }

    @Then("User see the product with ascending price")
    public void userSeeTheProductWithAscendingPrice() {
        String option3 = driver.findElement(By.xpath("//span[@class='active_option']")).getText();
        Assert.assertEquals(option3, "Price (low to high)");
        String asc = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[@class='inventory_item_description']/div[@class='pricebar']/div")).getText();
        Assert.assertEquals(asc, "$7.99");
    }

    @And("User click filter sort by price high to low option")
    public void userClickFilterSortByPriceHighToLowOption() {
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[4]")).click();
    }

    @Then("User see the product with descending price")
    public void userSeeTheProductWithDescendingPrice() {
        String option4 = driver.findElement(By.xpath("//span[@class='active_option']")).getText();
        Assert.assertEquals(option4, "Price (high to low)");
        String desc = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[@class='inventory_item_description']/div[@class='pricebar']/div")).getText();
        Assert.assertEquals(desc, "$49.99");

        // Close
        driver.close();
    }

    @When("User input problem username")
    public void userInputProblemUsername() {
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
    }
}
