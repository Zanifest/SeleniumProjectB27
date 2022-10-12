package com.cydeo.tests.day7_windows_webtables;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class T1_MultipleWindows {

    WebDriver driver;

    /*
    1. Open a chrome browser
2. Go to : https://practice.cydeo.com/windows
    3. Assert: Title is “Windows”
4. Click to: “Click Here” link
5. Click to: “CYDEO” link
6. Switch to Cydeo page.
7. Assert: Title is “Cydeo”
     */
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://practice.cydeo.com/windows");
    }

    @Test
    public void multiple_windows_test(){
        String currentTitle = driver.getTitle();
        String expectedTitle = "Windows";
        Assert.assertEquals(currentTitle, expectedTitle);

        WebElement clickHereLink = driver.findElement(By.xpath("//a[@href='/windows/new']"));
        WebElement cydeoLink = driver.findElement(By.xpath("//a[@href='https://cydeo.com/']"));
        clickHereLink.click();
        cydeoLink.click();

        Set<String> allWindows = driver.getWindowHandles();

        for (String eachWindow : allWindows) {
            driver.switchTo().window(eachWindow);
            System.out.println("driver.getTitle() = " + driver.getTitle());
            if (driver.getTitle().equals("Cydeo")){
                break;
            }
        }
        currentTitle = driver.getTitle();
        expectedTitle = "Cydeo";
        Assert.assertEquals(currentTitle, expectedTitle);

    }

    @AfterMethod
    public void tearDown(){
//        driver.close();
        driver.quit();
    }

}
