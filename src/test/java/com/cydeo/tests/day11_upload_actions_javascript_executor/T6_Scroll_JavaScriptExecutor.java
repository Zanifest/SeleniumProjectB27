package com.cydeo.tests.day11_upload_actions_javascript_executor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T6_Scroll_JavaScriptExecutor {

    /*
    T6_Scroll_JavaScriptExecutor
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/infinite_scroll
3- Use below JavaScript method and scroll
a. 750 pixels down 10 times.
b. 750 pixels up 10 times
     */
    @Test
    public void scroll_javascriptexecutor_test(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("https://practice.cydeo.com/infinite_scroll");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        // Syntax of executeScript
//        js.executeScript("window.scrollBy(0,750)");

        for (int i = 0; i < 10; i++) {
            // used to see pixel scrolls
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,750)");
        }
        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,-750)");
        }

    }
}
