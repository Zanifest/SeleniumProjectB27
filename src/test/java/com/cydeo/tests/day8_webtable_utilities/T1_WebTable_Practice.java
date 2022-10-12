package com.cydeo.tests.day8_webtable_utilities;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class T1_WebTable_Practice extends TestBase {
    /*
    1. Go to: https://practice.cydeo.com/web-tables
2. Verify Bob’s name is listed as expected.
Expected: “Bob Martin”
3. Verify Bob Martin’s order date is as expected
Expected: 12/31/2021
     */
//    WebDriver driver;
//
//    @BeforeClass
//    public void setup(){
//       driver = WebDriverFactory.getDriver("chrome");
//       driver.manage().window().maximize();
//       driver.navigate().to("https://practice.cydeo.com/web-tables");
//       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    }

    @Test
    public void test1(){
        WebElement bobMartinName = driver.findElement(By.xpath("//table[@id = 'ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));
        String actualBobMartin = bobMartinName.getText();
        String expectedBobMartin = "Bob Martin";
        System.out.println("bobMartinName.isDisplayed() = " + bobMartinName.isDisplayed());
        Assert.assertEquals(actualBobMartin, expectedBobMartin);

        WebElement bobMartinOrderDate = driver.findElement(By.xpath("//td[.='Bob Martin']/following-sibling::td[3]"));
        String actualOrderDate = bobMartinOrderDate.getText();
        String expectedOrderDate = "12/31/2021";

        Assert.assertEquals(actualOrderDate, expectedOrderDate);

    }

    @Test
    public void test2(){

        String customerOrderDate1 = WebTableUtils.returnOrderDate(driver, "Alexandra Gray");
        System.out.println(customerOrderDate1);
    }

    @Test
    public void test3(){

        WebTableUtils.orderVerify(driver, "Ned Stark", "05/12/2021");

    }


//    @AfterClass
//    public void tearDown(){
//        BrowserUtils.sleep(3);
//        driver.quit();
//    }

}
