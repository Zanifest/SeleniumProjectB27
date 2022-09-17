package com.cydeo.tests.practice_week_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BackAndFourthNav {
    /*
    TC #3: Back and forth navigation
1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Verify title contains:
  Expected: Gmail
5- Go back to Google by using the .back();
6- Verify title equals:
  Expected: Google
     */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://google.com");
        WebElement gmailButton = driver.findElement(By.className("gb_d"));
        gmailButton.click();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Gmail";
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Gmail Title Test Verification PASSED!");
        } else {
            System.out.println("Gmail Title Test Verification FAILED!");
        }
        driver.navigate().back();
        actualTitle = driver.getTitle();
        expectedTitle = "Google";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Google Title Test Verification PASSED!");
        } else {
            System.out.println("Google Title Test Verification FAILED!");
        }
        driver.quit();

    }
}
