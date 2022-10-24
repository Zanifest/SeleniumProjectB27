package com.cydeo.tests.day13_pom_explicitwait;

import com.cydeo.pages.DynamicLoadingPage_1;
import com.cydeo.pages.DynamicallyLoadedPage_7;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitPractices {

    /*
TC#4 : Dynamically Loaded Page Elements 7
1. Go to https://practice.cydeo.com/dynamic_loading/7
2. Wait until title is “Dynamic title”
3. Assert: Message “Done” is displayed.
4. Assert: Image is displayed.
 */

    public DynamicallyLoadedPage_7 dynamicallyLoadedPage_7;
    public DynamicLoadingPage_1 dynamicLoadingPage_1;

    @Test
    public void dynamically_loaded_page_elements_7_tests(){
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");
        dynamicallyLoadedPage_7 = new DynamicallyLoadedPage_7();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        Assert.assertTrue(dynamicallyLoadedPage_7.doneMessage.isDisplayed());
        Assert.assertTrue(dynamicallyLoadedPage_7.spongeBobImage.isDisplayed());

    }

    /*
   TC#5 : Dynamically Loaded Page Elements 1
1. Go to https://practice.cydeo.com/dynamic_loading/1
2. Click to start
3. Wait until loading bar disappears
4. Assert username inputbox is displayed
5. Enter username: tomsmith
6. Enter password: incorrectpassword
7. Click to Submit button
8. Assert “Your password is invalid!” text is displayed.
    */
    @Test
    public void dynamic_loading_page_1_test(){
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/1");
        dynamicLoadingPage_1 = new DynamicLoadingPage_1();

        dynamicLoadingPage_1.startButton.click();

        BrowserUtils.waitForInvisibilityOf(dynamicLoadingPage_1.loadingBar);

        Assert.assertTrue(dynamicLoadingPage_1.usernameInputBox.isDisplayed());
        dynamicLoadingPage_1.usernameInputBox.sendKeys("tomsmith");
        dynamicLoadingPage_1.passwordInputBox.sendKeys("incorrectpassword");

        dynamicLoadingPage_1.submitButton.click();

        Assert.assertTrue(dynamicLoadingPage_1.invalidPasswordTag.isDisplayed());
    }

}
