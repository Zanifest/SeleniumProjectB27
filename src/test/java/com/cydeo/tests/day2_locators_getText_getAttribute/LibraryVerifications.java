package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LibraryVerifications {
    public static void main(String[] args) throws InterruptedException {

        /*
        1. Open Chrome browser
2. Go to http://library2.cydeo.com/login.html
3. Enter username: “incorrect@email.com”
4. Enter password: “incorrect password”
5. Verify: visually “Sorry, Wrong Email or Password”
displayed
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://google.com");
        Thread.sleep(1000);
        driver.navigate().to("https://library2.cydeo.com/login.html");

        WebElement emailText = driver.findElement(By.className("form-control"));
        emailText.sendKeys("incorrect@email.com");


        WebElement passwordText = driver.findElement(By.id("inputPassword"));
        passwordText.sendKeys("incorrect password");

        WebElement signInButton = driver.findElement(By.tagName("button"));
        signInButton.click();

        driver.quit();




    }
}
