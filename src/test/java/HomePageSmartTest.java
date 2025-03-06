import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageSmartTest {
    WebDriver driver;
    private static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testdata.csv", numLinesToSkip = 1)
    void openLinksByTextTest(
            String chapterName, String linkText, String linkUrl, String headerName, boolean isFrame) {

        WebElement chapterSection =
                driver.findElement(By.xpath("//div[h5[text()='" + chapterName + "']]"));
        Assertions.assertEquals(
                chapterName,
                chapterSection.findElement(By.tagName("h5")).getText(),
                "Chapter name должен быть " + chapterName);
        WebElement linkInChapter = chapterSection.findElement(By.linkText(linkText));
        linkInChapter.click();

        Assertions.assertEquals(linkUrl, driver.getCurrentUrl(), "URL должен соответствовать ожидаемому значению");

        if (isFrame) {
            WebElement frameElement = driver.findElement(By.cssSelector("frame[name='frame-header']"));
            driver.switchTo().frame(frameElement);
        }

        String actualHeading = driver.findElement(By.cssSelector("h1.display-6")).getText();
        Assertions.assertTrue(
                actualHeading.contains(headerName), "Заголовок должен содержать текст: " + headerName);
    }
}