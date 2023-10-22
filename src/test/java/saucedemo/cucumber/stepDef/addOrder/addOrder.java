package saucedemo.cucumber.stepDef.addOrder;

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

public class addOrder {
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

    @Then("User see more than three products to order")
    public void userSeeMoreThanThreeProductsToOrder() {
        String product1 = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]")).getText();
        Assert.assertEquals(product1, "Sauce Labs Backpack");
        String product2 = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Bike Light')]")).getText();
        Assert.assertEquals(product2, "Sauce Labs Bike Light");
        String product3 = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Bolt T-Shirt')]")).getText();
        Assert.assertEquals(product3, "Sauce Labs Bolt T-Shirt");
        String product4 = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Fleece Jacket')]")).getText();
        Assert.assertEquals(product4, "Sauce Labs Fleece Jacket");
    }

    @When("User click add to cart on more than three products")
    public void userClickAddToCartOnMoreThanThreeProducts() {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")).click();
    }

    @Then("User see the product count increase more than three products on cart icon")
    public void userSeeTheProductCountIncreaseMoreThanThreeProductsOnCartIcon() {
        String cart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
        Assert.assertEquals(cart, "4");
    }

    @And("User see remove button more than three products ordered")
    public void userSeeRemoveButtonMoreThanThreeProductsOrdered() {
        String btnOrder1 = driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-backpack\"]")).getText();
        Assert.assertEquals(btnOrder1, "Remove");
        String btnOrder2 = driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-bike-light\"]")).getText();
        Assert.assertEquals(btnOrder2, "Remove");
        String btnOrder3 = driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-bolt-t-shirt\"]")).getText();
        Assert.assertEquals(btnOrder3, "Remove");
        String btnOrder4 = driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-fleece-jacket\"]")).getText();
        Assert.assertEquals(btnOrder4, "Remove");
    }

    @And("User see more than three products in the order cart")
    public void userSeeMoreThanThreeProductsInTheOrderCart() {
        String order1 = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]")).getText();
        Assert.assertEquals(order1, "Sauce Labs Backpack");
        String order2 = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Bike Light')]")).getText();
        Assert.assertEquals(order2, "Sauce Labs Bike Light");
        String order3 = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Bolt T-Shirt')]")).getText();
        Assert.assertEquals(order3, "Sauce Labs Bolt T-Shirt");
        String order4 = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Fleece Jacket')]")).getText();
        Assert.assertEquals(order4, "Sauce Labs Fleece Jacket");

        // Close
        driver.close();
    }

    @When("User input problem username")
    public void userInputProblemUsername() {
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
    }

}
