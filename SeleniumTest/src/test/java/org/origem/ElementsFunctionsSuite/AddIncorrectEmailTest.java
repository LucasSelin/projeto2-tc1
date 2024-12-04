import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddIncorrectEmailTest 
{
    private WebDriver driver;

    @Before
    public void setUp() 
    {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() 
    {
        driver.quit();
    }

    @Test
    public void addIncorrectEmail() 
    {

        driver.get("https://devhub.dev.br/");
        driver.manage().window().setSize(new Dimension(1936, 1056));


        driver.findElement(By.xpath("//img[@alt='Lapis - edicao']")).click();

        // Inserir um e-mail inválido
        WebElement emailInput = driver.findElement(By.id("iEmail"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("pepepepepepe@pepepe");
        driver.findElement(By.cssSelector("#formCadastrarEmailPessoa button:nth-child(2)")).click();


        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error-message"))); // Substitua pelo seletor correto da mensagem de erro
        assertNotNull("A mensagem de erro não foi exibida!", errorMessage);


        String expectedMessage = "E-mail inválido.";
        assertEquals("Erro: mensagem de validação incorreta!", expectedMessage, errorMessage.getText());
    }
}
