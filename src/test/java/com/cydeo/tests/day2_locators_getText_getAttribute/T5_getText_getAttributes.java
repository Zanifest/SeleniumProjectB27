package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5_getText_getAttributes {

    public static void main(String[] args) {

        /*
        1- Open a chrome browser
2- Go to: https://practice.cydeo.com/registration_form
3- Verify header text is as expected:
  Expected: Registration form
4- Locate “First name” input box
5- Verify placeholder attribute’s value is as expected:
  Expected: first name
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://practice.cydeo.com/registration_form");

        WebElement headerText = driver.findElement(By.tagName("h2"));
        String expectedHeaderText = "Registration form";
        String actualHeaderText = headerText.getText();
        if (actualHeaderText.equals(expectedHeaderText)){
            System.out.println("Header Text Test Passed!");
        } else {
            System.out.println("Header Text Test Failed!");
        }

        String actualTitle = driver.getTitle();
        String expectedTitle = "Registration Form";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title Test Passed!");
        } else {
            System.out.println("Title Test Failed!");
        }

        WebElement firstNameBox = driver.findElement(By.name("firstname"));
        String expectedPlaceHolder = "first name";
        String actualPlaceHolder = firstNameBox.getAttribute("placeholder");

        if (expectedPlaceHolder.equals(actualPlaceHolder)){
            System.out.println("PlaceHolder text verification Passed!");
        } else {
            System.out.println("PlaceHolder text verification Failed!");
        }

        driver.quit();



    }
}
