package ui;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;

public class WebFormTests extends BaseTest {

    @Test
    void testOpenWebForm() {
        driver.get(config.getBaseUrl());
        driver.findElement(By.linkText("Web form")).click();

        assertThat(driver.getCurrentUrl()).isEqualTo(config.getBaseUrl() + "web-form.html");
    }
}
