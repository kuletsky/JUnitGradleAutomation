import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


class HomePageTest {
    WebDriver chromeDriver;
    private static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";

    @BeforeEach
    void setUp() {
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get(BASE_URL);
    }

    @AfterEach
    void tearDown() {
        chromeDriver.quit();
    }

    @Test
    void openHomePage() {

        String titleWebPage = chromeDriver.getTitle();
        assertEquals("Hands-On Selenium WebDriver with Java", titleWebPage);

        // CHAPTER 3. Web form verification
        WebElement titleWebForm = chromeDriver.findElement(By.xpath("//a[text() = \"Web form\"]"));
        titleWebForm.click();

        String webFormURL = "web-form.html";
        String curentURL = chromeDriver.getCurrentUrl();
        assertEquals(BASE_URL + webFormURL, curentURL);

        String title = chromeDriver.findElement(By.cssSelector(".display-6")).getText();
        assertEquals("Web form", title);

        chromeDriver.navigate().back();


        // CHAPTER 3. NAVIGATION VERIFICATION
        chromeDriver.findElement(By.xpath("//a[@href='navigation1.html']")).click();

        String urlNavigation = chromeDriver.getCurrentUrl();
        assertEquals(BASE_URL + "navigation1.html", urlNavigation);

        String titleNavigation = chromeDriver.findElement(By.cssSelector(".display-6")).getText();
        assertEquals("Navigation example", titleNavigation);

        chromeDriver.navigate().back();


        // CHAPTER 3. DROPDOWN MENU
        chromeDriver.findElement(By.xpath("//a[@href='dropdown-menu.html']")).click();

        String urlDropdown = chromeDriver.getCurrentUrl();
        assertEquals(BASE_URL + "dropdown-menu.html", urlDropdown);

        String titleDropdown = chromeDriver.findElement(By.cssSelector(".display-6")).getText();
        assertEquals("Dropdown menu", titleDropdown);

        chromeDriver.navigate().back();


        //  CHAPTER 3. MOUSE OVER
        chromeDriver.findElement(By.xpath("//a[@href='mouse-over.html']")).click();

        String urlMouseOver = chromeDriver.getCurrentUrl();
        assertEquals(BASE_URL + "mouse-over.html", urlMouseOver);

        String titleMouseOver = chromeDriver.findElement(By.cssSelector(".display-6")).getText();
        assertEquals("Mouse over", titleMouseOver);

        chromeDriver.navigate().back();


        //  CHAPTER 3. DRAG AND DROP
        chromeDriver.findElement(By.xpath("//a[@href='drag-and-drop.html']")).click();

        String urlDragAndDrop = chromeDriver.getCurrentUrl();
        assertEquals(BASE_URL + "drag-and-drop.html", urlDragAndDrop);

        String titleDragAndDrop = chromeDriver.findElement(By.cssSelector(".display-6")).getText();
        assertEquals("Drag and drop", titleDragAndDrop);

        chromeDriver.navigate().back();


        //  CHAPTER 3. DRAW IN CANVAS
        chromeDriver.findElement(By.xpath("//a[@href='draw-in-canvas.html']")).click();

        String urlDrawInCanvas = chromeDriver.getCurrentUrl();
        assertEquals(BASE_URL + "draw-in-canvas.html", urlDrawInCanvas);

        String titleDrawInCanvas = chromeDriver.findElement(By.cssSelector(".display-6")).getText();
        assertEquals("Drawing in canvas", titleDrawInCanvas);

        chromeDriver.navigate().back();


        //  CHAPTER 3. LOADING IMAGES
        chromeDriver.findElement(By.xpath("//a[@href='loading-images.html']")).click();

        String urlLoadingImages = chromeDriver.getCurrentUrl();
        assertEquals(BASE_URL + "loading-images.html", urlLoadingImages);

        String titleLoadingImages = chromeDriver.findElement(By.cssSelector(".display-6")).getText();
        assertEquals("Loading images", titleLoadingImages);

        chromeDriver.navigate().back();


        //  CHAPTER 3. SLOW CALCULATOR
        chromeDriver.findElement(By.xpath("//a[@href='slow-calculator.html']")).click();

        String urlSlowCalculator = chromeDriver.getCurrentUrl();
        assertEquals(BASE_URL + "slow-calculator.html", urlSlowCalculator);

        String titleSlowCalculator = chromeDriver.findElement(By.cssSelector(".display-6")).getText();
        assertEquals("Slow calculator", titleSlowCalculator);

        chromeDriver.navigate().back();












    }
}
