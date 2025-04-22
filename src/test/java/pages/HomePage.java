package pages;

import configs.TestPropertiesConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.DialogBoxesTests;

import java.util.Collections;
import java.util.List;

public class HomePage extends BasePage {
    public TestPropertiesConfig config = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());

    @FindBy(className = "display-4")
    private WebElement webTitle;

    @FindBy(css = ".card h5")
    private List<WebElement> chapters;

    @FindBy(css = ".card a")
    private List<WebElement> webLinks;

    public HomePage(WebDriver driver) {
        super(driver);
        open();
    }

    //locators
//    By webTitle = By.className("display-4");
//    By chapters = By.cssSelector(".card h5");
//    By webLinks = By.cssSelector(".card a");

    //actions
    @Step("Open Homepage")
    private void open() {
        driver.get(config.getBaseUrl());
    }

    @Step("Get title")
    public String getTitle() {
        return webTitle.getText();
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

    @Step("Open Navigation page")
    public LoadingImagesPage openLoadingImagesPage() {
        driver.findElement(By.linkText("Loading images")).click();
        return new LoadingImagesPage(driver);
    }

    @Step("Open Dialog Boxes page")
    public DialogBoxesPage openDialogBoxesPage() {
        driver.findElement(By.linkText("Dialog boxes")).click();
        return new DialogBoxesPage(driver);
    }

    @Step("Get a List of chapters on the Main Page")
    public List<WebElement> getListOfChapters() {
        return chapters;
    }

    @Step("Get a List of links on the Main Page")
    public List<WebElement> getListOfLinks() {
        return webLinks;
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
