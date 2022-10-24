package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage_1 {

   public DynamicLoadingPage_1(){
       PageFactory.initElements(Driver.getDriver(), this);
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

    @FindBy (xpath = "//button[.='Start']")
    public WebElement startButton;

    @FindBy (id = "username")
    public WebElement usernameInputBox;

    @FindBy (id = "pwd")
    public WebElement passwordInputBox;

    @FindBy (id = "loading")
    public WebElement loadingBar;

    @FindBy (xpath = "//button[.='Submit']")
    public WebElement submitButton;

    @FindBy (id = "flash")
    public WebElement invalidPasswordTag;


}
