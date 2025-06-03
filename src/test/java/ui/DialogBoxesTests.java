package ui;

import configs.TestPropertiesConfig;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.pages.DialogBoxesPage;
import ui.pages.HomePage;

public class DialogBoxesTests extends BaseTest {
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
    void testDialogBoxes() {
        DialogBoxesPage dialogBoxesPage = homePage.openDialogBoxesPage();

        String currentUrl = dialogBoxesPage.getCurrentUrl();
        String title = dialogBoxesPage.getTitle();
        String dialogBoxUrl = dialogBoxesPage.getDialogBoxUrl();


        softly.assertThat(title).isEqualTo("Dialog boxes");
        softly.assertThat(currentUrl).isEqualTo(config.getBaseUrl() + dialogBoxUrl);

        softly.assertAll();
    }

    @Test
    void testAlert() {
        DialogBoxesPage dialogBoxesPage = homePage.openDialogBoxesPage();
        dialogBoxesPage.verifyAlert();
    }
}