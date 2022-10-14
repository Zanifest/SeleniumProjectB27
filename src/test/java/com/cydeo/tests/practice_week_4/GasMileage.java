package com.cydeo.tests.practice_week_4;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GasMileage extends TestBase {

    /*
    Task #: Gas Mileage Calculator Automation Test

1. Add a new class GasMileageCalculatorTest
2. Go to https://www.calculator.net
3. Search for “gas mileage” using search box
4. Click on the “Gas Mileage Calculator” link
5. On Next page verify:
a. Title equals: “Gas Mileage Calculator”
b. “Gas Mileage Calculator” label is displayed
6. Locate, clear and type “7925” into “Current odometer” field
7. Locate, clear and type “7550” into “Previous odometer” field
8. Locate, clear and type “16” into “Gas added” field
9. Locate, clear and type “3.55” into “Gas price” field
10. Click on Calculate button
11. Verify mpg value is as expected:
Expected value: “23.44 mpg”
     */
    @Test
    public void test1(){
        driver.navigate().to("https://www.calculator.net");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='calcSearchTerm']"));
        searchBox.sendKeys("gas mileage");
        WebElement gasMileageLink = driver.findElement(By.xpath("//a[.='Gas Mileage Calculator']"));
        gasMileageLink.click();

        String expectedTitle = "Gas Mileage Calculator";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        WebElement label = driver.findElement(By.xpath("//h1"));
        System.out.println(label.isDisplayed());

        WebElement currentOdometerBox = driver.findElement(By.xpath("//input[@id='uscodreading']"));
        WebElement previousOdometerBox = driver.findElement(By.xpath("//input[@id='uspodreading']"));
        WebElement gasAddedBox = driver.findElement(By.xpath("//input[@id='usgasputin']"));
        WebElement gasPriceBox = driver.findElement(By.xpath("//input[@id='usgasprice']"));

        currentOdometerBox.clear();
        currentOdometerBox.sendKeys("7925");
        previousOdometerBox.clear();
        previousOdometerBox.sendKeys("7550");
        gasAddedBox.clear();
        gasAddedBox.sendKeys("16");
        gasPriceBox.clear();
        gasPriceBox.sendKeys("3.55");

        WebElement calculate = driver.findElement(By.xpath("//tbody//input[@type='image'][1]"));
        calculate.click();

        WebElement value = driver.findElement(By.xpath("//b[.='23.44 mpg']"));
        String expectedValue = "23.44 mpg";
        String actualValue = value.getText();

        Assert.assertEquals(actualValue, expectedValue);


    }




}
