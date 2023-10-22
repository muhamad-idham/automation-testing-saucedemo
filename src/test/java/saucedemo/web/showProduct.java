package saucedemo.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class showProduct {
    @Test
    public void show_product(){
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

        // Assertion Show Product
        String product = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]")).getText();
        Assert.assertEquals(product, "Sauce Labs Backpack");

        // Klik Tombol Back to Products
        driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();

        // Assertion Show All Products
        String page = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
        Assert.assertEquals(page, "Products");

        // Close
        driver.close();
    }

    @Test
    public void show_product_through_image(){
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
        // Klik Product Image
        driver.findElement(By.xpath("//img[@src='/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg']")).click();

        // Assertion Show Product
        String product = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]")).getText();
        Assert.assertEquals(product, "Sauce Labs Backpack");

        // Klik Tombol Back to Products
        driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();

        // Assertion Show All Products
        String page = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
        Assert.assertEquals(page, "Products");

        // Close
        driver.close();
    }

    @Test
    public void show_product_through_wrong_title(){
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

        // Input Problem Username
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        // Input Password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // Klik Tombol Login
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        // Klik Wrong Product Title
        driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]")).click();

        // Assertion Show Different Product Title
        String product = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Fleece Jacket')]")).getText();
        Assert.assertEquals(product, "Sauce Labs Backpack");

        // Klik Tombol Back to Products
        driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();

        // Assertion Show All Products
        String page = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
        Assert.assertEquals(page, "Products");

        // Close
        driver.close();
    }

    @Test
    public void show_product_through_wrong_image(){
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

        // Input Problem Username
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        // Input Password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // Klik Tombol Login
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        // Klik Wrong Product Image
        driver.findElement(By.xpath("//img[@src='/static/media/sl-404.168b1cce.jpg']")).click();

        // Show Different Product Title
        String product = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Fleece Jacket')]")).getText();
        Assert.assertEquals(product, "Sauce Labs Backpack");

        // Klik Tombol Back to Products
        driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();

        // Assertion Show All Products
        String page = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
        Assert.assertEquals(page, "Products");

        // Close
        driver.close();
    }
}
