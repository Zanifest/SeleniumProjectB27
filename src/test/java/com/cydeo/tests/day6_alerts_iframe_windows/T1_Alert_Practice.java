package com.cydeo.tests.day6_alerts_iframe_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.concurrent.TimeUnit;

public class T1_Alert_Practice {


    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("http://practice.cydeo.com/javascript_alerts");
    }
    /*
    1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Alert” button
4. Click to OK button from the alert
5. Verify “You successfully clicked an alert” text is displayed.
     */
    @Test
    public void alertTest1(){

        WebElement jsAlertBtn = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
        jsAlertBtn.click();

        // To handle JS alerts we have to use Alert for switching driver to alert form
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement elementActualText = driver.findElement(By.id("result"));
        String expectResult = "You successfully clicked an alert";
        String actualResult = elementActualText.getText();

        Assert.assertTrue(elementActualText.isDisplayed());

        Assert.assertEquals(actualResult, expectResult, "Verify Result of Alert Text : Failed!" );
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }

}
