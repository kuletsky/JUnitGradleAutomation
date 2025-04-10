package ui;

import configs.TestPropertiesConfig;
import io.qameta.allure.Feature;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.NavigationPage;
import pages.WebFormPage;


@Feature("POM")
public class NavigationTestsForPOM extends BaseTestForPOM {
    SoftAssertions softly = new SoftAssertions();

    @Test
    void testOpenNavigationPage() {
        HomePage homePage = new HomePage(driver);
        TestPropertiesConfig config = homePage.config;

        NavigationPage navigationPage = homePage.openNavigationPage();
        String currentUrl = navigationPage.getCurrentUrl();
        WebElement title = navigationPage.getTitle();
        String webFormUrl = navigationPage.getFormUrl();

        softly.assertThat(title.getText()).isEqualTo("Navigation example");
        softly.assertThat(currentUrl).isEqualTo(config.getBaseUrl() + webFormUrl);

        softly.assertAll();
    }
}
