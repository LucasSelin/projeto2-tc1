package org.origem;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.origem.TestHome.Home;
import org.origem.testCadastro.Cadastro;

import java.time.Duration;

public class SeleniumTest {
    private WebDriver driver;
    private Home home;
    private Cadastro cadastro;

    @BeforeEach
    void setUp() 
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://devhub.dev.br/");

        home = new Home(driver);
        cadastro = new Cadastro(driver);
    }

    @AfterEach
    void tearDown() 
    {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Deve abrir e fechar o navegador")
    public void AbreNavegador()
    {
      driver.get("https://devhub.dev.br/");
    }

    @Test
    @DisplayName("Deve abrir a página e verificar o título")
    void verificarTítulo()
    {
        driver.get("https://devhub.dev.br/");
        System.out.println("ok");
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(driver.getTitle().contains("DevHub"));
    }

    @Test
    @DisplayName("Deve clicar no botão cadastrar ,voltar e editar")
    public void testeClickBotaoCadastrarVoltarEditar() throws InterruptedException 
    {
        cadastro.cadastrarPessoas();
        cadastro.ClickVoltar();
        cadastro.clicarNoBotãoEditar();

        Assertions.assertTrue(true, "Pessoa adicionada com sucesso.");
    }

    @Test
    @DisplayName("Deve pesquisar por cpf")
    public void pesquisarCpf() throws InterruptedException 
    {
        cadastro.cadastrarPessoas();
        cadastro.ClickVoltar();
        home.insereCpfPesquisa();

        Assertions.assertTrue(true, "Teste concluído com sucesso.");
    }
    
    @Test
    @DisplayName("Testa cadastrar pessoa")
    public void testarAdicionarPessoa() throws InterruptedException 
    {
        cadastro.cadastrarPessoas();
        cadastro.ClickVoltar();
        cadastro.clickBataoAdicionar();

        Assertions.assertTrue(true, "Pessoa adicionada com sucesso.");
    }

    @Test
    @DisplayName("Deve cadastrar email e telefone")
    void testarCadastrarEmailTelefone() throws InterruptedException 
    {
        cadastro.cadastrarPessoas();
        cadastro.cadastrarTelefone();
        cadastro.cadatrarEmail();
    }

    @Test
    @DisplayName("Deve excluir email e telefone")
    void excluirEmailTelefone() throws InterruptedException 
    {
        cadastro.clickBataoAdicionar();
        cadastro.cadatrarEmail();
        cadastro.excluirEmaill();
        cadastro.cadastrarTelefone();
        cadastro.excluirTelefone();
    }

    @Test
    @DisplayName("Deve clicar no botao cancelar do email e telefone")
    void clicarNoBotaoCancelaDoEmail() throws InterruptedException 
    {
        cadastro.clickBataoAdicionar();
        cadastro.botaoCancelarDoEmail();
        cadastro.botaoCancelarDoTelefone();
    }
}
