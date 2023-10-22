package saucedemo.cucumber.stepDef.removeOrder;

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

public class removeOrder {
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

    @Then("User see product to order")
    public void userSeeProductToOrder() {
        String product = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]")).getText();
        Assert.assertEquals(product, "Sauce Labs Backpack");
    }

    @When("User click add to cart on product")
    public void userClickAddToCartOnProduct() {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
    }

    @Then("User see the product count increase on cart icon")
    public void userSeeTheProductCountIncreaseOnCartIcon() {
        String cart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
        Assert.assertEquals(cart, "1");
    }

    @And("User see remove button on product")
    public void userSeeRemoveButtonOnProduct() {
        String btnOrder = driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-backpack\"]")).getText();
        Assert.assertEquals(btnOrder, "Remove");
    }

    @When("User click cart icon button")
    public void userClickCartIconButton() {
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
    }

    @Then("User see the cart page")
    public void userSeeTheCartPage() {
        String cartPage = driver.findElement(By.xpath("//span[contains(text(),'Your Cart')]")).getText();
        Assert.assertEquals(cartPage, "Your Cart");
    }

    @And("User see product in the order cart")
    public void userSeeProductInTheOrderCart() {
        // Assertion Order Cart
        String order = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]")).getText();
        Assert.assertEquals(order, "Sauce Labs Backpack");

        // Close
        driver.close();
    }

    @And("User click product title")
    public void userClickProductTitle() {
        driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]")).click();
    }

    @When("User input problem username")
    public void userInputProblemUsername() {
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
    }

    @When("User click remove button on product ordered")
    public void userClickRemoveButtonOnProductOrdered() {
        driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-backpack\"]")).click();
    }

    @Then("User see add to cart button on order removed")
    public void userSeeAddToCartButtonOnOrderRemoved() {
        String btnAdd = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).getText();
        Assert.assertEquals(btnAdd, "Add to cart");
    }

    @And("User not see removed product in the order cart")
    public void userNotSeeRemovedProductInTheOrderCart() {
        // Assertion Order Cart
        String cartPage = driver.findElement(By.xpath("//span[contains(text(),'Your Cart')]")).getText();
        Assert.assertEquals(cartPage, "Your Cart");

        // Close
        driver.close();
    }
}
