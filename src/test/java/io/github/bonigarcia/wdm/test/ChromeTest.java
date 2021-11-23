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

import static org.junit.Assert.assertEquals;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @Test
    public void test() {
        // Your test code here. For example:
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        By searchInput = By.id("searchInput");
        wait.until(presenceOfElementLocated(searchInput));
        driver.findElement(searchInput).sendKeys("Software");
        By searchButton = By.id("searchButton");
        wait.until(elementToBeClickable(searchButton));
        driver.findElement(searchButton).click();

        wait.until(textToBePresentInElementLocated(By.tagName("body"),
                "Computer software"));
    }

    @Test
    public void testOlxSearchAnuncio() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get("https://rs.olx.com.br/");

        WebElement elemento = driver.findElement(By.name("q"));
        elemento.click();

        By searchInput = By.id("searchtext");
        wait.until(presenceOfElementLocated(searchInput));
        driver.findElement(searchInput).sendKeys("cbr 600 rr", Keys.ENTER);

        wait.until(textToBePresentInElementLocated(By.tagName("body"),
                "R$ 28.000"));
    }

    @Test
    public void testSearchLeilao() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get("https://www.leiloes.com.br");
        By closePopUp = By.id("botaoFecharBanner");
        Thread.sleep(10000);
        wait.until(elementToBeClickable(closePopUp));
        driver.findElement(closePopUp).click();

        By menuPesquisa = By.xpath("//*[@id=\"content\"]/div/div[2]/div[1]/div/span/span[1]/button/span");
        wait.until(elementToBeClickable(menuPesquisa));
        driver.findElement(menuPesquisa).click();

        By inputPesquisa = By.name("texto");
        wait.until(presenceOfElementLocated(inputPesquisa));
        driver.findElement(inputPesquisa).sendKeys("cbr", Keys.ENTER);

        wait.until(textToBePresentInElementLocated(By.tagName("body"),
                "Nenhum lote para esta categoria"));
    }
}