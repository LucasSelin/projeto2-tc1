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

public class CheckIfDateIsValidTest {
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
  public void checkIfDateIsValid() {

    driver.get("https://devhub.dev.br/");
    driver.manage().window().setSize(new Dimension(1936, 1056));


    driver.findElement(By.xpath("//img[@alt='Lapis - edicao']")).click();

    // Inserir uma data inválida
    WebElement dateInput = driver.findElement(By.id("iDataNasc"));
    dateInput.click();
    dateInput.clear();
    dateInput.sendKeys("3333-12-22");
    driver.findElement(By.id("cadastrarPessoa")).click();


    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error-message"))); // Substitua pelo seletor correto da mensagem de erro
    assertNotNull("A mensagem de erro não foi exibida!", errorMessage);


    String expectedMessage = "Data inválida.";
    assertEquals("Erro: mensagem de validação incorreta!", expectedMessage, errorMessage.getText());
  }
}
