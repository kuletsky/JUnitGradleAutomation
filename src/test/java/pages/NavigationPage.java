package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationPage extends BasePage {
    private static final String NAVIGATION_URL = "navigation1.html";

    @FindBy(linkText = "Next")
    private WebElement nextButton;

    public NavigationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get subpage url")
    public String getNavigationUrl() {
        return NAVIGATION_URL;
    }

    @Step("Navigate to Dialog Box")
    public void navigateToDB() {
        driver.navigate().to("https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
    }

    @Step("Navigate back")
    public void navigateBack() {
        driver.navigate().back();
    }

    @Step("Click next button")
    public NavigationPage clickNextButton() {
        nextButton.click();

        return this;
    }
}
