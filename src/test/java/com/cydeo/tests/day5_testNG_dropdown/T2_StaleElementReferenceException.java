package com.cydeo.tests.day5_testNG_dropdown;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T2_StaleElementReferenceException {
    /*
    1. Open Chrome browser
2. Go to https://practice.cydeo.com/add_remove_elements/
3. Click to “Add Element” button
4. Verify “Delete” button is displayed after clicking.
5. Click to “Delete” button.
6. Verify “Delete” button is NOT displayed after clicking. USE
     */
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.navigate().to("https://practice.cydeo.com/add_remove_elements/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement addElementBtn = driver.findElement(By.xpath("//button[@onclick = 'addElement()']"));
        addElementBtn.click();

        WebElement deleteBtn = driver.findElement(By.xpath("//button[@onclick = 'deleteElement()']"));
        System.out.println(deleteBtn.isDisplayed());
        deleteBtn.click();

        try {
            System.out.println("AFTER: deleteBtn.isDisplayed() = " + deleteBtn.isDisplayed());
        } catch (StaleElementReferenceException e) {
            System.out.println("AFTER: NOT Displayed");
        }

        driver.quit();

    }
}
