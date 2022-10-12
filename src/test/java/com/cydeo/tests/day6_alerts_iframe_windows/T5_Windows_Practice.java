package com.cydeo.tests.day6_alerts_iframe_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_Windows_Practice {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://practice.cydeo.com/windows");
    }
    /*
    1. Create a new class called: T5_WindowsPractice
2. Create new test and make set ups
3. Go to : https://practice.cydeo.com/windows
4. Assert: Title is “Windows”
5. Click to: “Click Here” link
6. Switch to new Window.
7. Assert: Title is “New Window”
     */
    @Test
    public void windowTask(){

        // beginning window
        String mainWindow = driver.getWindowHandle();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Windows";

        Assert.assertEquals(actualTitle, expectedTitle);

        System.out.println("Before opening new window " + actualTitle);

        WebElement clickHere =  driver.findElement(By.xpath("//a[@href ='/windows/new']"));
        clickHere.click();

        actualTitle = driver.getTitle();
        System.out.println("After opening new window");

        for (String eachWindow : driver.getWindowHandles()) {

            driver.switchTo().window(eachWindow);
            System.out.println("eachWindow = " + eachWindow);
            System.out.println("driver.getTitle() = " + driver.getTitle());

        }

        actualTitle = driver.getTitle();
        String expectedTitleAfterClick = "New Window";

        Assert.assertEquals(actualTitle, expectedTitleAfterClick);

        // if you want to go back to your main window in beginning of task
        driver.switchTo().window(mainWindow);
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }

}
