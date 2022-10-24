package com.cydeo.tests.day12_actions_javascriptexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T7_JavascriptExecutor_scroll_test {

    @Test
    public void task7_javascript_scroll_test(){
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/large
        Driver.getDriver().get("https://practice.cydeo.com/large");

        //3- Scroll down to “Cydeo” link
        JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());

        WebElement cydeoLink =  Driver.getDriver().findElement(By.xpath("//a[@href='https://cydeo.com/']"));
        //4- Scroll up to “Home” link
        WebElement homeLink = Driver.getDriver().findElement(By.xpath("//a[@href='/']"));
        js.executeScript("arguments[0].scrollIntoView(true)", cydeoLink);
        BrowserUtils.sleep(1);
//        js.executeScript("arguments[1].scrollIntoView(true)", cydeoLink, homeLink);
        js.executeScript("arguments[0].scrollIntoView(true)", homeLink);

    }

}
