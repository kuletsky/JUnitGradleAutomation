package ui;

import configs.TestPropertiesConfig;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.WebFormPage;

import static org.assertj.core.api.Assertions.assertThat;
import org.assertj.core.api.SoftAssertions;


@Feature("POM")
public class WebFormTests extends BaseTest {
    HomePage homePage;
    SoftAssertions softly;
    TestPropertiesConfig config;

    @BeforeEach
    void setupPage() {
        homePage = new HomePage(driver);
        softly = new SoftAssertions();
        config = homePage.config;
    }

    @Test
    void testOpenWebForm() {
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
        WebFormPage webFormPage = homePage.openWebFormPage();

        webFormPage.submitForm();
    }
}
