package com.cydeo.tests.practice_week_2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T5_ErrorText {
    /*
    TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
3- Enter incorrect username into login box:
4- Click to `Reset password` button
5- Verify “error” label is as expected
Expected: Login or E-mail not found
     */
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.navigate().to("https://login1.nextbasecrm.com/?forgot_password=yes");
        WebElement loginBox = driver.findElement(By.cssSelector("input[name='USER_LOGIN']"));
        loginBox.sendKeys("incorrect");
        WebElement resetPassButton = driver.findElement(By.cssSelector("button[value='Reset password"));
        resetPassButton.click();

        String expectedErrorText = "Login or E-mail not found";
        String actualErrorText = driver.findElement(By.cssSelector("div[class='errortext']")).getText();

        if (actualErrorText.equals(expectedErrorText)){
            System.out.println("Error Text Test Passed!");
        } else {
            System.out.println("Error Text Test Failed!");
        }
        driver.quit();


    }
}
