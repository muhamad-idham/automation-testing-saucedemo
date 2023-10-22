package saucedemo.cucumber.stepDef.checkoutOrder;

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

public class checkoutOrder {
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
    }

    @When("User click checkout button")
    public void userClickCheckoutButton() {
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
    }

    @Then("User see checkout information page")
    public void userSeeCheckoutInformationPage() {
        String info = driver.findElement(By.xpath("//span[contains(text(),'Checkout: Your Information')]")).getText();
        Assert.assertEquals(info, "Checkout: Your Information");
    }

    @And("User input first name")
    public void userInputFirstName() {
        driver.findElement(By.id("first-name")).sendKeys("Muhamad");
    }

    @And("User input last name")
    public void userInputLastName() {
        driver.findElement(By.id("last-name")).sendKeys("Idham");
    }


    @And("User input postal code")
    public void userInputPostalCode() {
        driver.findElement(By.id("postal-code")).sendKeys("13579");
    }

    @And("User click continue button")
    public void userClickContinueButton() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("User see checkout overview page and total price")
    public void userSeeCheckoutOverviewPageAndTotalPrice() {
        String overview = driver.findElement(By.xpath("//span[contains(text(),'Checkout: Overview')]")).getText();
        Assert.assertEquals(overview, "Checkout: Overview");
        String price = driver.findElement(By.xpath("//div[contains(text(),'Total: ')]")).getText();
        Assert.assertNotEquals(price, "Total: $0.00");
    }

    @And("User click finish button")
    public void userClickFinishButton() {
        driver.findElement(By.xpath("//button[@id='finish']")).click();
    }

    @And("User see checkout finish message")
    public void userSeeCheckoutFinishMessage() {
        String success = driver.findElement(By.xpath("//h2[contains(text(),'Thank you for your order!')]")).getText();
        Assert.assertEquals(success, "Thank you for your order!");

        // Close
        driver.close();
    }

    @Then("User see error message input first name")
    public void userSeeErrorMessageInputFirstName() {
        String errorFirstName = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(errorFirstName, "Error: First Name is required");

        // Close
        driver.close();
    }

    @Then("User see error message input last name")
    public void userSeeErrorMessageInputLastName() {
        String errorFirstName = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(errorFirstName, "Error: Last Name is required");

        // Close
        driver.close();
    }

    @Then("User see error message input postal code")
    public void userSeeErrorMessageInputPostalCode() {
        String errorFirstName = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(errorFirstName, "Error: Postal Code is required");

        // Close
        driver.close();
    }
}
