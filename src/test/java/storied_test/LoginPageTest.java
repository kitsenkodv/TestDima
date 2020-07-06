package storied_test;

import storied.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeTest
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Дима\\IdeaProjects\\test-selenium\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://stage.storied.co/auth/login");
        loginPage = new LoginPage(driver);
    }


    @Test (dataProvider = "LoginDateProvider", dataProviderClass = LoginDateProviderClass.class)
    public void registerFailTest (String email, String password, String errormessage) {
        driver.get("https://stage.storied.co/auth/login");
        loginPage.signIn(email, password);
        String error = loginPage.getErrorText();
        Assert.assertEquals(errormessage, error);
    }

    @AfterTest
    public void tearDown () {
        driver.quit();
    }

}
