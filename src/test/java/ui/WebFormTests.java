package ui;

import configs.TestPropertiesConfig;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.pages.HomePage;
import ui.pages.WebFormPage;

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
        String title = webFormPage.getTitle();
        String webFormUrl = webFormPage.getFormUrl();

        softly.assertThat(title).isEqualTo("Web form");
        softly.assertThat(currentUrl).isEqualTo(config.getBaseUrl() + webFormUrl);

        softly.assertAll();
    }

    @Test
    void testSubmitForm() {
        WebFormPage webFormPage = homePage.openWebFormPage();

        webFormPage.submitForm();
    }
}
