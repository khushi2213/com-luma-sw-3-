package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test

    public void userShouldAddProductSuccessFullyToShoppingCart() {

        // Mouse Hover on Men Menu
        //* Mouse Hover on Bottoms
        mouseHoverOnElement(By.linkText("Men"));

        //Mouse Hover on Bottoms
        mouseHoverOnElement(By.linkText("Bottoms"));

        //Click on Pants
       mouseHoverAndClickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[3]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[1]"));

        /* * Mouse Hover on product name
         * ‘Cronus Yoga Pant’ and click on size
         */
        mouseHoverOnElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
        clickOnElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));


        /** Mouse Hover on product name
         ‘Cronus Yoga Pant’ and click on colour
         Black.*/
        mouseHoverOnElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
       clickOnElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));

        /** Mouse Hover on product name
         ‘Cronus Yoga Pant’ and click on
         ‘Add To Cart’ Button.*/
        mouseHoverOnElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
       clickOnElement(By.xpath("/li[1]//div[1]//div[1]//div[3]//div[1]//div[1]//form[1]//button[1]//span[1]"));

        /** Verify the text
         *   'You added Cronus Yoga Pant to your shopping cart.'
         */
        verifyText(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"),
                "You added Cronus Yoga Pant to your shopping cart.");

        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));


        //Verify the text ‘Shopping Cart.’

        String expectedText = "Shopping Cart";
        String actualText = getTextFromElement(By.xpath("//span[@class='base']"));
        Assert.assertEquals("Message not displayed", expectedText, actualText);

        //* Verify the product name ‘Cronus Yoga Pant’
        String expectedName = "Cronus Yoga Pant";
        String actualName = getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));
        Assert.assertEquals("Name not displayed", expectedName, actualName);


        //* Verify the product size ‘32’
        String expectedSize = "size '32'";
        String actualSize = getTextFromElement(By.xpath("//dd[contains(text(),'32')]"));
        Assert.assertEquals("Size is different", expectedSize, actualSize);


        //* Verify the product colour ‘Black’
        String expectedColour = "Black";
        String actualColour = getTextFromElement(By.xpath("//dd[contains(text(),'Black')]"));
        Assert.assertEquals("Colour is different", expectedSize, actualSize);
    }
}
