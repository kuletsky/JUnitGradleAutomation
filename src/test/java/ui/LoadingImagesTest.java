package ui;

import configs.TestPropertiesConfig;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoadingImagesPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoadingImagesTest extends BaseTest {
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
    void verifyLoadingAllImages() {
        LoadingImagesPage loadingImagesPage = homePage.openLoadingImagesPage();
        loadingImagesPage.getLandscape();
        assertTrue(loadingImagesPage.getLandscape().contains("landscape"),
                "The image source does not contain 'landscape'");
    }
}
