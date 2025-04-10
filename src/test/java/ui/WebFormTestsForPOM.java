package ui;

import configs.TestPropertiesConfig;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.WebFormPage;

import static org.assertj.core.api.Assertions.assertThat;
import org.assertj.core.api.SoftAssertions;


@Feature("POM")
public class WebFormTestsForPOM extends BaseTestForPOM {
    SoftAssertions softly = new SoftAssertions();

    @Test
    void testOpenWebForm() {
        HomePage homePage = new HomePage(driver);
        TestPropertiesConfig config = homePage.config;
        WebFormPage webFormPage = homePage.openWebFormPage();

        String currentUrl = webFormPage.getCurrentUrl();
        WebElement title = webFormPage.getTitle();
        String webFormUrl = webFormPage.getFormUrl();

        softly.assertThat(title.getText()).isEqualTo("Web form");
        softly.assertThat(currentUrl).isEqualTo(config.getBaseUrl() + webFormUrl);

        softly.assertAll();
    }

    @Test
    void testSubmitForm() {
        HomePage homePage = new HomePage(driver);
        TestPropertiesConfig config = homePage.config;
        WebFormPage webFormPage = homePage.openWebFormPage();

        webFormPage.submitForm();
    }
}
