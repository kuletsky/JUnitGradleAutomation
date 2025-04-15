package ui;

import configs.TestPropertiesConfig;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoadingImagesPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoadingImagesTest extends BaseTest {

    @Test
    void verifyLoadingAllImages() {
        HomePage homePage = new HomePage(driver);
        TestPropertiesConfig config = homePage.config;

        LoadingImagesPage loadingImagesPage = homePage.openLoadingImagesPage();
        loadingImagesPage.getLandscape();
        assertTrue(loadingImagesPage.getLandscape().contains("landscape"),
                "The image source does not contain 'landscape'");
    }
}
