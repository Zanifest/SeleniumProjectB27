package com.cydeo.tests.day9_properties_configuration_reader;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_CRM_Login extends TestBase {
    /*
    1. Create new test and make set ups
2. Go to : http://login1.nextbasecrm.com/
3. Enter valid username
4. Enter valid password
5. Click to Log In button
6. Verify title is as expected:
Expected: Portal
     */

    @Test (priority = 1)
    public void crm_login(){
        driver.navigate().to("http://login1.nextbasecrm.com/");
        WebElement usernameBox = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        WebElement passwordBox = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        usernameBox.sendKeys("hr1@cydeo.com");
        passwordBox.sendKeys("UserUser");

        loginButton.click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Portal";

        Assert.assertEquals(actualTitle, expectedTitle);

    }
    @Test (priority = 2)
    public void crm_login_test_2(){
        driver.navigate().to("http://login1.nextbasecrm.com/");
        CRM_Utilities.login_crm(driver);
        BrowserUtils.verifyTitle(driver,"Portal");
    }
    @Test (priority = 3)
    public void crm_login_test_3(){
        driver.navigate().to("http://login1.nextbasecrm.com/");
        CRM_Utilities.login_crm(driver, "hr2@cydeo.com", "UserUser");
        BrowserUtils.sleep(3);
        BrowserUtils.verifyTitle(driver, "Portal");
    }

}
