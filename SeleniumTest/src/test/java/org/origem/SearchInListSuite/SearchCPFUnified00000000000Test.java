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
import org.openqa.selenium.Keys;

public class SearchCPFUnified00000000000Test {
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
    public void searchCPFUnified00000000000() {

        driver.get("https://devhub.dev.br/");
        driver.manage().window().setSize(new Dimension(1936, 1056));

        WebElement searchInput = driver.findElement(By.id("iPesquisa"));
        searchInput.click();
        searchInput.sendKeys("51066463832"); // CPF sem formatação
        searchInput.sendKeys(Keys.ENTER);

        // Validar que não houve resultados para o CPF não formatado
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement noResultsMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".no-results"))); // Substitua pelo seletor correto
        assertNotNull("Nenhuma mensagem exibida para CPF não formatado!", noResultsMessage);
        assertEquals("Nenhum registro encontrado.", noResultsMessage.getText());

        // Limpar e inserir CPF no formato correto
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys("510.664.638-32"); // CPF formatado corretamente
        searchInput.sendKeys(Keys.ENTER);


        WebElement resultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".result-row"))); // Substitua pelo seletor correto
        assertNotNull("Resultados não exibidos para o CPF formatado!", resultElement);
        assertTrue("O CPF formatado não foi encontrado!", resultElement.getText().contains("510.664.638-32"));
    }
}
