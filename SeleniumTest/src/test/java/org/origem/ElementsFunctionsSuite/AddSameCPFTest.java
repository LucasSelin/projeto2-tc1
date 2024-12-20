import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddSameCPFTest 
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
  public void addSameCPF() 
  {
    driver.get("https://devhub.dev.br/");
    driver.manage().window().setSize(new Dimension(1936, 1056));

    driver.findElement(By.linkText("+ Adicionar")).click();
    driver.findElement(By.id("iCpf")).sendKeys("510.664.638-32");
    driver.findElement(By.id("iNome")).sendKeys("pedro");
    driver.findElement(By.id("iRua")).sendKeys("rua1");
    driver.findElement(By.id("iNumero")).sendKeys("1");
    driver.findElement(By.id("iCep")).sendKeys("13569160");
    driver.findElement(By.id("iDataNasc")).sendKeys("2002-12-21");
    driver.findElement(By.id("iProfissao")).sendKeys("seila");
    driver.findElement(By.id("cadastrarPessoa")).click();

    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".success-message"))); // Substitua pelo seletor correto da mensagem de sucesso

    driver.findElement(By.linkText("+ Adicionar")).click();
    driver.findElement(By.id("iCpf")).sendKeys("510.664.638-32"); // CPF já cadastrado
    driver.findElement(By.id("iNome")).sendKeys("pedro duplicado");
    driver.findElement(By.id("iRua")).sendKeys("rua2");
    driver.findElement(By.id("iNumero")).sendKeys("2");
    driver.findElement(By.id("iCep")).sendKeys("13569161");
    driver.findElement(By.id("iDataNasc")).sendKeys("2000-01-01");
    driver.findElement(By.id("iProfissao")).sendKeys("outro");
    driver.findElement(By.id("cadastrarPessoa")).click();

    WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error-message"))); // Substitua pelo seletor correto da mensagem de erro
    assertNotNull("A mensagem de erro não foi exibida!", errorMessage);
    assertEquals("CPF já cadastrado.", errorMessage.getText());
  }
}
