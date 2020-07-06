package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addToCart_btn = By.xpath(".//a[@title = 'Add to cart']");

    public MainPage selectProduct(int indexProduct) {
        Actions builder = new Actions(driver);
        WebElement productContainer = driver.findElement(By.xpath("//ul[@id='homefeatured']/li["+ indexProduct +"]"));
        WebElement addToCartContainer_btn = productContainer.findElement(addToCart_btn);
        builder.moveToElement(productContainer).click(addToCartContainer_btn).build().perform();
        return this;
    }


}
