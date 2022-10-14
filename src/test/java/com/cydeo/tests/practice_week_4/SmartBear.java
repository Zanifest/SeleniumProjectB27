package com.cydeo.tests.practice_week_4;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.SmartBearUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SmartBear extends TestBase{
    /*
    TC #1: Smartbear software link verification
1. Open browser
2. Go to website:
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3. Enter username: “Tester”
4. Enter password: “test”
5. Click to Login button
6. Print out count of all the links on landing page
7. Print out each link text on this page
     */

    @Test (priority = 1)
    public void test1(){

        WebElement usernameBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        WebElement logInButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));

        usernameBox.sendKeys("Tester");
        passwordBox.sendKeys("test");
        logInButton.click();

        List<WebElement> allWebTableElm = driver.findElements(By.xpath("//tbody//tbody//td"));
        int numOfElms = allWebTableElm.size();

        for (WebElement each : allWebTableElm) {
            System.out.println(each.getText());
        }

        List<WebElement> namesElm = driver.findElements(By.xpath("//tbody//tbody//td[2]"));
        List<String> names = new ArrayList<>();

        for (WebElement each : namesElm) {
            names.add(each.getText());
        }

        System.out.println(names);
    }
    /*
    TC#2: Smartbear software order placing
1. Open browser
2. Go to website:
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3. Enter username: “Tester”
4. Enter password: “test”
5. Click on Login button
6. Click on Order
7. Select familyAlbum from product, set quantity to 2
8. Click to “Calculate” button
9. Fill address Info with JavaFaker
• Generate: name, street, city, state, zip code
10. Click on “visa” radio button
11. Generate card number using JavaFaker
12. Click on “Process”
13. Verify success message “New order has been successfully added.”
     */

    @Test (priority = 2)
    public void test2(){

        driver.navigate().to("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        WebElement usernameBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        WebElement logInButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));

        usernameBox.sendKeys("Tester");
        passwordBox.sendKeys("test");
        logInButton.click();

        WebElement orderTab = driver.findElement(By.xpath("//a[@href='Process.aspx']"));

        orderTab.click();

        WebElement productDropdown = driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
        Select selectProductDropdown = new Select(productDropdown);
        WebElement quantityBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        selectProductDropdown.selectByValue("FamilyAlbum");

        quantityBox.sendKeys("2");

        WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));

    }


}
