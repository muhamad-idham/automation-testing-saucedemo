package saucedemo.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class checkoutOrder {
    @Test
    public void checkout_order(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        // Membuka Halaman Login
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String loginPageAssert = driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");

        // Input Standard Username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // Input Password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // Klik Tombol Login
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Assertion Product to Order
        String product = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]")).getText();
        Assert.assertEquals(product, "Sauce Labs Backpack");

        // Klik Add to Cart
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();

        // Assertion Product Added to Cart
        String cart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
        Assert.assertEquals(cart, "1");

        // Klik Tombol Cart Icon
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

        // Assertion Cart Page
        String cartPage = driver.findElement(By.xpath("//span[contains(text(),'Your Cart')]")).getText();
        Assert.assertEquals(cartPage, "Your Cart");

        // Assertion Order Cart
        String order = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]")).getText();
        Assert.assertEquals(order, "Sauce Labs Backpack");

        // Klik Tombol Checkout
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();

        // Assertion Checkout Information
        String info = driver.findElement(By.xpath("//span[contains(text(),'Checkout: Your Information')]")).getText();
        Assert.assertEquals(info, "Checkout: Your Information");

        // Input First Name
        driver.findElement(By.id("first-name")).sendKeys("Muhamad");
        // Input Last Name
        driver.findElement(By.id("last-name")).sendKeys("Idham");
        // Input Zip/Postal Code
        driver.findElement(By.id("postal-code")).sendKeys("13579");
        // Klik Tombol Continue
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Assertion Checkout Overview
        String overview = driver.findElement(By.xpath("//span[contains(text(),'Checkout: Overview')]")).getText();
        Assert.assertEquals(overview, "Checkout: Overview");
        String price = driver.findElement(By.xpath("//div[contains(text(),'Total: ')]")).getText();
        Assert.assertNotEquals(price, "Total: $0.00");

        // Klik Tombol Finish
        driver.findElement(By.xpath("//button[@id='finish']")).click();

        // Assertion Checkout Complete
        String success = driver.findElement(By.xpath("//h2[contains(text(),'Thank you for your order!')]")).getText();
        Assert.assertEquals(success, "Thank you for your order!");

        // Close
        driver.close();
    }

    @Test
    public void checkout_order_with_empty_product(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        // Membuka Halaman Login
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String loginPageAssert = driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");

        // Input Standard Username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // Input Password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // Klik Tombol Login
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Assertion Product to Order
        String product = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]")).getText();
        Assert.assertEquals(product, "Sauce Labs Backpack");

        // Klik Tombol Cart Icon
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

        // Assertion Cart Page
        String cartPage = driver.findElement(By.xpath("//span[contains(text(),'Your Cart')]")).getText();
        Assert.assertEquals(cartPage, "Your Cart");

        // Klik Tombol Checkout
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();

        // Assertion Checkout Information
        String info = driver.findElement(By.xpath("//span[contains(text(),'Checkout: Your Information')]")).getText();
        Assert.assertEquals(info, "Checkout: Your Information");

        // Input First Name
        driver.findElement(By.id("first-name")).sendKeys("Muhamad");
        // Input Last Name
        driver.findElement(By.id("last-name")).sendKeys("Idham");
        // Input Zip/Postal Code
        driver.findElement(By.id("postal-code")).sendKeys("13579");
        // Klik Tombol Continue
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Assertion Checkout Overview
        String overview = driver.findElement(By.xpath("//span[contains(text(),'Checkout: Overview')]")).getText();
        Assert.assertEquals(overview, "Checkout: Overview");
        String price = driver.findElement(By.xpath("//div[contains(text(),'Total: ')]")).getText();
        Assert.assertNotEquals(price, "Total: $0.00");

        // Klik Tombol Finish
        driver.findElement(By.xpath("//button[@id='finish']")).click();

        // Assertion Checkout Complete
        String success = driver.findElement(By.xpath("//h2[contains(text(),'Thank you for your order!')]")).getText();
        Assert.assertEquals(success, "Thank you for your order!");

        // Close
        driver.close();
    }

    @Test
    public void checkout_order_with_empty_input_first_name(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        // Membuka Halaman Login
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String loginPageAssert = driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");

        // Input Standard Username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // Input Password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // Klik Tombol Login
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Assertion Product to Order
        String product = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]")).getText();
        Assert.assertEquals(product, "Sauce Labs Backpack");

        // Klik Add to Cart
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();

        // Assertion Product Added to Cart
        String cart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
        Assert.assertEquals(cart, "1");

        // Klik Tombol Cart Icon
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

        // Assertion Cart Page
        String cartPage = driver.findElement(By.xpath("//span[contains(text(),'Your Cart')]")).getText();
        Assert.assertEquals(cartPage, "Your Cart");

        // Assertion Order Cart
        String order = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]")).getText();
        Assert.assertEquals(order, "Sauce Labs Backpack");

        // Klik Tombol Checkout
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();

        // Assertion Checkout Information
        String info = driver.findElement(By.xpath("//span[contains(text(),'Checkout: Your Information')]")).getText();
        Assert.assertEquals(info, "Checkout: Your Information");

        // Input Last Name
        driver.findElement(By.id("last-name")).sendKeys("Idham");
        // Input Zip/Postal Code
        driver.findElement(By.id("postal-code")).sendKeys("13579");
        // Klik Tombol Continue
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Assertion Error First Name
        String errorFirstName = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(errorFirstName, "Error: First Name is required");

        // Close
        driver.close();
    }

    @Test
    public void checkout_order_with_empty_input_last_name(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        // Membuka Halaman Login
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String loginPageAssert = driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");

        // Input Standard Username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // Input Password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // Klik Tombol Login
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Assertion Product to Order
        String product = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]")).getText();
        Assert.assertEquals(product, "Sauce Labs Backpack");

        // Klik Add to Cart
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();

        // Assertion Product Added to Cart
        String cart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
        Assert.assertEquals(cart, "1");

        // Klik Tombol Cart Icon
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

        // Assertion Cart Page
        String cartPage = driver.findElement(By.xpath("//span[contains(text(),'Your Cart')]")).getText();
        Assert.assertEquals(cartPage, "Your Cart");

        // Assertion Order Cart
        String order = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]")).getText();
        Assert.assertEquals(order, "Sauce Labs Backpack");

        // Klik Tombol Checkout
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();

        // Assertion Checkout Information
        String info = driver.findElement(By.xpath("//span[contains(text(),'Checkout: Your Information')]")).getText();
        Assert.assertEquals(info, "Checkout: Your Information");

        // Input First Name
        driver.findElement(By.id("first-name")).sendKeys("Muhamad");
        // Input Zip/Postal Code
        driver.findElement(By.id("postal-code")).sendKeys("13579");
        // Klik Tombol Continue
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Assertion Error Last Name
        String errorFirstName = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(errorFirstName, "Error: Last Name is required");

        // Close
        driver.close();
    }

    @Test
    public void checkout_order_with_empty_input_zip_postal_code(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        // Membuka Halaman Login
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String loginPageAssert = driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");

        // Input Standard Username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // Input Password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // Klik Tombol Login
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Assertion Product to Order
        String product = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]")).getText();
        Assert.assertEquals(product, "Sauce Labs Backpack");

        // Klik Add to Cart
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();

        // Assertion Product Added to Cart
        String cart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
        Assert.assertEquals(cart, "1");

        // Klik Tombol Cart Icon
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

        // Assertion Cart Page
        String cartPage = driver.findElement(By.xpath("//span[contains(text(),'Your Cart')]")).getText();
        Assert.assertEquals(cartPage, "Your Cart");

        // Assertion Order Cart
        String order = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]")).getText();
        Assert.assertEquals(order, "Sauce Labs Backpack");

        // Klik Tombol Checkout
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();

        // Assertion Checkout Information
        String info = driver.findElement(By.xpath("//span[contains(text(),'Checkout: Your Information')]")).getText();
        Assert.assertEquals(info, "Checkout: Your Information");

        // Input First Name
        driver.findElement(By.id("first-name")).sendKeys("Muhamad");
        // Input Last Name
        driver.findElement(By.id("last-name")).sendKeys("Idham");
        // Klik Tombol Continue
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Assertion Error Postal Code
        String errorFirstName = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(errorFirstName, "Error: Postal Code is required");

        // Close
        driver.close();
    }
}
