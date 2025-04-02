import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTest {
    WebDriver driver;
    private static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }


    @ParameterizedTest
    @DisplayName("Home page tests")
    @CsvSource({
            "Chapter 3. WebDriver Fundamentals, web-form.html, Web form",
            "Chapter 3. WebDriver Fundamentals, navigation1.html, Navigation example",
            "Chapter 3. WebDriver Fundamentals, dropdown-menu.html, Dropdown menu",
            "Chapter 3. WebDriver Fundamentals, mouse-over.html, Mouse over",
            "Chapter 3. WebDriver Fundamentals, drag-and-drop.html, Drag and drop",
            "Chapter 3. WebDriver Fundamentals, loading-images.html, Loading images",
            "Chapter 3. WebDriver Fundamentals, slow-calculator.html, Slow calculator",
            "Chapter 4. Browser-Agnostic Features, long-page.html, This is a long page",
            "Chapter 4. Browser-Agnostic Features, infinite-scroll.html, Infinite scroll",
            "Chapter 4. Browser-Agnostic Features, shadow-dom.html, Shadow DOM",
            "Chapter 4. Browser-Agnostic Features, iframes.html, IFrame",
            "Chapter 4. Browser-Agnostic Features, cookies.html, Cookies",
            "Chapter 4. Browser-Agnostic Features, dialog-boxes.html, Dialog boxes",
            "Chapter 4. Browser-Agnostic Features, web-storage.html, Web storage",
            "Chapter 5. Browser-Specific Manipulation, geolocation.html, Geolocation",
            "Chapter 5. Browser-Specific Manipulation, notifications.html, Notifications",
            "Chapter 5. Browser-Specific Manipulation, get-user-media.html, Get user media",
            "Chapter 5. Browser-Specific Manipulation, multilanguage.html, Multilanguage page",
            "Chapter 5. Browser-Specific Manipulation, console-logs.html, Console logs",
            "Chapter 7. The Page Object Model (POM), login-form.html, Login form",
            "Chapter 7. The Page Object Model (POM), login-slow.html, Slow login form",
            "Chapter 8. Testing Framework Specifics, random-calculator.html, Random calculator",
            "Chapter 9. Third-Party Integrations, download.html, Download files",
            "Chapter 9. Third-Party Integrations, ab-testing.html, A/B Testing",
            "Chapter 9. Third-Party Integrations, data-types.html, Data types"
    })
    void homePageTests(String chapterName, String path, String title) {
        driver.findElement(By.xpath("//h5[text() = '" + chapterName + "']/../a[@href = '" + path + "']")).click();
        String actualUrl = driver.getCurrentUrl();
        String actualTitle = driver.findElement(By.className("display-6")).getText();
        assertEquals(BASE_URL + path, actualUrl, "The URLs don't match");
        assertEquals(title, actualTitle, "The titles don't match");
    }

    @ParameterizedTest
    @DisplayName("Test frameWorks")
    @CsvSource({
            "Chapter 4. Browser-Agnostic Features, frames.html, Frames"
    })
    void frameTests(String chapterName, String path, String title) {
        driver.findElement(By.xpath("//h5[text() = '" + chapterName + "']/../a[@href = '" + path + "']")).click();
        String actualUrl = driver.getCurrentUrl();
        WebElement frame = driver.findElement(By.cssSelector("frame[name='frame-header']"));
        driver.switchTo().frame(frame);
        String actualTitle = driver.findElement(By.className("display-6")).getText();
        assertEquals(BASE_URL + path, actualUrl, "The URLs don't match");
        assertEquals(title, actualTitle, "The titles don't match");
    }

    @Test
    @DisplayName("Open all links")
    void openAllLinksTests() {
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
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String landscape = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("landscape"))).getDomAttribute("src");
        assertTrue(landscape.contains("landscape"), "The image source does not contain 'landscape'");
    }

    @Test
    void testDialogBoxes() {
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
        driver.navigate().to("https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
        driver.navigate().back();
        assertEquals("https://bonigarcia.dev/selenium-webdriver-java/", driver.getCurrentUrl());
    }

    @Test
    void testNewTab() {
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