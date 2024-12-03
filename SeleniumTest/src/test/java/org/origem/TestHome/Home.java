package org.origem.TestHome;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

        WebElement notificacao = botao.findElement(By.className("notificacao"));

       // WebElement notificacao = new WebDriverWait(driver, Duration.ofSeconds(10))
                //.until(ExpectedConditions.visibilityOfElementLocated(By.className('notificacao')).

        if (!notificacao.isDisplayed()) {
            throw new IllegalStateException("A notificação não foi exibida após o cadastro.");
        }
    }
     public void ClicBotaokSair() {
         WebElement sairLink = driver.findElement(By.linkText("Sair"));
         Assertions.assertTrue(sairLink.isDisplayed());
         sairLink.click();

         // Aguardar para verificar se o redirecionamento ocorreu
         Assertions.assertTrue(driver.getCurrentUrl().contains("login"));
     }

     public void ExcluirCadastro() {
        WebElement deletarCadastro = driver.findElement(By.cssSelector("Button[onclick ='removerPessoa)']"));
        deletarCadastro.click();
        WebElement noteficado = driver.findElement(By.className("noteficado"));
        Assertions.assertTrue(noteficado.isDisplayed());


     }
}
