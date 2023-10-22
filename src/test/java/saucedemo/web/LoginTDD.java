package saucedemo.web;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginTDD {
    @Test
    public void login() {
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        String csvDir = System.getProperty("user.dir")+"/src/test/data/login-data.csv";

        try(CSVReader reader = new CSVReader(new FileReader(csvDir))) {
            String[] nextline;

            while ((nextline = reader.readNext()) != null) {
                String user     = nextline[0];
                String password = nextline[1];
                String status   = nextline[2];

                driver = new ChromeDriver(opt);
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                driver.get(baseUrl);

                // Pengisian form
                driver.findElement(By.id("user-name")).sendKeys(user);
                driver.findElement(By.id("password")).sendKeys(password);
                driver.findElement(By.xpath("//input[@type='submit']")).click();

                // Assertion
                if(status.equals("success")) { // Jika Success
                    driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]"));
                    String page = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
                    Assert.assertEquals(page, "Products");
                }
                else if(status.equals("locked")) { // Jika Locked Out
                    String lockedLogin = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
                    Assert.assertEquals(lockedLogin, "Epic sadface: Sorry, this user has been locked out.");
                }
                else { // Jika Failed
                    String errorLogin = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
                    Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
                }
                driver.close();
            }
        } catch (CsvValidationException | IOException e) {
            throw  new RuntimeException(e);
        }

    }
}
