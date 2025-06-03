package ui;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import ui.pages.HomePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Feature("POM")
class HomePageTest extends BaseTest {
    HomePage homePage;

    @BeforeEach
    void setupPage() {
        homePage = new HomePage(driver);
    }

    @Test
    void testOpenHomePage() {
        String actualTitle = homePage.getTitle();

        assertEquals("Hands-On Selenium WebDriver with Java", actualTitle);
    }

    @Test
    @DisplayName("Open all links")
    void testOpenAllLinks() {
        assertEquals(6, homePage.getListOfChapters().size());
        assertEquals(27, homePage.getListOfLinks().size());
    }

    @Test
    @DisplayName("Click through all links on the homepage")
    void testClickAllLinks() {
        homePage.clickAllLinks(); // separate test for action
    }
}