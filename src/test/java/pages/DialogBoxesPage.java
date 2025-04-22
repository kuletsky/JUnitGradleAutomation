package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DialogBoxesPage extends BasePage {
    private static final String DIALOGBOX_URL = "dialog-boxes.html";

    @FindBy(id = "my-alert")
    private WebElement alert;

    public DialogBoxesPage(WebDriver driver) {
        super(driver);
    }

//    By alert = By.id("my-alert");

    @Step("Get subpage url")
    public String getDialogBoxUrl() {
        return DIALOGBOX_URL;
    }

    @Step("Verify alert")
    public void verifyAlert() {
        alert.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        assertEquals("Hello world!", alert .getText());
        alert.accept();
    }
}