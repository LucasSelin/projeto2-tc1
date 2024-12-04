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
public class SearchTestTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void searchTest() {
    driver.get("http://devhub.dev.br/");
    {
      List<WebElement> elements = driver.findElements(By.xpath("//td[contains(.,\'123.123.123-60\')]"));
      assert(elements.size() > 0);
    }
    driver.findElement(By.id("iPesquisa")).click();
    driver.findElement(By.id("iPesquisa")).sendKeys("123.123.123-50");
    driver.findElement(By.cssSelector("#pessoas > button")).click();
    driver.findElement(By.cssSelector("main")).click();
    driver.findElement(By.cssSelector("#pessoas img")).click();
    {
      WebElement element = driver.findElement(By.cssSelector("#pessoas img"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.cssSelector("#pessoas > button")).click();
    {
      List<WebElement> elements = driver.findElements(By.xpath("//p[contains(.,\'Nenhuma pessoa encontrada!\')]"));
      assert(elements.size() > 0);
    }
    driver.findElement(By.id("iPesquisa")).click();
    driver.findElement(By.id("iPesquisa")).sendKeys("123.123.123-60");
    driver.findElement(By.id("iPesquisa")).click();
    driver.findElement(By.cssSelector("main")).click();
    driver.findElement(By.cssSelector("#pessoas > button")).click();
    {
      WebElement element = driver.findElement(By.cssSelector("#pessoas > button"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(.,\'1 pessoas encontradas!\')]")));
    }
  }
}
