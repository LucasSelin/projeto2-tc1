package org.origem.TestHome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Home {

    private WebDriver driver;

    // Construtor para receber o driver
    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public void AbreNavegador() {

        driver.get("https://devhub.dev.br");
    }



    public void insereCpfPesquisa() {
        WebElement pesquisaInput = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("iPesquisa")));
        pesquisaInput.sendKeys("123.123.123-10");


        WebElement botao = driver.findElement(By.tagName("button"));
        botao.click();

        // Localiza a imagem dentro do botão
        WebElement imagem = botao.findElement(By.tagName("img"));

        WebElement notificacao = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("notificacao ")));

        if (!notificacao.isDisplayed()) {
            throw new IllegalStateException("A notificação não foi exibida após o cadastro.");
        }
    }
}
