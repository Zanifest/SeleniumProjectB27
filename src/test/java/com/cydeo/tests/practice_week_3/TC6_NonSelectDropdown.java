package com.cydeo.tests.practice_week_3;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC6_NonSelectDropdown {
    /*
    TC #6: Selecting value from non-select dropdown
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Click to non-select dropdown
4. Select Facebook from dropdown
5. Verify title is “Facebook - Log In or Sign Up”
     */

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test(){
        driver.navigate().to("https://practice.cydeo.com/dropdown");
        WebElement selectNonSelectedDropdown = (driver.findElement(By.id("dropdownMenuLink")));
        selectNonSelectedDropdown.click();
        WebElement facebook = driver.findElement(By.linkText("Facebook"));
        facebook.click();

        Assert.assertEquals(driver.getTitle(),"Facebook - Log In or Sign Up");

    }

    @AfterClass
    public void tearDownMethod(){
        driver.quit();
    }


}
