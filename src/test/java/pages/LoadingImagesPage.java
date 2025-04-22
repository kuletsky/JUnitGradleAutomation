package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoadingImagesPage extends BasePage {

    @FindBy(id = "landscape")
    private WebElement landscapeImage;

    public LoadingImagesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Wait the Landscape image")
    public String getLandscape() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(landscapeImage));
        return landscapeImage.getDomAttribute("src");
    }
}
