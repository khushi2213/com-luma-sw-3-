package utilities;


import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class Utility extends BaseTest {

    /**
     * 1. click on element
     */
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    /**
     * 2. get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    /**
     * 3. send key method
     */
    public void sendKeyToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    public void selectByValueFromDropDown(By by, String value) {
        new Select(driver.findElement(by)).selectByValue(value);
    }

    public void selectByIndex(By by, int num) {
        WebElement index = driver.findElement(by);
        Select select = new Select(index);
        select.selectByIndex(num);
    }

    /**
     * 5 Alerts (5 method )
     * 5.1 Alerts method for switch to alert
     */
    public void switchTo(By by) {
        clickOnElement(by);
        driver.switchTo().alert();
    }

    /**
     * 5.2 Alerts method for accept popup
     */
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    /**
     * 5.3 Alerts method for dismiss popup
     */
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    /**
     * 5.4 Alerts method for send key
     */
    public void sendKeyAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    /**
     * 5.5 Alerts method for gettext
     */
    public void getTextAlert() {
        driver.switchTo().alert().getText();
    }

    /**
     * 6. Action ---> mouse hover
     */
    public void mouseHover(By by, By by1) {
        WebElement text1 = driver.findElement(by);
        WebElement text2 = driver.findElement(by1);
        Actions actions = new Actions(driver);
        actions.moveToElement(text1).moveToElement(text2).click().build().perform();
    }

    public void mouseHoverOnElement(By by) {
        WebElement text = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(text).click().build().perform();

    }

    public void mouseHoverActionforThree(By by, By by1, By by3) {
        WebElement text1 = driver.findElement(by);
        WebElement text2 = driver.findElement(by1);
        WebElement text3 = driver.findElement(by3);
        new Actions((driver)).moveToElement(text1).moveToElement(text2).moveToElement(text3).click().build().perform();
    }

    //*
    //    * This method will element verify text
    //    */
    public void verifyText(By by, String expectedText) {
        String actualText = driver.findElement(by).getText();
        Assert.assertEquals("Not match text", expectedText, actualText);
    }


    /*
    This method will mouse hover over any element and click on it
     */
    public void mouseHoverAndClickOnElement(By by) {
        Actions actions = new Actions(driver);
        WebElement text1 = driver.findElement(by);
        actions.moveToElement(text1).click().build().perform();
    }
}