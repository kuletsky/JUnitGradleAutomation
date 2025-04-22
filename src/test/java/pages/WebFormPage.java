package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebFormPage extends BasePage {
    private static final String WEB_FORM_URL = "web-form.html";

    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement submitButton;

    private String title;
    private String currentUrl;

    public WebFormPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get subpage url")
    public String getFormUrl() {
        return WEB_FORM_URL;
    }

    @Step("Submit form")
    public void submitForm() {
        submitButton.click();
    }
}
