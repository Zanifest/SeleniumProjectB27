package com.cydeo.tests.practice_week_4;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginScenarioCRM extends TestBase {

    /*
    Do task 1 with using ConfigurationReader class:
TC #1: Login scenario

1. Create new test and make set ups
2. Go to : http://login1.nextbasecrm.com/
3. Enter valid username
4. Enter valid password
5. Click to Log In button
6. Verify title is as expected:
Expected: Portal
     */
    @Test
    public void test1(){
        driver.navigate().to(ConfigurationReader.getProperty("env"));
        CRM_Utilities.login_crm(driver, ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        BrowserUtils.verifyTitle(driver, "Portal");

    }
}
