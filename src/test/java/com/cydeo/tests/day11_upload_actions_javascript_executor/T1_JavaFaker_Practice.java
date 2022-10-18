package com.cydeo.tests.day11_upload_actions_javascript_executor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class T1_JavaFaker_Practice {

    /*
    TC#1: Registration form confirmation
Note: Use JavaFaker OR read from configuration.properties file when possible.

1. Open browser
2. Go to website: https://practice.cydeo.com/registration_form
3. Enter first name
4. Enter last name
5. Enter username
6. Enter email address
7. Enter password
8. Enter phone number
9. Select a gender from radio buttons
10. Enter date of birth


     */

    @Test
    public void T1(){
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));

        Faker faker = new Faker();

        WebElement firstNameBox = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        firstNameBox.sendKeys(faker.name().firstName());

        WebElement lastNameBox = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        lastNameBox.sendKeys(faker.name().lastName());

        WebElement usernameBox = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        usernameBox.sendKeys(faker.name().username().replace(".", ""));

        WebElement emailBox = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        emailBox.sendKeys(faker.name().username() + "@gmail.com");

        WebElement passwordBox = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        passwordBox.sendKeys(faker.bothify("???##?##"));

        WebElement phoneNumBox = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phoneNumBox.sendKeys(faker.numerify("###-###-####"));

        List<WebElement> genders = Driver.getDriver().findElements(By.xpath("//input[@type='radio']"));
        genders.get(faker.number().numberBetween(0,2)).click();

        WebElement DOB = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));

        DOB.sendKeys("12/13/1997");

        /*
        11. Select Department/Office
12. Select Job Title
13. Select programming language from checkboxes
14. Click to sign up button
15. Verify success message “You’ve successfully completed registration.” is
displayed.
         */
        // Preferred way
//        Select departments = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));

        List<WebElement> departments = Driver.getDriver().findElements(By.xpath("//select[@name='department']//option"));
        departments.get(faker.number().numberBetween(1,9)).click();

        List<WebElement> jobTitles = Driver.getDriver().findElements(By.xpath("//select[@name='job_title']//option"));
        jobTitles.get(faker.number().numberBetween(1,8)).click();

        List<WebElement> programmingLanguages = Driver.getDriver().findElements(By.xpath("//input[@type='checkbox']"));
        programmingLanguages.get(faker.number().numberBetween(0,2)).click();

        WebElement signUpBtn = Driver.getDriver().findElement(By.id("wooden_spoon"));
        signUpBtn.click();

        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//div[@id='content']//p"));
        Assert.assertTrue(successMessage.isDisplayed());

        Driver.closeDriver();
    }
}
