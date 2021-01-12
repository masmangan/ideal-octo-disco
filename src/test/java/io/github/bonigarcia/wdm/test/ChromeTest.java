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
import static org.hamcrest.CoreMatchers.containsString;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Random;

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
    public void buscaQualidadeProdutoMoodlePucrs() { 
		 
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.get("https://moodle.pucrs.br/");
		 
		By user = By.id("login_username");
		wait.until(presenceOfElementLocated(user));
		driver.findElement(user).sendKeys("11109498"); 
                 
            By pass =  By.id("login_password"); wait.until(presenceOfElementLocated(pass));
		driver.findElement(pass).sendKeys("SenhaIncorreta");
		 
		By searchButton = By.className("button");
		wait.until(elementToBeClickable(searchButton));
		driver.findElement(searchButton).click();
                 
            By targetInput = By.tagName("body");
            assertThat(driver.findElement(targetInput).getText(), containsString("4637E-02 - Qualidade de Produto"));
                 
	 }
         
         
    @Test
    public void signUpWordpress() {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        String username = "priscilla.pucrs" + new Random().nextInt(Integer.MAX_VALUE);
        String email = username + "@gmail.com";
        String password = "*3pPL3D6fKjY";

        driver.get("https://wordpress.com/start/user/");

        //By joinButton = By.xpath("//a[contains(., 'Sign Up')]");
        //wait.until(presenceOfElementLocated(joinButton));
        //driver.findElement(joinButton).click();

        By emailField = By.id("email");
        wait.until(presenceOfElementLocated(emailField));
        driver.findElement(emailField).sendKeys(email);

        By usernameField = By.id("username");
        wait.until(presenceOfElementLocated(usernameField));
        driver.findElement(usernameField).sendKeys(username);

        By passwordField = By.id("password");
        wait.until(presenceOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);

        By signUpButton = By.xpath("//button[contains(., 'Create your account')]");
        wait.until(elementToBeClickable(signUpButton));
        driver.findElement(signUpButton).click();
            
            By nextStep = By.className("formatted-header__title");
            wait.until(presenceOfElementLocated(nextStep));
            wait.until(textToBePresentInElementLocated(nextStep,"Let's get your site"));
            assertThat(driver.findElement(nextStep).getText(), containsString("Let's get your site"));
             
        }

    @Test
    public void testLojasAmericanas() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get("https://www.americanas.com.br/");
        By searchInput = By.id("h_search-input");
        wait.until(presenceOfElementLocated(searchInput));
        driver.findElement(searchInput).sendKeys("Livros");
        By searchButton = By.id("h_search-btn");
        wait.until(elementToBeClickable(searchButton));
        driver.findElement(searchButton).click();

        wait.until(textToBePresentInElementLocated(By.tagName("body"),
                "livro - do mil ao milhão"));
    }
         

}