package com.cydeo.tests.day4_xpath_findEleements_checkbox;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TC3_CheckBoxes {
    /*
    1. Go to http://practice.cydeo.com/checkboxes
2. Confirm checkbox #1 is NOT selected by default
3. Confirm checkbox #2 is SELECTED by default.
4. Click checkbox #1 to select it.
5. Click checkbox #2 to deselect it.
6. Confirm checkbox #1 is SELECTED.
7. Confirm checkbox #2 is NOT selected.
     */
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.navigate().to("http://practice.cydeo.com/checkboxes");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement checkBox1 = driver.findElement(By.cssSelector("input[name='checkbox1']"));
        WebElement checkBox2 = driver.findElement(By.cssSelector("input[name='checkbox2']"));

        System.out.println("before click:");
        System.out.println(checkBox1.isSelected()? "Verification: check box 1 is selected" : "Verification: checkbox 1 is not selected");
        System.out.println(checkBox2.isSelected()? "Verification: check box 2 is selected" : "Verification: checkbox 2 is not selected");

        checkBox1.click();
        checkBox2.click();

        System.out.println("after click:");

        if (checkBox1.isSelected()){
            System.out.println("Verification: checkbox 1 is selected");
        } else {
            System.out.println("Verification: checkbox 1 is not selected");
        }
        if (checkBox2.isSelected()){
            System.out.println("Verification: checkbox 2 is selected");
        } else {
            System.out.println("Verification: checkbox 2 is not selected");
        }
        driver.quit();

    }
}
