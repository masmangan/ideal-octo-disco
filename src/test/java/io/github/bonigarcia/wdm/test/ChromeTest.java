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

import java.util.Random;

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
import org.openqa.selenium.Keys;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Test with Chrome.
 *
 * @author Boni Garcia (boni.gg@gmail.com)
 * @since 1.0.0
 */
public class ChromeTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
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

        wait.until(textToBePresentInElementLocated(By.tagName("body"), "Computer software"));
    }

    @Test
    public void testJovemNerdNerdCastRpg() {
        driver.get("https://jovemnerd.com.br/nerdcast/");

        By searchInput = By.xpath("//input[@placeholder='Pesquisar NerdCast...']");
        wait.until(presenceOfElementLocated(searchInput));
        driver.findElement(searchInput).sendKeys("call of cthulhu" + Keys.ENTER);

        By podCast = By.xpath(
                "//a[@href='https://jovemnerd.com.br/nerdcast/rpg-call-of-cthulhu-3-o-despertar-dos-profundos/']");
        wait.until(presenceOfElementLocated(podCast));
        driver.findElement(podCast).click();

        By playButton = By.className("play-podcast");
        wait.until(presenceOfElementLocated(playButton));
    }

    @Test
    public void testCasdastro() {
        Random randomNumber = new Random();

        driver.get("https://react-redux.realworld.io/#/register?_k=yfsp7y");

        By userNameInput = By.xpath("//input[@placeholder='Username']");
        By emailInput = By.xpath("//input[@placeholder='Email']");
        By passwordInput = By.xpath("//input[@placeholder='Password']");

        String newName = "qptest" + randomNumber.nextInt(10000);

        // Preenche o formulario
        wait.until(presenceOfElementLocated(userNameInput));
        driver.findElement(userNameInput).sendKeys(newName);

        wait.until(presenceOfElementLocated(emailInput));
        driver.findElement(emailInput).sendKeys("qptest" + randomNumber.nextInt(10000) + "@email.com");

        wait.until(presenceOfElementLocated(passwordInput));
        driver.findElement(passwordInput).sendKeys("P4ssW0rdT3st");

        // Submit
        By submitButton = By.className("btn");
        driver.findElement(submitButton).click();

        // Busca pela label do nome do usuário criado que foi logado
        By userLabel = By.xpath("//a[@href='#@" + newName + "']");
        wait.until(presenceOfElementLocated(userLabel));
    }

}