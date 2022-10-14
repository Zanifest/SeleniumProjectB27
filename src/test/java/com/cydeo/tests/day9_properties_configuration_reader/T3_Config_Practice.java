package com.cydeo.tests.day9_properties_configuration_reader;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T3_Config_Practice extends TestBase {

    /*
    1- Open a chrome browser
2- Go to: https://google.com/
3- Write “apple” in search box
 4- Verify title:
Expected: apple - Google Search
     */

    @Test
    public void google_search_test_using_properties(){
//        driver.navigate().to("google.url");
        driver.navigate().to(ConfigurationReader.getProperty("google.url"));
        WebElement searchBox = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        searchBox.sendKeys( ConfigurationReader.getProperty("search.keyword")+ Keys.ENTER);
        BrowserUtils.verifyTitle(driver, "toyota - Google Search");
    }

}
