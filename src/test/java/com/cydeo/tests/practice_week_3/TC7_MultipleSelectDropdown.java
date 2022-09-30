package com.cydeo.tests.practice_week_3;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC7_MultipleSelectDropdown {
    /*
    TC #7: Selecting value from multiple select dropdown
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select all the options from multiple select dropdown.
4. Print out all selected values.
5. Deselect all values.
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

        Select selectAll = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        selectAll.selectByVisibleText("Java");
        selectAll.selectByVisibleText("JavaScript");
        selectAll.selectByVisibleText("C#");
        selectAll.selectByVisibleText("Python");
        selectAll.selectByVisibleText("Ruby");
        selectAll.selectByVisibleText("C");

        List<WebElement> allSelected = selectAll.getOptions();

        for (WebElement webElement : allSelected) {
            System.out.println(webElement.getText());
        }

        selectAll.deselectAll();

    }

        @AfterClass
        public void tearDownMethod() {
            driver.quit();
        }



    }


