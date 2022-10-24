package com.cydeo.tests.practice_week_5;

import com.cydeo.pages.W3_SchoolsPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class W3_SchoolsPageTest {

    /*
    TC #1: Double Click Test
1. Go to
https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblcli
ck2
2. Switch to iframe.
3. Double click on the text “Double-click me to change my text color.”
4. Assert: Text’s “style” attribute value contains “red”.
     */
    W3_SchoolsPage w3_schoolsPage;
    WebDriverWait wait;
    @Test
    public void test(){
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        w3_schoolsPage = new W3_SchoolsPage();
        Actions actions = new Actions(Driver.getDriver());

        Driver.getDriver().switchTo().frame(w3_schoolsPage.iframe);
        actions.doubleClick(w3_schoolsPage.doubleClickMeText).perform();

        Assert.assertTrue(w3_schoolsPage.doubleClickMeText.getAttribute("style").contains("red"));

    }
}
