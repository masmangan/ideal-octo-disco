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

//    @After
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

 @Test
    public void testSearch() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get("https://www.americanas.com.br/");
        By searchInput = By.id("h_search-input");
        driver.findElement(searchInput).sendKeys("Celular");
        By searchButton = By.id("h_search-btn");
        driver.findElement(searchButton).click();
 }

 @Test
    public void testForm() {
        driver.get("https://lojadosherois.com.br/account/register/");
        By name = By.id("name");
        driver.findElement(name).sendKeys("Brenda");
        By email = By.name("email");
        driver.findElement(email).sendKeys("brenda.david@acad.pucrs.br");
        By phone = By.name("phone");
        driver.findElement(email).sendKeys("51983588889");
        By password = By.name("password");
        driver.findElement(password).sendKeys("testeT3!");
        By confirmPassword = By.name("password_confirmation");
        driver.findElement(confirmPassword).sendKeys("testeT3!");
        By login = By.name("submit");
        driver.findElement(login).click();
  }

}
