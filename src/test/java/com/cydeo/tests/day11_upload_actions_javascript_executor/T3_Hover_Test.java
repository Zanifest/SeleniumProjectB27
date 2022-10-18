package com.cydeo.tests.day11_upload_actions_javascript_executor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class T3_Hover_Test {
    /*
    1. Go to https://practice.cydeo.com/hovers
2. Hover over to first image
3. Assert:
a. “name: user1” is displayed
b. “view profile” is displayed
   4. Hover over to second image
   5. Assert:
a. “name: user2” is displayed
b. “view profile” is displayed
   6. Hover over to third image
   7. Confirm:
a. “name: user3” is displayed
b. “view profile” is displayed
﻿
     */
    @Test
    public void hover_test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("hovers.url"));

        WebElement image1 = Driver.getDriver().findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[1]"));
        WebElement image2 = Driver.getDriver().findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[2]"));
        WebElement image3 = Driver.getDriver().findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[3]"));

        WebElement user1 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        WebElement user1ViewProfile = Driver.getDriver().findElement(By.xpath("//a[@href='/users/1']"));
        WebElement user2 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        WebElement user2ViewProfile = Driver.getDriver().findElement(By.xpath("//a[@href='/users/2']"));
        WebElement user3 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));
        WebElement user3ViewProfile = Driver.getDriver().findElement(By.xpath("//a[@href='/users/3']"));

        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(image1).perform();
        Assert.assertTrue(user1ViewProfile.isDisplayed());
        Assert.assertTrue(user1.isDisplayed());

        actions.moveToElement(image2).perform();
        Assert.assertTrue(user2ViewProfile.isDisplayed());
        Assert.assertTrue(user2.isDisplayed());

        actions.moveToElement(image3).perform();
        Assert.assertTrue(user3ViewProfile.isDisplayed());
        Assert.assertTrue(user3.isDisplayed());
    }

//    @Test
//    public void T3(){
//        Driver.getDriver().get("https://practice.cydeo.com/hovers");
//
//        List<WebElement> pics = Driver.getDriver().findElements(By.xpath("//img"));
//        List<WebElement> names = Driver.getDriver().findElements(By.xpath("//h5"));
//        List<WebElement> view = Driver.getDriver().findElements(By.xpath("//a[.='View profile']"));
//        Actions action = new Actions(Driver.getDriver());
//
//        for (int i = 0; i < pics.size(); i++) {
//            action.moveToElement(pics.get(i)).perform();
//            Assert.assertTrue(names.get(i).isDisplayed());
//            Assert.assertTrue(view.get(i).isDisplayed());
//        }
//
//        Driver.closeDriver();
//    }

}
