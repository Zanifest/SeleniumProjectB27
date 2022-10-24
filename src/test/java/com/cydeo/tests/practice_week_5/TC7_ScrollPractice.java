package com.cydeo.tests.practice_week_5;

import com.cydeo.utilities.Driver;
import com.google.errorprone.annotations.FormatMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC7_ScrollPractice {
    /*
    TC #7: Scroll using JavascriptExecutor
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/large
3- Scroll down to “Cydeo” link
4- Scroll up to “Home” link
5- Use below provided JS method only

JavaScript method to use : arguments[0].scrollIntoView(true)

Note: You need to locate the links as web elements and pass them
as arguments into executeScript() method
     */

    @Test
    public void TC7(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("https://practice.cydeo.com/large");

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        WebElement cydeoLink = driver.findElement(By.xpath("//a[@href='https://cydeo.com/']"));
        WebElement homeLink = driver.findElement(By.xpath("//a[@href='/']"));

        js.executeScript("arguments[0].scrollIntoView(true)",cydeoLink);
        js.executeScript("arguments[0].scrollIntoView(true)", homeLink);
    }

}
