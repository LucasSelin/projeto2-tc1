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

public class AddtelefoneTestTest 
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
  public void addtelefoneTest() 
  {
    driver.get("http://devhub.dev.br/");
    driver.manage().window().setSize(new Dimension(1360, 530));

    {
      WebElement element = driver.findElement(By.cssSelector(".tabelaListagem"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }

    {
      WebElement element = driver.findElement(By.cssSelector(".tabelaListagem"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }

    {
      WebElement element = driver.findElement(By.cssSelector(".tabelaListagem"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }

    {
      List<WebElement> elements = driver.findElements(By.cssSelector("td:nth-child(10)"));
      assert(elements.size() > 0);
    }

    driver.findElement(By.xpath("//img[@alt=\'Lapis - edicao\']")).click();
    driver.findElement(By.cssSelector("div:nth-child(19) > button")).click();
    driver.findElement(By.id("iTelefone")).click();
    driver.findElement(By.id("iTelefone")).sendKeys("(19) 998290806");
    driver.findElement(By.cssSelector("#formCadastrarTelefonePessoa button:nth-child(2)")).click();
    driver.findElement(By.cssSelector("div:nth-child(19) > button")).click();
    driver.findElement(By.id("iTelefone")).click();
    driver.findElement(By.id("iTelefone")).sendKeys("19998290806");
    driver.findElement(By.cssSelector("#formCadastrarTelefonePessoa button:nth-child(2)")).click();

    {
      List<WebElement> elements = driver.findElements(By.xpath("//li[contains(.,\'(19) 998290806\')]"));
      assert(elements.size() > 0);
    }

    {
      List<WebElement> elements = driver.findElements(By.xpath("//li[contains(.,\'19998290806\')]"));
      assert(elements.size() > 0);
    }

    driver.findElement(By.id("cadastrarPessoa")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".tabelaListagem"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }

    {
      WebElement element = driver.findElement(By.cssSelector(".tabelaListagem"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }

    {
      WebElement element = driver.findElement(By.cssSelector(".tabelaListagem"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    
    {
      List<WebElement> elements = driver.findElements(By.xpath("//td[contains(.,\'(19) 998290806, 19998290806\')]"));
      assert(elements.size() > 0);
    }
  }
}
