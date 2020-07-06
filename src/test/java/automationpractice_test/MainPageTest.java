package automationpractice_test;


import automationpractice.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeTest
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Дима\\IdeaProjects\\test-selenium\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        mainPage = new MainPage(driver);
    }

    @Test
    public void addToCart () {
        mainPage.selectProduct(3);
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("layer_cart")));

        //WebElement explicitWait = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("layer_cart")));
    }

//    @AfterTest
//    public void tearDown () {
//        driver.quit();
//    }

}