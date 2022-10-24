package com.cydeo.tests.day12_actions_javascriptexecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Circle_Drag_And_Drop {

    /*
    1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
2. Drag and drop the small circle to bigger circle.
3. Assert:
-Text in big circle changed to: “You did great!”

     */
    @Test
    public void drag_and_drop_test(){
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index ");
        Actions actions = new Actions(Driver.getDriver());

        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement targetArea = Driver.getDriver().findElement(By.id("droptarget"));

        // perform the same out outcome
//      actions.dragAndDrop(smallCircle, targetArea).perform();
        actions.clickAndHold(smallCircle).moveToElement(targetArea).release().perform();

        WebElement cookiesAccept = Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler"));
        cookiesAccept.click();

        String actualTargetAreaText = targetArea.getText();
        String expectedTargetAreaText = "You did great!";

        Assert.assertEquals(actualTargetAreaText, expectedTargetAreaText);

        Driver.closeDriver();

    }
}
