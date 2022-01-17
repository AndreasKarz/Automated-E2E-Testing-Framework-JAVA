package apom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPage extends Page {
    public StartPage(WebDriver driver) {
        super(driver);
    }

    public void CloseDisclaimer(){
        driver.findElement(By.className("ot-close-icon")).click();
    }

}
