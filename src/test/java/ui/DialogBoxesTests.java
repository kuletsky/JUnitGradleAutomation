package ui;

import configs.TestPropertiesConfig;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.DialogBoxesPage;
import pages.HomePage;
import pages.WebFormPage;

public class DialogBoxesTests extends BaseTest {
    SoftAssertions softly = new SoftAssertions();

    @Test
    void testDialogBoxes() {
        HomePage homePage = new HomePage(driver);
        TestPropertiesConfig config = homePage.config;
        DialogBoxesPage dialogBoxesPage = homePage.openDialogBoxesPage();

        String currentUrl = dialogBoxesPage.getCurrentUrl();
        WebElement title = dialogBoxesPage.getTitle();
        String dialogBoxUrl = dialogBoxesPage.getDialogBoxUrl();

        softly.assertThat(title.getText()).isEqualTo("Dialog boxes");
        softly.assertThat(currentUrl).isEqualTo(config.getBaseUrl() + dialogBoxUrl);

        softly.assertAll();
    }

    @Test
    void testAlert() {
        HomePage homePage = new HomePage(driver);
        TestPropertiesConfig config = homePage.config;
        DialogBoxesPage dialogBoxesPage = homePage.openDialogBoxesPage();

        dialogBoxesPage.verifyAlert();
    }
}