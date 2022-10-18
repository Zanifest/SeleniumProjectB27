package com.cydeo.tests.practice_week_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC4_5_ScrollPractice {

    /*
    TC #4: Scroll practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/
3- Scroll down to “Powered by CYDEO”
4- Scroll using Actions class “moveTo(element)” method
  */
      /*
TC #5: Scroll practice 2
1- Continue from where the Task 4 is left in the same test.
2- Scroll back up to “Home” link using PageUP button
     */

    @Test
    public void TC4(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("https://practice.cydeo.com/");

        JavascriptExecutor js = ((JavascriptExecutor) driver);

//        for (int i = 0; i < 15; i++) {
//            js.executeScript("window.scrollBy(0,1000)");
//        }
        Actions actions = new Actions(driver);

        WebElement poweredByCydeoTag = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        actions.moveToElement(poweredByCydeoTag).perform();

        WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));
        actions.moveToElement(homeLink).perform();

    }

}
