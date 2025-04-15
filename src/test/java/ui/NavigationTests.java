package ui;

import configs.TestPropertiesConfig;
import io.qameta.allure.Feature;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.NavigationPage;


@Feature("POM")
public class NavigationTests extends BaseTest {
    SoftAssertions softly = new SoftAssertions();

    @Test
    void testOpenNavigationPage() {
        HomePage homePage = new HomePage(driver);
        TestPropertiesConfig config = homePage.config;

        NavigationPage navigationPage = homePage.openNavigationPage();
        String currentUrl = navigationPage.getCurrentUrl();

        WebElement navigationTitle = navigationPage.getTitle();
        String navigationUrl = navigationPage.getNavigationUrl();

        softly.assertThat(navigationTitle.getText()).isEqualTo("Navigation example");
        softly.assertThat(currentUrl).isEqualTo(config.getBaseUrl() + navigationUrl);

        softly.assertAll();
    }
}
