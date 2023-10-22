package saucedemo.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class removeOrder {
    @Test
    public void remove_order(){
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

        // Assertion Tombol Add to Cart Berubah Menjadi Remove
        String btnOrder = driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-backpack\"]")).getText();
        Assert.assertEquals(btnOrder, "Remove");

        // Klik Tombol Remove
        driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-backpack\"]")).click();

        // Assertion Tombol Remove Berubah Menjadi Add to Cart
        String btnAdd = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).getText();
        Assert.assertEquals(btnAdd, "Add to cart");

        // Klik Tombol Cart Icon
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

        // Assertion Order Cart
        String cartPage = driver.findElement(By.xpath("//span[contains(text(),'Your Cart')]")).getText();
        Assert.assertEquals(cartPage, "Your Cart");

        // Close
        driver.close();
    }

    @Test
    public void remove_order_on_detail_product(){
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

        // Klik Product Title
        driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]")).click();

        // Assertion Product to Order
        String product = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]")).getText();
        Assert.assertEquals(product, "Sauce Labs Backpack");

        // Klik Add to Cart
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();

        // Assertion Product Added to Cart
        String cart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
        Assert.assertEquals(cart, "1");

        // Assertion Tombol Add to Cart Berubah Menjadi Remove
        String btnOrder = driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-backpack\"]")).getText();
        Assert.assertEquals(btnOrder, "Remove");

        // Klik Tombol Remove
        driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-backpack\"]")).click();

        // Assertion Tombol Remove Berubah Menjadi Add to cart
        String btnAdd = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).getText();
        Assert.assertEquals(btnAdd, "Add to cart");

        // Klik Tombol Cart Icon
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

        // Assertion Order Cart
        String cartPage = driver.findElement(By.xpath("//span[contains(text(),'Your Cart')]")).getText();
        Assert.assertEquals(cartPage, "Your Cart");

        // Close
        driver.close();
    }

    @Test
    public void remove_order_on_cart_page(){
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

        // Klik Cart Icon
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

        // Assertion Tombol Remove Cart Page
        String btnOrder = driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-backpack\"]")).getText();
        Assert.assertEquals(btnOrder, "Remove");

        // Klik Tombol Remove
        driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-backpack\"]")).click();

        // Assertion Order Cart
        String cartPage = driver.findElement(By.xpath("//span[contains(text(),'Your Cart')]")).getText();
        Assert.assertEquals(cartPage, "Your Cart");

        // Close
        driver.close();
    }
}
