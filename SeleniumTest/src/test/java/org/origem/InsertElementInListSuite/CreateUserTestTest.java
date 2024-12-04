import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class CreateUserTestTest 
{
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

  @Before
  public void setUp() 
  {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }

  @After
  public void tearDown() 
  {
    driver.quit();
  }

  @Test
  public void createUserTest() 
  {
    driver.get("http://devhub.dev.br/");
    driver.manage().window().setSize(new Dimension(1360, 530));
    driver.findElement(By.linkText("+ Adicionar")).click();
    driver.findElement(By.id("iCpf")).click();
    driver.findElement(By.id("iCpf")).sendKeys("123.123.123-60");
    driver.findElement(By.id("iNome")).click();
    driver.findElement(By.id("iNome")).sendKeys("nome");
    driver.findElement(By.id("iRua")).click();
    driver.findElement(By.id("iRua")).sendKeys("rua teste");
    driver.findElement(By.id("iNumero")).sendKeys("123");
    driver.findElement(By.id("iCep")).click();
    driver.findElement(By.id("iCep")).sendKeys("13465520");
    driver.findElement(By.id("iDataNasc")).click();
    driver.findElement(By.id("iDataNasc")).sendKeys("0001-02-08");
    driver.findElement(By.id("iDataNasc")).sendKeys("0011-02-08");
    driver.findElement(By.id("iDataNasc")).sendKeys("0110-02-08");
    driver.findElement(By.id("iDataNasc")).sendKeys("1101-02-08");
    driver.findElement(By.id("iProfissao")).click();
    driver.findElement(By.id("iProfissao")).sendKeys("profissao");
    driver.findElement(By.id("cadastrarPessoa")).click();

    {
      WebElement element = driver.findElement(By.id("cadastrarPessoa"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }

    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    
    driver.findElement(By.cssSelector("img")).click();
    {
      List<WebElement> elements = driver.findElements(By.xpath("//td[contains(.,\'nome\')]"));
      assert(elements.size() > 0);
    }
  }
}