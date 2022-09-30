package com.cydeo.tests.practice_week_2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TC6_XpathLocator {
    /*
    TC #6:  XPATH LOCATOR practice
1. Open Chrome browser
2. Go to http://practice.cydeo.com/multiple_buttons
3. Click on Button 1
4. Verify text displayed is as expected:
Expected: “Clicked on button one!”
     */
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("http://practice.cydeo.com/multiple_buttons");
        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        button1.click();

        WebElement textDisplay = driver.findElement(By.xpath("//p[@id='result']"));
        String expectedTextDisplay = "Clicked on button one!";
        String actualTextDisplay = textDisplay.getText();

        System.out.println(actualTextDisplay.equals(expectedTextDisplay)? "Text Display Verification: PASSED!":"Text Display Verification: FAILED!");

        driver.quit();

    }
}
