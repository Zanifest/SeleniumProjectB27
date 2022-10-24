package com.cydeo.tests.day14_explicitwait_review;

import com.cydeo.pages.SpeedTestPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SpeedTestPageTest {

    /*
    TC #2: Explicit wait practice
1- Open a chrome browser

2- Go to: https://www.speedtest.net/
3- Wait until Results link is displayed
4- Click on Go button
5- Wait until gauge-speed-needle displayed
6- Wait until gauge-speed-needle disappear
7- Print Download and Upload Speeds
     */
    SpeedTestPage speedTestPage;

    @Test
    public void test(){
        Driver.getDriver().get("https://www.speedtest.net/");
        speedTestPage = new SpeedTestPage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 40);

        wait.until(ExpectedConditions.visibilityOf(speedTestPage.resultsLink));

        speedTestPage.goButton.click();

        wait.until(ExpectedConditions.visibilityOf(speedTestPage.gaugeSpeedNeedle));
        wait.until(ExpectedConditions.invisibilityOf(speedTestPage.gaugeSpeedNeedle));

        System.out.println("Download speed = " + speedTestPage.downloadSpeedDisplay.getText());
        System.out.println("Upload speed = " + speedTestPage.uploadSpeedDisplay.getText());

    }

}
