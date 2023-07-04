package testsuite;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class GearTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        //Mouse Hover on Gear Menu
        //Click on Bags//
        mouseHover(By.xpath("//span[contains(text(),'Gear')]"), By.xpath("//a[@id='ui-id-25']"));

        //* Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[contains(text(),'Overnight Duffle')]"));


        //* Change Qty 3
        driver.findElement(By.xpath("//input[@id='qty']")).clear();
        Thread.sleep(200);
        sendKeyToElement(By.xpath("//input[@id='qty']"), "3");
        Thread.sleep(500);

        //* Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//span[contains(text(),'Add to Cart')]"));
        Thread.sleep(500);

        /*** Verify the text
         ‘You added Overnight Duffle to your shopping cart.’
         */
        verifyText(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"),
                "You added Overnight Duffle to your shopping cart.");


        //* Click on ‘shopping cart’ Link into message
        mouseHoverAndClickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        //* Verify the Qty is ‘3’
        //  String expectedQuantity = "3";
        //   String actualQuantity = getTextFromElement(By.xpath("//span[contains(text(),'Qty')]"));
        //   Assert.assertEquals("No quantity displayed", expectedQuantity, actualQuantity);

        //* Verify the product price ‘$135.00’

    //    String expectedPrice = "$135.00";
     //   String actualPrice = getTextFromElement(By.xpath("//span[contains(text(),'$135.00')]"));
    //    Assert.assertEquals("Different price displayed", expectedPrice, actualPrice);

        //* Change Qty to ‘5’
        driver.findElement(By.cssSelector("td[class='col qty'] input[class*='input-text qty']")).clear();
        sendKeyToElement(By.cssSelector("td[class='col qty'] input[class*='input-text qty']"), "5");

        //* Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[contains(text(),'Update Shopping Cart')]"));

        //* Verify the product price ‘$225.00’
        verifyText(By.xpath("//span[@class='cart-price']//span[@class='price'][text()='$225.00']"), "$225.00");
    }

}
