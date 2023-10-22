package saucedemo.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class filterProduct {
    @Test
    public void filter_sort_product(){
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

        // Klik Tombol Filter
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")).click();
        // Klik Pilihan Filter by Name Z to A
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[2]")).click();

        // Assertion Filter Product Descending
        String option2 = driver.findElement(By.xpath("//span[@class='active_option']")).getText();
        Assert.assertEquals(option2, "Name (Z to A)");
        String desc = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[@class='inventory_item_description']/div[@class='inventory_item_label']/a/div")).getText();
        Assert.assertEquals(desc, "Test.allTheThings() T-Shirt (Red)");

        // Klik Tombol Filter
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")).click();
        // Klik Pilihan Filter by Name Z to A
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[1]")).click();

        // Assertion Filter Product Ascending
        String option1 = driver.findElement(By.xpath("//span[@class='active_option']")).getText();
        Assert.assertEquals(option1, "Name (A to Z)");
        String asc = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[@class='inventory_item_description']/div[@class='inventory_item_label']/a/div")).getText();
        Assert.assertEquals(asc, "Sauce Labs Backpack");

        // Close
        driver.close();
    }

    @Test
    public void filter_sort_product_by_price(){
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

        // Klik Tombol Filter
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")).click();
        // Klik Pilihan Filter by Price Low to High
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]")).click();

        // Assertion Filter Product Price Ascending
        String option3 = driver.findElement(By.xpath("//span[@class='active_option']")).getText();
        Assert.assertEquals(option3, "Price (low to high)");
        String asc = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[@class='inventory_item_description']/div[@class='pricebar']/div")).getText();
        Assert.assertEquals(asc, "$7.99");

        // Klik Tombol Filter
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")).click();
        // Klik Pilihan Filter by Price High to Low
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[4]")).click();

        // Assertion Filter Product Price Descending
        String option4 = driver.findElement(By.xpath("//span[@class='active_option']")).getText();
        Assert.assertEquals(option4, "Price (high to low)");
        String desc = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[@class='inventory_item_description']/div[@class='pricebar']/div")).getText();
        Assert.assertEquals(desc, "$49.99");

        // Close
        driver.close();
    }

    @Test
    public void filter_sort_product_by_price_using_problem_user(){
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
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        // Input Password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // Klik Tombol Login
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Klik Tombol Filter
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")).click();
        // Klik Pilihan Filter by Price Low to High
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]")).click();

        // Assertion Filter Product Price Ascending
        String option3 = driver.findElement(By.xpath("//span[@class='active_option']")).getText();
        Assert.assertEquals(option3, "Price (low to high)");
        String asc = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[@class='inventory_item_description']/div[@class='pricebar']/div")).getText();
        Assert.assertEquals(asc, "$7.99");

        // Klik Tombol Filter
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")).click();
        // Klik Pilihan Filter by Price High to Low
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[4]")).click();

        // Assertion Filter Product Price Descending
        String option4 = driver.findElement(By.xpath("//span[@class='active_option']")).getText();
        Assert.assertEquals(option4, "Price (high to low)");
        String desc = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[@class='inventory_item_description']/div[@class='pricebar']/div")).getText();
        Assert.assertEquals(desc, "$49.99");

        // Close
        driver.close();
    }
}
