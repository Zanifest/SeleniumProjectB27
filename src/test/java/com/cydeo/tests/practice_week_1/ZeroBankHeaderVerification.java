package com.cydeo.tests.practice_week_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBankHeaderVerification {

    /*
    TC #2: Zero Bank header verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Verify header text
Expected: “Log in to ZeroBank”
     */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("http://zero.webappsecurity.com/login.html");
        WebElement headerTextBox = driver.findElement(By.tagName("h3"));
        String actualHeaderText = headerTextBox.getText();
        String expectedHeaderText = "Log in to ZeroBank";

        if (actualHeaderText.equals(expectedHeaderText)){
            System.out.println("Header Text Test PASSED!");
        } else {
            System.out.println("Header Text Test FAILED!");
        }

        driver.quit();

    }

}
