package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {
    /*
    1. Create a new method for login
2. Create a method to make Task3 logic re-usable
3. When method is called, it should simply login

This method should have at least 2 overloaded versions.

Method #1 info:
• Name: login_crm()
• Return type: void
• Arg1: WebDriver


Method #2 info:
• Name: login_crm()
• Return type: void
• Arg1: WebDriver
• Arg2: String username
• Arg3: String password
*/
    public static void login_crm(WebDriver driver){
        WebElement usernameBox = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        WebElement passwordBox = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        usernameBox.sendKeys("hr1@cydeo.com");
        passwordBox.sendKeys("UserUser");
        loginButton.click();
    }

    public static void login_crm(WebDriver driver, String username, String password){
        WebElement usernameBox = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        WebElement passwordBox = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);

        loginButton.click();
    }

}
