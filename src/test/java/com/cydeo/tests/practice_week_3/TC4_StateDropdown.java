package com.cydeo.tests.practice_week_3;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC4_StateDropdown {
    /*
    TC #4: Selecting state from State dropdown and verifying
result
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select Illinois
4. Select Virginia
5. Select California
6. Verify final selected option is California.
Use all Select options. (visible text, value, index)
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
        driver.navigate().to("http://practice.cybertekschool.com/dropdown");
        Select selectStateDropdown = new Select(driver.findElement(By.id("state")));
        selectStateDropdown.selectByValue("IL");
        selectStateDropdown.selectByVisibleText("Virginia");
        selectStateDropdown.selectByIndex(5);

        Assert.assertTrue(driver.findElement(By.xpath("//option[@value = 'CA']")).isSelected());

    }

    @AfterClass
    public void tearDownMethod(){
        driver.quit();
    }

}
