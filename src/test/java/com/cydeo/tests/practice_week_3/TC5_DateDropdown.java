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

public class TC5_DateDropdown {
    /*
    TC #5: Selecting date on dropdown and verifying
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select “December 1st, 1923” and verify it is selected.
 Select year using   : visible text
Select month using    : value attribute Select
day using : index number
     */
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        driver.navigate().to("https://practice.cydeo.com/dropdown");
        Select selectYear = new Select(driver.findElement(By.id("year")));
        selectYear.selectByVisibleText("1923");
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        selectMonth.selectByValue("11");
        Select selectDay = new Select(driver.findElement(By.id("day")));
        selectDay.selectByIndex(22);

        Assert.assertTrue(selectYear.getFirstSelectedOption().getText().equals("1923") && selectMonth.getFirstSelectedOption().getText().equals("December") && selectDay.getFirstSelectedOption().getText().equals("23"));
    }
    @AfterClass
    public void tearDownMethod() {
        driver.quit();
    }

}

