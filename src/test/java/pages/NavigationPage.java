package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class NavigationPage extends BasePage {
    private static final String NAVIGATION_URL = "navigation1.html";

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
}
