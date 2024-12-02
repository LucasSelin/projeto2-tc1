package org.origem.testCadastro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Cadastro {
    private WebDriver driver;

    public Cadastro(WebDriver driver) {
        this.driver = driver;
    }
    public void clickBataoAdicionar() throws InterruptedException {
        WebElement addLink = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.linkText("+ Adicionar")));
        addLink.click();


    }
}
