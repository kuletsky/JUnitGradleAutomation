package pages;

import configs.TestPropertiesConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {
    public TestPropertiesConfig config = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());

    public HomePage(WebDriver driver) {
        super(driver);
        open();
    }

    //locators
    By webTitle = By.className("display-4");
    By chapters = By.cssSelector(".card h5");
    By webLinks = By.cssSelector(".card a");

    //actions
    @Step("Open Homepage")
    private void open() {
        driver.get(config.getBaseUrl());
    }

    @Step("Get title")
    public WebElement getTitle() {
        return driver.findElement(webTitle);
    }

    @Step("Open Web form page")
    public WebFormPage openWebFormPage() {
        driver.findElement(By.linkText("Web form")).click();
        return new WebFormPage(driver);
    }

    @Step("Open Navigation page")
    public NavigationPage openNavigationPage() {
        driver.findElement(By.linkText("Navigation")).click();
        return new NavigationPage(driver);
    }

    @Step("Get a List of chapters on the Main Page")
    public List<WebElement> getListOfChapters() {
        return driver.findElements(chapters);
    }

    @Step("Get a List of links on the Main Page")
    public List<WebElement> getListOfLinks() {
        return driver.findElements(webLinks);
    }

    @Step("Click on all links on the Main page")
    public void clickAllLinks() {
        List<WebElement> links = getListOfLinks();

        for (WebElement link: links) {
            link.click();
            driver.navigate().back();
        }
    }
}
