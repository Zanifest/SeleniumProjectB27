package com.cydeo.tests.day4_xpath_findEleements_checkbox;


import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC1_xpath_cssSelector {
    public static void main(String[] args) {
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2. Go to https://practice.cydeo.com/forgot_password
        driver.navigate().to("https://practice.cydeo.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH and/or CSS
        //locator only (total of 6)
        //a. “Home” link
        WebElement homeLink = driver.findElement(By.cssSelector("a[class=nav-link]"));

        //b. “Forgot password” header
        WebElement forgotPasswordHeader = driver.findElement(By.xpath("//div[@class='example']/h2"));

        //c. “E-mail” text
        WebElement emailText = driver.findElement(By.xpath("//label[@for='email']"));

        //d. E-mail input box
        WebElement emailInputBox = driver.findElement(By.cssSelector("input[type='text']"));

        //e. “Retrieve password” button
        WebElement retrievePasswordBtn = driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']"));

        //f. “Powered by Cydeo text
        WebElement poweredByCydeoText = driver.findElement(By.cssSelector("div[style='text-align: center;']"));

        //4. Verify all web elements are displayed.
        System.out.println("in if statement");
        if (poweredByCydeoText.isDisplayed() && retrievePasswordBtn.isDisplayed() && emailText.isDisplayed() && emailInputBox.isDisplayed() && forgotPasswordHeader.isDisplayed() && homeLink.isDisplayed()){
            System.out.println("All Web Elements are Displayed");
        } else {
            System.out.println("All Web Elements are not Displayed");
        }
        System.out.println("--------------------------\nAlternative:");
        System.out.println("homeLink.isDisplayed() = " + homeLink.isDisplayed());
        System.out.println("forgotPasswordHeader.isDisplayed() = " + forgotPasswordHeader.isDisplayed());
        System.out.println("emailText.isDisplayed() = " + emailText.isDisplayed());
        System.out.println("emailInputBox.isDisplayed() = " + emailInputBox.isDisplayed());
        System.out.println("retrievePasswordBtn.isDisplayed() = " + retrievePasswordBtn.isDisplayed());
        System.out.println("poweredByCydeoText.isDisplayed() = " + poweredByCydeoText.isDisplayed());

        driver.quit();


    }
}
