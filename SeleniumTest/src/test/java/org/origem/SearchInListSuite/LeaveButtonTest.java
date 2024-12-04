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

public class LeaveButtonTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void leaveButtonTest() {

        driver.get("https://devhub.dev.br/");
        driver.manage().window().setSize(new Dimension(1936, 1056));


        WebElement leaveButton = driver.findElement(By.linkText("Sair"));
        leaveButton.click();

        // Validar que o clique no botão "Sair" aciona uma ação esperada
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            // Exemplo 1: Verificar redirecionamento para a página de login
            wait.until(ExpectedConditions.urlContains("login"));
            String currentUrl = driver.getCurrentUrl();
            assertTrue("Usuário não foi redirecionado para a página de login após clicar em 'Sair'!", currentUrl.contains("login"));
        } catch (Exception e) {
            fail("O botão 'Sair' não acionou nenhuma ação!");
        }

        try {
            // Exemplo 2: Verificar se um elemento específico da tela de logout aparece
            WebElement logoutMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".logout-message"))); // Substitua pelo seletor correto
            assertNotNull("Mensagem de logout não exibida!", logoutMessage);
            assertEquals("Você saiu do sistema.", logoutMessage.getText());
        } catch (Exception e) {
            fail("O botão 'Sair' não exibiu mensagem ou não funcionou corretamente!");
        }
    }
}
