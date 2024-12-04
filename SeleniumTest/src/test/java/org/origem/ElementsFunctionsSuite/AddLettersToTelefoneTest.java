import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class AddLettersToTelefoneTest 
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
    public void addLettersToTelefoneTest() {
        driver.get("http://devhub.dev.br/");
        driver.manage().window().setSize(new Dimension(1360, 530));

        driver.findElement(By.xpath("//img[@alt='Lapis - edicao']")).click();
        driver.findElement(By.cssSelector("div:nth-child(19) > button")).click();

        WebElement telefoneInput = driver.findElement(By.id("iTelefone"));
        telefoneInput.click();
        telefoneInput.clear(); // Limpar o campo antes de inserir
        telefoneInput.sendKeys("a"); // Inserir letra como telefone
        driver.findElement(By.cssSelector("#formCadastrarTelefonePessoa button:nth-child(2)")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error-message"))); // Substitua pelo seletor correto para a mensagem de erro
        assertNotNull("A mensagem de erro não foi exibida!", errorMessage);
        assertEquals("Telefone inválido.", errorMessage.getText());

        List<WebElement> addedPhones = driver.findElements(By.xpath("//li[contains(.,'a')]"));
        assertTrue("O telefone com letras foi adicionado à lista!", addedPhones.isEmpty());
    }
}
