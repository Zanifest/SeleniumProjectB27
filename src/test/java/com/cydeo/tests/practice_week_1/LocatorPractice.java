package com.cydeo.tests.practice_week_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorPractice {

    public static void main(String[] args) {

        // initial set up
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // navigate to https://app.vytrack.com/user/login
        driver.navigate().to("https://app.vytrack.com/user/login");
        // same thing different syntax
        // driver.get("https://app.vytrack.com/user/login");

        // Enter username provided : "abcd"
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("abcd");

        // Enter password provided : "abcd
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("abcd");

        // Click on Login
        WebElement loginButton = driver.findElement(By.id("_submit"));
        loginButton.click();

        // Verify the message "Invalid user name or password.
        WebElement alert = driver.findElement(By.className("alert"));
        if (alert.getText().equals("Invalid user name or password.")){
            System.out.println("Message is Passed");
        }else {
            System.out.println("Message is Failed");
        }
        // verify URL contains "vytrack"
        String actualURL = driver.getCurrentUrl();
        if (actualURL.contains("vytrack")){
            System.out.println("URL is Passed");
        } else {
            System.out.println("URL is Failed");
        }
        // click forgot you password link
        driver.findElement(By.partialLinkText("Forgot")).click();

        // verify title is "Forgot Password"
        if (driver.getTitle().equals("Forgot Password")){
            System.out.println("Title is correct");
        } else {
            System.out.println("Title is not correct");
        }
        // close driver
        driver.quit();




    }
}
