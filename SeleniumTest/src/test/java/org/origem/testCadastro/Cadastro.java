package org.origem.testCadastro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Cadastro {
    private WebDriver driver;

    public Cadastro(WebDriver driver) {
        this.driver = driver;
    }
    public void clickBataoAdicionar() throws InterruptedException {
        WebElement addLink = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.linkText("+ Adicionar")));
        addLink.click();


    }

    public void cadastrarPessoas() throws InterruptedException {
        WebElement addLink = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.linkText("+ Adicionar")));
        addLink.click();

        driver.findElement(By.id("iCpf")).sendKeys("123.123.123-10");
        driver.findElement(By.id("iNome")).sendKeys("Fernando");
        driver.findElement(By.id("iRua")).sendKeys("americo");
        driver.findElement(By.id("iNumero")).sendKeys("90");
        driver.findElement(By.id("iCep")).sendKeys("13573000");
        driver.findElement(By.id("iDataNasc")).sendKeys("1988-10-10");
        driver.findElement(By.id("iProfissao")).sendKeys("Analista");

        WebElement cadastrarButton = driver.findElement(By.id("cadastrarPessoa"));
        cadastrarButton.click();

        WebElement notificacao = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.notificacao p")));

        if (!notificacao.isDisplayed()) {
            throw new IllegalStateException("A notificação não foi exibida após o cadastro.");
        }
        //Thread.sleep(2000);
    }

    public void ClickVoltar() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement voltarLink = wait.until(ExpectedConditions.elementToBeClickable(By.className("voltar")));

        voltarLink.click();

        Assertions.assertTrue(driver.getCurrentUrl().contains("index.html"), "O redirecionamento para a página inicial falhou.");

    }
    public void cadatrarEmail() throws InterruptedException {

        WebElement botaoEmail = driver.findElement(By.cssSelector("button[onclick='mostrarContainer()']"));

        Assertions.assertTrue(botaoEmail.isDisplayed(), "O botão '+ Email' não está visível na página.");

        botaoEmail.click();

        driver.findElement(By.id("iEmail")).sendKeys("teste@gmail.com");

        WebElement botaoCadastrar = driver.findElement(By.xpath("//button[text()='Cadastrar']"));





        Assertions.assertTrue(botaoCadastrar.isDisplayed(), "O botão 'Cadastrar' não está visível na página.");

        botaoCadastrar.click();
        Thread.sleep(10000);

    }

    public void botaoCancelarDoEmail() throws InterruptedException {

        WebElement formCadastrarEmailPessoa = driver.findElement(By.id("formCadastrarEmailPessoa"));
        WebElement botaoEmail = driver.findElement(By.cssSelector("button[onclick='mostrarContainer()']"));

        Assertions.assertTrue(botaoEmail.isDisplayed(), "O botão '+ Email' não está visível na página.");

        botaoEmail.click();

        WebElement botaoCancelar = driver.findElement(By.cssSelector("button[onclick='esconderContainer()']"));
        botaoCancelar.click();


    }
    public void botaoCancelarDoTelefone() throws InterruptedException {

        WebElement botaoFone = driver.findElement(By.cssSelector("button[onclick='mostrarContainer2()']"));

        Assertions.assertTrue(botaoFone.isDisplayed(), "O botão telefone não está visível na página.");

        botaoFone.click();
        WebElement botaoCancelar = driver.findElement(By.cssSelector("button[onclick='esconderContainer2()']"));
        botaoCancelar.click();
       // Thread.sleep(5000);

    }

    public void cadastrarTelefone() throws InterruptedException {

        WebElement botaoFone = driver.findElement(By.cssSelector("button[onclick='mostrarContainer2()']"));

        Assertions.assertTrue(botaoFone.isDisplayed(), "O botão '+ Email' não está visível na página.");

        botaoFone.click();

        driver.findElement(By.id("iTelefone")).sendKeys("169999-99999");

        WebElement botaoCadastrar = driver.findElement(By.xpath("//button[text()='Cadastrar']"));

        Assertions.assertTrue(botaoCadastrar.isDisplayed(), "O não clicou no botão para cadastrar fone.");

        botaoCadastrar.click();

        //Thread.sleep(5000);


    }

    public  void clicarNoBotãoEditar() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement editButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@onclick, 'editarPessoa')]")));

        editButton.click();

        wait.until(ExpectedConditions.urlContains("editar"));

        Assertions.assertTrue(driver.getCurrentUrl().contains("editar"), "O redirecionamento para a página de edição falhou.");
    }

    public void excluirTelefone() throws InterruptedException {

        WebElement botaoFone = driver.findElement(By.cssSelector("button[onclick='excluirTelefone']"));
        botaoFone.click();

        Assertions.assertTrue(botaoFone.isDisplayed(), "O botão de excluir telefone não está visível.");

    }

    public void excluirEmaill() throws InterruptedException {

        WebElement botaoLixeira = driver.findElement(By.cssSelector("img[src='./img/lixeira-de-reciclagem.png']"));

        Assertions.assertTrue(botaoLixeira.isDisplayed(), "O botão de excluir email não está visível.");

        botaoLixeira.click();

       // Thread.sleep(2000); // Substituir por espera explícita se possível
    }



}
