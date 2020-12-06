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
    public void testLoginInvalido() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        driver.get("https://en.wikipedia.org/w/index.php?title=Special:UserLogin&returnto=Main+Page");

        By userLogin = By.id("wpName1");
        wait.until(presenceOfElementLocated(userLogin));
        driver.findElement(userLogin).sendKeys("testeUser");

        By userPassword = By.id("wpPassword1");
        wait.until(presenceOfElementLocated(userPassword));
        driver.findElement(userPassword).sendKeys("testePassword");

        By loginButton = By.id("wpLoginAttempt");
        wait.until(elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();

        wait.until(textToBePresentInElementLocated(By.className("errorbox"),
                "Incorrect username or password entered. Please try again."));
    }

    @Test
    public void testLoginValido() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        driver.get("https://en.wikipedia.org/w/index.php?title=Special:UserLogin&returnto=Main+Page");

        By userLogin = By.id("wpName1");
        wait.until(presenceOfElementLocated(userLogin));
        driver.findElement(userLogin).sendKeys("Testeqp");

        By userPassword = By.id("wpPassword1");
        wait.until(presenceOfElementLocated(userPassword));
        driver.findElement(userPassword).sendKeys("testePassword");

        By loginButton = By.id("wpLoginAttempt");
        wait.until(elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();

        wait.until(textToBePresentInElementLocated(By.tagName("body"),
                "Testeqp"));
    }

    @Test
    public void testPressLogIn() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        driver.get("https://en.wikipedia.org/wiki/Main_Page");

        By buttonLogIn = By.id("pt-login");
        wait.until(elementToBeClickable(buttonLogIn));
        driver.findElement(buttonLogIn).click();

        wait.until(textToBePresentInElementLocated(By.tagName("body"),
                "Username"));
    }

    @Test
    public void testPressLogInOnYT() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        driver.get("https://www.miniclip.com/games/br/#");

        By buttonLogIn = By.id("third-party-fb-login");
        wait.until(elementToBeClickable(buttonLogIn));
        driver.findElement(buttonLogIn).click();

        wait.until(textToBePresentInElementLocated(By.tagName("body"),
                "Facebook"));
    }

}