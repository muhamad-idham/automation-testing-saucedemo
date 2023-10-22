package saucedemo.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class addOrder {
    @Test
    public void add_order(){
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

        // Klik Tombol Cart Icon
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

        // Assertion Cart Page
        String cartPage = driver.findElement(By.xpath("//span[contains(text(),'Your Cart')]")).getText();
        Assert.assertEquals(cartPage, "Your Cart");

        // Assertion Order Cart
        String order = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]")).getText();
        Assert.assertEquals(order, "Sauce Labs Backpack");

        // Close
        driver.close();
    }

    @Test
    public void add_order_on_detail_product(){
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

        // Klik Cart Icon
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

        // Assertion Cart Page
        String cartPage = driver.findElement(By.xpath("//span[contains(text(),'Your Cart')]")).getText();
        Assert.assertEquals(cartPage, "Your Cart");

        // Assertion Order Cart
        String order = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]")).getText();
        Assert.assertEquals(order, "Sauce Labs Backpack");

        // Close
        driver.close();
    }

    @Test
    public void add_order_more_than_three_products(){
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

        // Assertion > 3 Product to Order
        String product1 = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]")).getText();
        Assert.assertEquals(product1, "Sauce Labs Backpack");
        String product2 = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Bike Light')]")).getText();
        Assert.assertEquals(product2, "Sauce Labs Bike Light");
        String product3 = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Bolt T-Shirt')]")).getText();
        Assert.assertEquals(product3, "Sauce Labs Bolt T-Shirt");
        String product4 = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Fleece Jacket')]")).getText();
        Assert.assertEquals(product4, "Sauce Labs Fleece Jacket");

        // Klik > 3 Product Add to Cart
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")).click();

        // Assertion > 3 Product Added to Cart
        String cart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
        Assert.assertEquals(cart, "4");

        // Assertion Tombol Add to Cart Berubah Menjadi Remove
        String btnOrder1 = driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-backpack\"]")).getText();
        Assert.assertEquals(btnOrder1, "Remove");
        String btnOrder2 = driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-bike-light\"]")).getText();
        Assert.assertEquals(btnOrder2, "Remove");
        String btnOrder3 = driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-bolt-t-shirt\"]")).getText();
        Assert.assertEquals(btnOrder3, "Remove");
        String btnOrder4 = driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-fleece-jacket\"]")).getText();
        Assert.assertEquals(btnOrder4, "Remove");

        // Klik Cart Icon
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

        // Assertion Cart Page
        String cartPage = driver.findElement(By.xpath("//span[contains(text(),'Your Cart')]")).getText();
        Assert.assertEquals(cartPage, "Your Cart");

        // Assertion Order Cart
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

    @Test
    public void add_order_more_than_three_products_using_problem_user(){
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

        // Assertion > 3 Product to Order
        String product1 = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]")).getText();
        Assert.assertEquals(product1, "Sauce Labs Backpack");
        String product2 = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Bike Light')]")).getText();
        Assert.assertEquals(product2, "Sauce Labs Bike Light");
        String product3 = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Bolt T-Shirt')]")).getText();
        Assert.assertEquals(product3, "Sauce Labs Bolt T-Shirt");
        String product4 = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Fleece Jacket')]")).getText();
        Assert.assertEquals(product4, "Sauce Labs Fleece Jacket");

        // Klik > 3 Product Add to Cart
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")).click();

        // Assertion Product Added to Cart
        String cart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
        Assert.assertEquals(cart, "4");

        // Assertion Tombol Add to Cart Berubah Menjadi Remove
        String btnOrder1 = driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-backpack\"]")).getText();
        Assert.assertEquals(btnOrder1, "Remove");
        String btnOrder2 = driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-bike-light\"]")).getText();
        Assert.assertEquals(btnOrder2, "Remove");
        String btnOrder3 = driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-bolt-t-shirt\"]")).getText();
        Assert.assertEquals(btnOrder3, "Remove");
        String btnOrder4 = driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-fleece-jacket\"]")).getText();
        Assert.assertEquals(btnOrder4, "Remove");

        // Klik Cart Icon
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

        // Assertion Cart Page
        String cartPage = driver.findElement(By.xpath("//span[contains(text(),'Your Cart')]")).getText();
        Assert.assertEquals(cartPage, "Your Cart");

        // Assertion Order Cart
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
}
