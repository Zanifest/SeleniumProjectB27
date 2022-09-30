package com.cydeo.tests.day5_testNG_dropdown;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T1_RadioButton {
    /*
    http://practice.cydeo.com/radio_buttons
1. Open Chrome browser
2. Go to https://practice.cydeo.com/radio_buttons
3. Click to “Hockey” radio button
4. Verify “Hockey” radio button is selected after clicking.
day5_testNG_dropdown
     */
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("http://practice.cydeo.com/radio_buttons");

        WebElement hockeyBtn = driver.findElement(By.xpath("//input[@id = 'hockey']"));
        hockeyBtn.click();

        if (hockeyBtn.isSelected()){
            System.out.println("Verify Hocky Button is Selected Test : Passed!");
        } else {
            System.out.println("Verify Hockey Button is Selected Test :  Failed!");
        }

        List<WebElement> sportRadioBtns = driver.findElements(By.xpath("//input[@name='sport']"));

        for (WebElement each : sportRadioBtns) {
            each.click();
            System.out.println(each.isSelected() ? each.getAttribute("id") + " = radio button is selected" : each.getAttribute("id") + " = radio button is not selected");
        }
        driver.quit();




    }
}
