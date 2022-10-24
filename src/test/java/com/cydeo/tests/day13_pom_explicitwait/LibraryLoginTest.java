package com.cydeo.tests.day13_pom_explicitwait;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LibraryLoginTest {



    /*
   TC #1: Required field error message test
1- Open a chrome browser
2- Go to: https://library1.cydeo.com/
3- Do not enter any information
4- Click to “Sign in” button
5- Verify expected error is displayed:
Expected: This field is required.
     */
    LibraryLoginPage libraryLoginPage;
    Faker faker;
    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("library.app.url"));
        libraryLoginPage = new LibraryLoginPage();
        faker = new Faker();
    }

    @Test
    public void required_field_error_msg_test(){
        libraryLoginPage.signInButton.click();
        Assert.assertTrue(libraryLoginPage.fieldRequiredErrorMsg.isDisplayed());

    }

    /*
    TC #2: Invalid email format error message test
1- Open a chrome browser
2- Go to: https://library1.cydeo.com/
3- Enter invalid email format
4- Verify expected error is displayed:
Expected: Please enter a valid email address.
     */

    @Test
    public void invalid_email_format_error(){

        libraryLoginPage.inputUsername.sendKeys("asfasaddfadsfdsa");

        libraryLoginPage.signInButton.click();
        Assert.assertTrue(libraryLoginPage.enterInvalidEmailErrorMsg.isDisplayed());

    }

    /*
    TC #3: Library negative login
1- Open a chrome browser
2- Go to: https://library1.cydeo.com
3- Enter incorrect username or incorrect password
4- Verify title expected error is displayed:
Expected: Sorry, Wrong Email or Password
     */
    @Test
    public void T3(){

        libraryLoginPage.inputUsername.sendKeys("something");

        libraryLoginPage.signInButton.click();
        Assert.assertTrue(libraryLoginPage.enterInvalidEmailErrorMsg.isDisplayed());

    }

    @Test
    public void library_negative_login_test(){
        libraryLoginPage.inputUsername.sendKeys("wrong@email.com");
        libraryLoginPage.inputPassword.sendKeys("wrongpassword");
        libraryLoginPage.signInButton.click();

        Assert.assertEquals(libraryLoginPage.wrongEmailAndPasswordErrorMsg.getText(), "Sorry, Wrong Email or Password");

    }

    @Test
    public void library_positive_login_test(){
        libraryLoginPage.inputUsername.sendKeys(ConfigurationReader.getProperty("library.app.username"));
        libraryLoginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("library.app.password"));
        libraryLoginPage.signInButton.click();

    }



    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
