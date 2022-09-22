package com.cydeo.tests.day3_locators_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_cssSelector {
    /*
    1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “Log in” button text is as expected:
Expected: Log In
     */
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.navigate().to("https://login1.nextbasecrm.com/");
        WebElement loginBtn = driver.findElement(By.cssSelector("input[value='Log In']")); // syntax for css selector
        String actualLoginBtnText = loginBtn.getAttribute("value");
        String expectedLoginBtnText = "Log In";

        if (actualLoginBtnText.equals(expectedLoginBtnText)){
            System.out.println("login button text Test PASSED!");
        } else {
            System.out.println("login button text Test FAILED!");
        }
        driver.quit();




    }
}
