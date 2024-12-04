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

public class InitialValidationTesteTest 
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
  public void initialValidationTeste() 
  {
    driver.get("https://devhub.dev.br/");
    driver.manage().window().setSize(new Dimension(1360, 530));
    driver.findElement(By.linkText("Pessoas")).click();

    {
      List<WebElement> elements = driver.findElements(By.xpath("//a[contains(text(),\'Pessoas\')]"));
      assert(elements.size() > 0);
    }

    driver.findElement(By.cssSelector("header")).click();

    {
      List<WebElement> elements = driver.findElements(By.xpath("//a[contains(text(),\'Sair\')]"));
      assert(elements.size() > 0);
    }

    driver.findElement(By.linkText("Sair")).click();

    assertThat(driver.getTitle(), is("Pessoas"));
    assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("DevHub"));
    
    {
      List<WebElement> elements = driver.findElements(By.cssSelector("article"));
      assert(elements.size() > 0);
    }
  }
}
