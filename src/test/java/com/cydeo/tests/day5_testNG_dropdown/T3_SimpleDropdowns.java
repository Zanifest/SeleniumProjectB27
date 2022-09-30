package com.cydeo.tests.day5_testNG_dropdown;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_SimpleDropdowns {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test (priority = 1)
    public void simpleDropdown(){
        /*
        2. Go to https://practice.cydeo.com/dropdown
3. Verify “Simple dropdown” default selected value is correct
Expected: “Please select an option”
4. Verify “State selection” default selected value is correct
Expected: “Select a State”
*/
        driver.navigate().to("https://practice.cydeo.com/dropdown");

        Select simpleDropdown = new Select(driver.findElement(By.id("dropdown")));
        WebElement elementSimpleDropdown = simpleDropdown.getFirstSelectedOption();
        String actualSimpleDropdown = elementSimpleDropdown.getText();
        String expectedSimpleDropdown = "Please select an option";

        Assert.assertEquals(actualSimpleDropdown, expectedSimpleDropdown);

        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        String actualStateDropdown = stateDropdown.getFirstSelectedOption().getText();
        String expectedStateDropdown = "Select a State";

        Assert.assertEquals(actualStateDropdown, expectedStateDropdown);

    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }

}
