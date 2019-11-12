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
        driver.get("http://10.32.161.142:8080/owners/find");
        By addOwner = By.linkText("Add Owner");
        wait.until(elementToBeClickable(addOwner));
        driver.findElement(addOwner).click();
        
        By name = By.name("firstName");
        wait.until(presenceOfElementLocated(name));
        driver.findElement(name).sendKeys("Teste");
        
        By lastName = By.name("lastName");
        wait.until(presenceOfElementLocated(lastName));
        driver.findElement(lastName).sendKeys("Segundo Nome");
        
        By address = By.name("address");
        wait.until(presenceOfElementLocated(address));
        driver.findElement(address).sendKeys("Caxias");
        
        By city = By.name("city");
        wait.until(presenceOfElementLocated(city));
        driver.findElement(city).sendKeys("Eldorado");
        
        By telephone = By.name("telephone");
        wait.until(presenceOfElementLocated(telephone));
        driver.findElement(telephone).sendKeys("5512345679");  
        
        By addOwnerSubmit = By.xpath("//*[@id=\"add-owner-form\"]/div[2]/div/button");
        wait.until(elementToBeClickable(addOwnerSubmit));
        driver.findElement(addOwnerSubmit).click();
    }

}