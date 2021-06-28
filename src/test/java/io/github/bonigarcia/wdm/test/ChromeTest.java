/*
 * (C) Copyright 2016 Boni Garcia (http://bonigarcia.github.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.github.bonigarcia.wdm.test;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

/**
 * Test with Chrome.
 *
 * @author Boni Garcia (boni.gg@gmail.com)
 * @since 1.0.0
 */
public class ChromeTest {

    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /*
     * @Test public void test() { // Your test code here. For example: WebDriverWait
     * wait = new WebDriverWait(driver, 30);
     * driver.get("https://en.wikipedia.org/wiki/Main_Page"); By searchInput =
     * By.id("searchInput"); wait.until(presenceOfElementLocated(searchInput));
     * driver.findElement(searchInput).sendKeys("Software"); By searchButton =
     * By.id("searchButton"); wait.until(elementToBeClickable(searchButton));
     * driver.findElement(searchButton).click();
     * 
     * wait.until(textToBePresentInElementLocated(By.tagName("body"),
     * "Computer software")); }
     */

    @Test
    public void testCarraoNoOlx() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize(); // abre o browser definido: chromedriver
        driver.get("https://olx.com.br/"); // busca o site do OLX pelo endereço
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("searchSubmitBtn")));
        WebElement elemento = driver.findElement(By.name("q")); // procura no codigo um elemento do tipo find com o nome
                                                                // 'q'
        elemento.click(); // clica no elemento retornado para selecioná-lo
        By searchInput = By.id("searchtext"); // localiza o mesmo elemento pelo id 'searchtext'
        wait.until(presenceOfElementLocated(searchInput));
        driver.findElement(searchInput).sendKeys("R8 5.2 V10", Keys.ENTER); // insere a palvara chave 'R8 5.2 V10'
        // através do metodo sendkeys na caixa de busca e aciona telca ENTER
        driver.findElement(By.id("ad-list")).findElement(By.partialLinkText("QUATTRO")).click(); // localiza dentro da
        // lista de resultados 'ad-list' o link com a palavra chave 'QUATTRO' e clica
        // nele, mostrando o resultado
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        wait.until(presenceOfElementLocated(By.partialLinkText("QUATTRO")));
    }

    @Test
    public void testSpotfyLoginFail() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();

        driver.get("https://www.spotify.com/br/"); // abre o site principal do spotify
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Entrar")));
        By loginMenuItem = By.linkText("Entrar"); // seleciona o link "Entrar" a partir do texto de exibição do link
        driver.findElement(loginMenuItem).click(); // clica no link entrar

        wait.until(elementToBeClickable(By.id("login-username"))); // localiza o elemento com id-username

        By inputName = By.id("login-username"); // atribui a variavel inpuname o elemento com id login-username
        By inputPassword = By.id("login-password"); // atribui à variavel inputPassword o elemento id login-password

        driver.findElement(inputName).sendKeys("Teste"); // no campo login-username insere a palavra-chave "teste"
        driver.findElement(inputPassword).sendKeys("Teste"); // no campo login-password insere a palavra-chave "teste"
        By loginButton = By.id("login-button");
        driver.findElement(loginButton).click(); // localiza e clica no botao com id "login-button"
        try {
            TimeUnit.SECONDS.sleep(2); // fecha o browser
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait.until(textToBePresentInElementLocated(By.tagName("body"), "Nome de usuário ou senha incorretos."));
    }

    @Test
    public void testSpotfySignUpFail() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
        driver.get("https://www.spotify.com/br/"); // abre o site principal do spotify
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Inscrever-se")));
        By loginMenuItem = By.linkText("Inscrever-se"); // localiza o link de inscrição
        driver.findElement(loginMenuItem).click(); // clica no link encontrado

        By imputEmail = By.id("email"); // localiza os compos pelo id e os atribui às variáveis
        By imputEmail2 = By.id("confirm");
        By password = By.id("password");
        By displayName = By.id("displayname");

        driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div/div[4]/div/label/span[2]/span")).click();
        driver.findElement(imputEmail).sendKeys("test@gmail.com"); // preenche os campos com os textos dos testes
        driver.findElement(imputEmail2).sendKeys("test@gmail.com");
        driver.findElement(password).sendKeys("12345678");
        driver.findElement(displayName).sendKeys("test01");
        driver.findElement(By.id("day")).sendKeys("11");
        Select month = new Select(driver.findElement(By.id("month")));
        month.selectByValue("10");
        driver.findElement(By.id("year")).sendKeys("1990");
        driver.findElement(By.xpath("//label[@for='gender_option_male']")).click(); // seleciona o genero masculino
        driver.findElement(By.xpath("//label[@for='marketing-opt-checkbox']")).click(); // aceita o recebimento de
                                                                                        // marketing
        driver.findElement(By.xpath("//label[@for='terms-conditions-checkbox']")).click(); // aceita os termos de uso

        By signUpButton = By.xpath("//*[@id=\"__next\"]/main/div[2]/div/form/div[10]/div/button/div[1]");
        driver.findElement(signUpButton).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        wait.until(textToBePresentInElementLocated(By.tagName("body"), "Confirme que você não é um robô."));
    }

}