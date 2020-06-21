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

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeTest {
	
	Random random = new Random();
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
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get("https://github.com/");
        // Espera pelo botão de pesquisa e escreve Lucas Staudt
        By searchInput = By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/div/div/div/form/label/input[1]");
        wait.until(presenceOfElementLocated(searchInput));
        driver.findElement(searchInput).sendKeys("Lucas Staudt");

        // clica em pesquisar
        By searchButton = By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/div/div/div/form/label/div");
        wait.until(elementToBeClickable(searchButton));
        driver.findElement(searchButton).click();
        
        // procura pelo usuário e clica no botão
        By usersButton = By.xpath("//*[@id=\"js-pjax-container\"]/div/div[2]/nav[1]/a[10]");
        wait.until(elementToBeClickable(usersButton));
        driver.findElement(usersButton).click();
        // espera encontrar o link para o perfil lucasstd
        wait.until(textToBePresentInElementLocated(By.className("mr-1"), "Lucas"));
    }

    public String generateName() {
    	String randomNumberString = "" + random.nextInt(99999);
    	return "ewopekokPODa" + randomNumberString;
    }
    
    public String generateEmail() {
    	String randomNumberString = "" + random.nextInt(99999);
    	return "ewopekokPODa" + randomNumberString + "@gmail.com";
    }

    @Test
    public void testCadastro() {
    	String name = generateName();
    	String email = generateEmail();
    	
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get("https://angular.realworld.io");
        
        By singUpInput = By.xpath("/html/body/app-root/app-layout-header/nav/div/ul/li[3]/a");
    	wait.until(presenceOfElementLocated(singUpInput));
    	driver.findElement(singUpInput).click();
        
    	By userInput = By.xpath("/html/body/app-root/app-auth-page/div/div/div/div/form/fieldset/fieldset[1]/input");
    	By emailInput = By.xpath("/html/body/app-root/app-auth-page/div/div/div/div/form/fieldset/fieldset[2]/input");
    	By passwordInput = By.xpath("/html/body/app-root/app-auth-page/div/div/div/div/form/fieldset/fieldset[3]/input");
    	
    	wait.until(presenceOfElementLocated(userInput));
    	driver.findElement(userInput).sendKeys(name);
    	
    	wait.until(presenceOfElementLocated(emailInput));
    	driver.findElement(emailInput).sendKeys(email);
    	
    	wait.until(presenceOfElementLocated(passwordInput));
    	driver.findElement(passwordInput).sendKeys("312312321");
    	
    	By submitButton = By.xpath("/html/body/app-root/app-auth-page/div/div/div/div/form/fieldset/button");
    	driver.findElement(submitButton).click();
    	
    	wait.until(textToBePresentInElementLocated(By.tagName("p"), "Popular Tags"));
    }
}