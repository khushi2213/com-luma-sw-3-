package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class WomenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test

    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        //Mouse Hover on Women Menu
        //Mouse Hover on Tops
        // Click on Jackets
        mouseHoverActionforThree(By.xpath("//span[contains(text(),'Women')]"), By.xpath("//li[@class='level1 nav-2-1 category-item first parent ui-menu-item']//span[text()='Tops']"), By.xpath("//li[@class='level2 nav-2-1-1 category-item first ui-menu-item']//span[text()='Jackets']"));

        //Select Sort By filter “Product Name”
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='sorter']"), "Product Name");

        //Verify the products name display in alphabetical order
        Thread.sleep(2000);
        List<WebElement> PRODUCTName = driver.findElements(By.xpath("//strong[@class = 'product name product-item-name']"));
        for (WebElement product :PRODUCTName){
            System.out.println(product.getText());
        }

    }

    @Test
    public void verifyTheSortByPriceFilter() {
        //Mouse Hover on Women Menu
        // Mouse Hover on Tops
        // Click on Jackets
        mouseHoverActionforThree(By.xpath("//span[contains(text(),'Women')]"), By.xpath("//li[@class='level1 nav-2-1 category-item first parent ui-menu-item']//span[text()='Tops']"), By.xpath("//li[@class='level2 nav-2-1-1 category-item first ui-menu-item']//span[text()='Jackets']"));

        //Select Sort By filter “Price”
     selectByVisibleTextFromDropDown(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/select[1]"), "Price");

      //Verify the products price display in Low to High
        List<WebElement> List2 = driver.findElements(By.xpath("//div[@class = 'price-box price-final_price']"));
        for (int i = 0; i < List2.size(); i++) {
            System.out.println(List2.get(i).getText());
            String expected = List2.get(i).getText();
            String actual = List2.get(i).getText();
            Assert.assertEquals("Price not ordered : Low to High  ", expected, actual);
        }
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
