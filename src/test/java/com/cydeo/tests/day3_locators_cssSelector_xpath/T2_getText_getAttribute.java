package com.cydeo.tests.day3_locators_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_getText_getAttribute {
    /*
    1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “remember me” label text is as expected:
Expected: Remember me on this computer
4- Verify “forgot password” link text is as expected:
Expected: Forgot your password?
5- Verify “forgot password” href attribute’s value contains expected:
Expected: forgot_password=yes
     */
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.navigate().to("https://login1.nextbasecrm.com/");

        String actualRememberMeLabel = driver.findElement(By.className("login-item-checkbox-label")).getText();
        String expectedRememberMeLabel = "Remember me on this computer";

        if (actualRememberMeLabel.equals(expectedRememberMeLabel)){
            System.out.println("Remember me label Test PASSED!");
        } else {
            System.out.println("Remember me label Test FAILED!");
        }
        WebElement forgotPasswordLabel = driver.findElement(By.className("login-link-forgot-pass"));
        String actualForgotPasswordLabel = forgotPasswordLabel.getText();
        String expectedForgotPasswordLabel = "FORGOT YOUR PASSWORD?";

        if (actualForgotPasswordLabel.equals(expectedForgotPasswordLabel)){
            System.out.println("Forgot Password label PASSED!");
        } else {
            System.out.println("actualForgotPasswordLabel = " + actualForgotPasswordLabel);
            System.out.println("expectedForgotPasswordLabel = " + expectedForgotPasswordLabel);
            System.out.println("Forgot Password label FAILED!");
        }

        String actualHrefForgotPassword = forgotPasswordLabel.getAttribute("href");
        String expectedHrefForgotPassword = "forgot_password=yes";

        if (actualHrefForgotPassword.contains(expectedHrefForgotPassword)){
            System.out.println("href attribute value Test PASSED!");
        } else {
            System.out.println("href attribute value Test FAILED!");
        }
        WebElement loginBtn = driver.findElement(By.cssSelector("input[class='login-btn']"));
        loginBtn.click();


    }
}
