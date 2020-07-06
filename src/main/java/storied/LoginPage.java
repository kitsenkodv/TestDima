package storied;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userEmailField = By.xpath("//*[@id='login']");
    private By passwordField = By.xpath("//*[@id='password']");
    private By signInButton = By.xpath("//button[text()='Sign in']");
    private By error = By.xpath("//div[@class='error']/p");

    public LoginPage clickSignInButton () {
        driver.findElement(signInButton).click();
        return this;
    }

    public LoginPage typeEmail (String email) {
        driver.findElement(userEmailField).sendKeys(email);
        return this;
    }

    public LoginPage typePassword (String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage signIn (String email, String password) {
        this.typeEmail(email);
        this.typePassword(password);
        this.clickSignInButton();
        return this;
    }

    public String getErrorText () {
        return driver.findElement(error).getText();
    }

}
