package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebFormPage extends BasePage {
    private static final String WEB_FORM_URL = "web-form.html";

    //Locators
    WebElement submitButton = driver.findElement(By.xpath("//button[@type = 'submit']"));

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
