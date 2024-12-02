package org.origem;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.origem.TestHome.Home;
import org.origem.testCadastro.Cadastro;

import java.time.Duration;

public class SeleniumTest {


    private WebDriver driver;

    private Home home;
    private Cadastro cadastro;

    @BeforeEach
    void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://devhub.dev.br/");

       home = new Home(driver);
       cadastro = new Cadastro(driver);
    }


    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Deve abrir e fechar o navegador")
    public void AbreNavegador(){
      driver.get("https://devhub.dev.br/");
    }

    @Test
    @DisplayName("Deve abrir a página e verificar o título")
    void verificarTítulo(){
        driver.get("https://devhub.dev.br/");
        System.out.println("ok");
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(driver.getTitle().contains("DevHub"));
    }


}
