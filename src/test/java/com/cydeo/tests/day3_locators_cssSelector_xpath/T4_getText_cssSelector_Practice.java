package com.cydeo.tests.day3_locators_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class T4_getText_cssSelector_Practice {
    /*
    1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
3- Verify “Reset password” button text is as expected:
Expected: Reset password
     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.navigate().to("https://login1.nextbasecrm.com/?forgot_password=yes");

        String actualResetPasswordText = driver.findElement(By.cssSelector("button[value='Reset password']")).getAttribute("value");
        String expectedResetPasswordText = "Reset password";

        if (actualResetPasswordText.equals(expectedResetPasswordText)){
            System.out.println("Reset Password Text Verification PASSED!");
        } else {
            System.out.println("Reset Password Text Verification FAILED!");
        }


    }

}
