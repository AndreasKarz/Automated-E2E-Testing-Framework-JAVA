package sl.startpage;

import apom.pages.StartPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriverLogLevel;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckTitelsStepDefinitions {

    private static WebDriver driver;

    private static StartPage startPage;

    public static void openApp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setLogLevel(ChromeDriverLogLevel.OFF);
        chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--silent");

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.swisslife.ch/de/private.html");
        driver.manage().window().maximize();
        startPage = new StartPage(driver);
    }

    public static void closeApp(){
        driver.quit();
    }

    @BeforeAll
    public static void beforeAll() {
        openApp();
    }

    @AfterAll
    public static void afterAll() {
        closeApp();
    }

    @Then("Der Titel ist {string}")
    public void derTitelIst(String title) {
        assertEquals(title, driver.getTitle());
    }

    @When("Ich klicke auf {string}")
    public void ichKlickeAuf(String teaserTitle) throws InterruptedException {
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // By addItem = By.cssSelector("[data-teaser-title='"+ teaserTitle + "']");
        // WebElement teaser = wait.until(ExpectedConditions.invisibilityOfAllElements(addItem));
        WebElement teaser = driver.findElement(By.cssSelector("[data-teaser-title='"+ teaserTitle + "']"));
        Actions action = new Actions(driver);
        action.moveToElement(teaser).build().perform();
        teaser.click();
        Thread.sleep(2000);
    }

    @Given("Ich schliesse den Disclaimer")
    public void ichSchliesseDenDisclaimer() {
        startPage.CloseDisclaimer();
    }
}
