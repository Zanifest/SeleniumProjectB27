package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class W3_SchoolsPage {

    /*
    TC #1: Double Click Test
1. Go to
https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblcli
ck2
2. Switch to iframe.
3. Double click on the text “Double-click me to change my text color.”
4. Assert: Text’s “style” attribute value contains “red”.
     */

    public W3_SchoolsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "iframeResult")
    public WebElement iframe;

    @FindBy (id = "demo")
    public WebElement doubleClickMeText;

}
