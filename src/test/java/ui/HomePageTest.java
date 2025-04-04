package ui;

import configs.TestPropertiesConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HomePageTest {
    WebDriver driver;
    TestPropertiesConfig config = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Open all links")
    void openAllLinksTests() {
        driver.get(config.getBaseUrl());

        List<WebElement> chapters = driver.findElements(By.cssSelector(".card h5"));
        for (WebElement chapter : chapters) {
            System.out.println(chapter.getText());
        }
        assertEquals(6, chapters.size());

        List<WebElement> links = driver.findElements(By.cssSelector(".card a"));
        for (WebElement link : links) {
            System.out.println(link.getText());
            link.click();
            driver.navigate().back();
        }
        assertEquals(27, links.size());
    }

    @Test
    void testLoadingImageExplicitWait() {
        driver.get(config.getBaseUrl());
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String landscape = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("landscape"))).getDomAttribute("src");
        assertTrue(landscape.contains("landscape"), "The image source does not contain 'landscape'");
    }

    @Test
    void testDialogBoxes() {
        driver.get(config.getBaseUrl());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
        driver.findElement(By.id("my-alert")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert =driver.switchTo().alert();
        assertEquals("Hello world!", alert.getText());
        alert.accept();
    }

    @Test
    void testNavigate() {
        driver.get(config.getBaseUrl());

        driver.navigate().to("https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
        driver.navigate().back();
        assertEquals("https://bonigarcia.dev/selenium-webdriver-java/", driver.getCurrentUrl());
    }

    @Test
    void testNewTab() {
        driver.get(config.getBaseUrl());

        String initHandle = driver.getWindowHandle();
        System.out.println(initHandle);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
        assertEquals(2, driver.getWindowHandles().size());

        driver.switchTo().window(initHandle);
        driver.close();
        assertEquals(1, driver.getWindowHandles().size());
    }

    @Test
    void testInfiniteScroll() {
        driver.get(config.getBaseUrl());

        driver.get("https://bonigarcia.dev/selenium-webdriver-java/infinite-scroll.html");
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        actions.scrollByAmount(0,900000000).perform();
        By pLocator = By.tagName("p");
        List<WebElement> paragraphs = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(pLocator, 0));
        int initParagraphsNumber = paragraphs.size();
        System.out.println(initParagraphsNumber);
    }
}