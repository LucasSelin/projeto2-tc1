package org.origem.testCadastro;

import org.junit.jupiter.api.Assertions;
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
        Thread.sleep(20000);

    }
    public void cadastrarTelefone() throws InterruptedException {

        WebElement botaoFone = driver.findElement(By.cssSelector("button[onclick='mostrarContainer2()']"));

        Assertions.assertTrue(botaoFone.isDisplayed(), "O botão '+ Email' não está visível na página.");

        botaoFone.click();

        driver.findElement(By.id("iTelefone")).sendKeys("169999-99999");


        WebElement botaoCadastrar = driver.findElement(By.xpath("//button[text()='Cadastrar']"));


        Assertions.assertTrue(botaoCadastrar.isDisplayed(), "O não clicou no botão para cadastrar fone.");


        botaoCadastrar.click();

        Thread.sleep(20000);


    }
}
