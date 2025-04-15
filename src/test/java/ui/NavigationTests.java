package ui;

import configs.TestPropertiesConfig;
import io.qameta.allure.Feature;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.NavigationPage;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Feature("POM")
public class NavigationTests extends BaseTest {
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
    void testOpenNavigationPage() {
        NavigationPage navigationPage = homePage.openNavigationPage();
        String currentUrl = navigationPage.getCurrentUrl();

        WebElement navigationTitle = navigationPage.getTitle();
        String navigationUrl = navigationPage.getNavigationUrl();

        softly.assertThat(navigationTitle.getText()).isEqualTo("Navigation example");
        softly.assertThat(currentUrl).isEqualTo(config.getBaseUrl() + navigationUrl);

        softly.assertAll();
    }

    @Test
    void testNavigate() {
        NavigationPage navigationPage = homePage.openNavigationPage();

        navigationPage.navigateToDB();
        navigationPage.navigateBack();

        assertEquals("https://bonigarcia.dev/selenium-webdriver-java/navigation1.html", navigationPage.getCurrentUrl());
    }
}