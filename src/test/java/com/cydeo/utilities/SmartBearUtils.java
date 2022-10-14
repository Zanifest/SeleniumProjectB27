package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class SmartBearUtils {

    /*
    Mini-Task: CREATE A CLASS à SmartBearUtils
• Create a method called loginToSmartBear
• This method simply logs in to SmartBear when you call it.
• Accepts WebDriver type as parameter
     */

    public static void loginToSmartBear(WebDriver driver){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        WebElement usernameBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        WebElement logInButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));

        usernameBox.sendKeys("Tester");
        passwordBox.sendKeys("test");
        logInButton.click();
    }

}
