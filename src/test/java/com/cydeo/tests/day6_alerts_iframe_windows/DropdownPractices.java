package com.cydeo.tests.day6_alerts_iframe_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownPractices {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("http://practice.cybertekschool.com/dropdown");
    }
    /*
    1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select Illinois
4. Select Virginia
5. Select California
6. Verify final selected option is California.
Use all Select options. (visible text, value, index)
     */
    @Test (priority = 1)
    public void test() {

        Select selectState = new Select(driver.findElement(By.xpath("//select[@id = 'state']")));
        selectState.selectByVisibleText("Illinois");
        selectState.selectByValue("VA");
        selectState.selectByIndex(5);

        String actualFinalOption = selectState.getFirstSelectedOption().getText();
        String expectedFinalOption = "California";

        Assert.assertEquals(actualFinalOption, expectedFinalOption, "Final selected option verification failed!");
        //Assert.assertTrue(driver.findElement(By.xpath("//option[@value = 'CA']")).isSelected());

        //finding index number from options
        int index = -1;
        for (WebElement option : selectState.getOptions()) {
            index++;
            if (option.getText().equals("Illinois")) {
                System.out.println("IL = " + index);
                ;
            } else if (option.getText().equals("Virginia")) {
                System.out.println("Virginia = " + index);
            } else if (option.getText().equals("California")) {
                System.out.println("California = " + index);
            }

        }
    }
    /*
    TC #7: Selecting value from multiple select dropdown
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select all the options from multiple select dropdown.
4. Print out all selected values.
5. Deselect all values.
     */
        @Test (priority = 2)
        public void test2 (){
            List<String> allSelections = new ArrayList<>();
            Select selectAll = new Select(driver.findElement(By.xpath("//select[@name = 'Languages']")));
            int index = 0;
            for (WebElement each : selectAll.getOptions()) {
                selectAll.selectByIndex(index);
                System.out.println(each.getText());
                allSelections.add(each.getText());
                index++;
            }
            selectAll.deselectAll();
        }

        @AfterMethod
        public void tearDownMethod(){
            driver.quit();
        }

}
