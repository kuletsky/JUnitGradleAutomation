package ui;

import configs.TestPropertiesConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebFormTests extends BaseTest {

    @Test
    void testOpenWebForm() {
        driver.get(config.getBaseUrl());
        driver.findElement(By.linkText("Web form")).click();

         assertThat(driver.getCurrentUrl()).isEqualTo(config.getBaseUrl()+"web-form.html");
    }
}
