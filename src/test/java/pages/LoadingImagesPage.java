package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoadingImagesPage extends BasePage {

    public LoadingImagesPage(WebDriver driver) {
        super(driver);
    }

    public String getLandscape() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String landscape;
        landscape = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("landscape")))
                .getDomAttribute("src");
        return landscape;
    }
}
