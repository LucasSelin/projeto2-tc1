package org.origem;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.origem.TestHome.Home;

import java.time.Duration;

public class SeleniumTest {


    private WebDriver driver;

    private Home home;

    @BeforeEach
    void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://devhub.dev.br/");

       home = new Home(driver);
    }


    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Deve abrir e fechar o navegafor")
    public void AbreNavegador(){
      driver.get("https://devhub.dev.br/");
    }
}
