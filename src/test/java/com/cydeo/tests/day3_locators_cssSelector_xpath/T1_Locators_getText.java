package com.cydeo.tests.day3_locators_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_Locators_getText {

    /*
    1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Enter incorrect username: “incorrect”
4- Enter incorrect password: “incorrect”
5- Click to login button.
6- Verify error message text is as expected:
Expected: Incorrect login or password
     */
    public static void main(String[] args) {

//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.navigate().to("https://login1.nextbasecrm.com/");

        WebElement loginBox = driver.findElement(By.name("USER_LOGIN"));
        WebElement passwordBox = driver.findElement(By.name("USER_PASSWORD"));

        loginBox.sendKeys("incorrect");
        passwordBox.sendKeys("incorrect");

        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        loginBtn.click();

        String expectedErrorText = "Incorrect login or password";
        String actualErrorText = driver.findElement(By.className("errortext")).getText();

        if (actualErrorText.equals(expectedErrorText)){
            System.out.println("Error Text Test PASSED!");
        } else {
            System.out.println("Error Text Test FAILED!");
        }

        driver.quit();




    }
}
