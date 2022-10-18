package com.cydeo.tests.day11_upload_actions_javascript_executor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Guru99_Upload_Test {
    /*
    1. Go to  “http://demo.guru99.com/test/upload”
2. Upload file into Choose File
3. Click terms of servide check box
4. Click Submit File button
5. Verify expected message appeared. Expected:
“1 file
has been successfully uploaded.”
     */

    @Test
    public void upload(){
        Driver.getDriver().get(ConfigurationReader.getProperty("upload.url"));

        WebElement chooseFile = Driver.getDriver().findElement(By.xpath("//input[@name='uploadfile_0']"));
        chooseFile.sendKeys("C:\\Users\\zanya\\Downloads\\textfile.txt");

        WebElement acceptTermsBox = Driver.getDriver().findElement(By.id("terms"));
        acceptTermsBox.click();

        WebElement submitBtn = Driver.getDriver().findElement(By.id("submitbutton"));
        submitBtn.click();

        WebElement message = Driver.getDriver().findElement(By.id("res"));

        String actualMessage = message.getText();
        String expectedMessage = "1 file\nhas been successfully uploaded.";

        Assert.assertEquals(actualMessage, expectedMessage);
    }

}
