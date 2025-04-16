package ui;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import pages.HomePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

@Feature("POM")
class HomePageTest extends BaseTest {
    HomePage homePage;

    @BeforeEach
    void setupPage() {
        homePage = new HomePage(driver);
    }

    @Test
    void testOpenHomePage() {
        WebElement actualTitle = homePage.getTitle();

        assertEquals("Hands-On Selenium WebDriver with Java", actualTitle.getText());
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
//    @Test
//    void testLoadingImageExplicitWait() {
//        driver.get(config.getBaseUrl());
//        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        String landscape = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("landscape"))).getDomAttribute("src");
//        assertTrue(landscape.contains("landscape"), "The image source does not contain 'landscape'");
//    }
//
//    @Test
//    void testDialogBoxes() {
//        driver.get(config.getBaseUrl());
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//
//        driver.get("https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
//        driver.findElement(By.id("my-alert")).click();
//        wait.until(ExpectedConditions.alertIsPresent());
//        Alert alert = driver.switchTo().alert();
//        assertEquals("Hello world!", alert .getText());
//        alert.accept();
//    }
//
//    @Test
//    void testNavigate() {
//        driver.get(config.getBaseUrl());
//
//        driver.navigate().to("https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
//        driver.navigate().back();
//        assertEquals("https://bonigarcia.dev/selenium-webdriver-java/", driver.getCurrentUrl());
//    }
//
//    @Test
//    void testNewTab() {
//        driver.get(config.getBaseUrl());
//
//        String initHandle = driver.getWindowHandle();
//        System.out.println(initHandle);
//        driver.switchTo().newWindow(WindowType.TAB);
//        driver.get("https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
//        assertEquals(2, driver.getWindowHandles().size());
//
//        driver.switchTo().window(initHandle);
//        driver.close();
//        assertEquals(1, driver.getWindowHandles().size());
//    }
//
//    @Test
//    void testInfiniteScroll() {
//        driver.get(config.getBaseUrl());
//
//        driver.get("https://bonigarcia.dev/selenium-webdriver-java/infinite-scroll.html");
//        Actions actions = new Actions(driver);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//
//        actions.scrollByAmount(0, 900000000).perform();
//        By pLocator = By.tagName("p");
//        List<WebElement> paragraphs = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(pLocator, 0));
//        int initParagraphsNumber = paragraphs.size();
//        System.out.println(initParagraphsNumber);
//    }
}