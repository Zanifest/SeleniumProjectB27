package com.cydeo.tests.practice_week_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeCydeoLocators {
    /*
    TC #4: Practice Cydeo – Class locator practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/inputs
3- Click to “Home” link
4- Verify title is as expected:
Expected: Practice

PS: Locate “Home” link using “className” locator
     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://practice.cydeo.com/inputs");
        WebElement homeButton = driver.findElement(By.className("nav-link")); // more efficient than linkText because more unique in this case.
        // WebElement homeButton = driver.findElement(By.linkText("Home"));
        homeButton.click();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Practice";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Home Title Test PASSED!");
        } else {
            System.out.println("Home Title Test FAILED!");
        }
        driver.quit();

    }

}
