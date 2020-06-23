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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

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
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        By searchInput = By.id("searchInput");
        wait.until(presenceOfElementLocated(searchInput));
        driver.findElement(searchInput).sendKeys("covid");
        By searchButton = By.id("searchButton");
        wait.until(elementToBeClickable(searchButton));
        driver.findElement(searchButton).click();

        wait.until(textToBePresentInElementLocated(By.tagName("body"),
               "disease"));
    }
    @Test
    public void testConjugaMe() {
        // Your test code here. For example:
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://conjuga-me.net/");
        By searchInput = By.id("insert");
        wait.until(presenceOfElementLocated(searchInput));
        driver.findElement(searchInput).sendKeys("Ser");
        By searchButton = By.id("conj-button");
        wait.until(elementToBeClickable(searchButton));
        driver.findElement(searchButton).click();


    }
    
    @Test
    public void testAddSupport() {
        // Your test code here. For example:
        WebDriverWait wait = new WebDriverWait(driver, 300);
        By btnAddSupport = By.linkText("Enviar para o Suporte");
        wait.until(presenceOfElementLocated(btnAddSupport));
        wait.until(elementToBeClickable(btnAddSupport));
        driver.findElement(btnAddSupport).click();

        assertEquals("https://safeweb.com.br/suporte/", driver.getCurrentUrl());

        By NomeC = By.id("nome");
        By emailC = By.id("email");
        By telC = By.id("tel");
        By CpfCnpjC = By.id("CpfCnpj");
        By duvidaC = By.id("duvida");
        btnAddSupport = By.xpath("//*[@id='enviar']/div[2]/div/button");

        wait.until(presenceOfElementLocated(telC));

        String nome = "Nome";
        String email = "nome@gmail.com";
        String tel = "980988768";
        String CpfCnpj = "02126698009";
        String duvida = "teste";

        driver.findElement(NomeC).sendKeys(nome);
        driver.findElement(emailC).sendKeys(email);
        driver.findElement(telC).sendKeys(tel);
        driver.findElement(CpfCnpjC).sendKeys(CpfCnpj);
        driver.findElement(duvidaC).sendKeys(duvida);

        driver.findElement(btnAddSupport).click();

       /* By btnEditOwners = By.linkText("Edit Owner");
        wait.until(presenceOfElementLocated(btnEditOwners));
        wait.until(elementToBeClickable(btnEditOwners));*/
    }

    

}