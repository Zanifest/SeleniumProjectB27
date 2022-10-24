package com.cydeo.tests.day12_actions_javascriptexecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.security.Key;

public class ActionsPractice {

    @Test
    public void task_4_and_5_test(){

        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/");


        //3- Scroll down to “Powered by CYDEO”
        Actions actions = new Actions(Driver.getDriver());

        //4- Scroll using Actions class “moveTo(element)” method
        WebElement cydeoLink = Driver.getDriver().findElement(By.xpath("//a[@href='https://cydeo.com/']"));
        actions.moveToElement(cydeoLink).perform();

        //2- Scroll back up to “Home” link using PageUP button
        for (int i = 0; i < 2; i++) {
            // allows us to scroll up                          // allows us to scroll down
            actions.sendKeys(Keys.PAGE_UP).perform(); // actions.sendKeys(Keys.PAGE_DOWN);
        }
        Driver.closeDriver();
    }
}
