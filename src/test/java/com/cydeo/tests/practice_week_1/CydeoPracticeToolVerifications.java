package com.cydeo.tests.practice_week_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CydeoPracticeToolVerifications {

    /*
    TC #1: Cydeo practice tool verifications
1. Open Chrome browser
2. Go to
https://practice.cydeo.com
3. Verify URL contains
Expected: cydeo
4. Verify title:
       Expected: Practice
     */
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");

        driver.manage().window().maximize();

        driver.navigate().to("https://practice.cydeo.com");

        if (driver.getCurrentUrl().contains("cydeo")){
            System.out.println("Actual URL Result = Expected URL Result | Test PASSED!");
        } else {
            System.out.println("Actual URL Result != Expected URL Result | Test FAILED!");
        }

        String currentTitle = driver.getTitle();

        String expectedTitle = "Practice";

        if (currentTitle.equals(expectedTitle)){
            System.out.println("Titles Matched | Test PASSED!");
        } else {
            System.out.println("Titles did not Match | Test FAILED!");
        }
        Thread.sleep(3000);

        driver.quit();



    }

}
