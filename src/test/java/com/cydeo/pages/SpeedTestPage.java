package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpeedTestPage {

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

    public SpeedTestPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy (xpath = "//span[@class='start-text']")
    public WebElement goButton;
    // if you have white spaces in your locator in HTML you can use normalize-space() to locate element
    @FindBy (xpath = "//a[normalize-space()='Results']")
    public WebElement resultsLink;

    @FindBy (xpath = "//canvas[@class='gauge-speed-text']")
    public WebElement gaugeSpeedNeedle;

    @FindBy (xpath = "//span[@class='result-data-large number result-data-value download-speed']")
    public WebElement downloadSpeedDisplay;

    @FindBy (xpath = "//span[@class='result-data-large number result-data-value upload-speed']")
    public WebElement uploadSpeedDisplay;

}
