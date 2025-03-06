import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


class HomePageTest {
    WebDriver chromeDriver;

    @BeforeEach
    void setUp() {
        chromeDriver = new ChromeDriver();
        chromeDriver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        chromeDriver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        chromeDriver.quit();
    }

    @Test
    void openHomePage() {

        String title = chromeDriver.getTitle();
        assertEquals("Hands-On Selenium WebDriver with Java", title);

        chromeDriver.findElement(By.xpath("//a[text() = \"Web form\"]")).click();


        chromeDriver.quit();
    }
}
