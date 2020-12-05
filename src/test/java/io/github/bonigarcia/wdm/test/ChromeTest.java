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
    public void testJoinExpo() {
    	WebDriverWait wait = new WebDriverWait(driver, 30);
    	
    	String username = "edgindri" + new Random().nextInt(Integer.MAX_VALUE);
    	String email = username + "@gmail.com";
    	String password = "12345678@abc";
    	
    	driver.get("https://expo.io/");
    	
    	By joinButton = By.xpath("//a[contains(., 'Sign Up')]");
    	wait.until(presenceOfElementLocated(joinButton));
    	driver.findElement(joinButton).click();
    	
    	By emailField = By.id("email");
    	wait.until(presenceOfElementLocated(emailField));
    	driver.findElement(emailField).sendKeys(email);
    	
    	By usernameField = By.id("username");
    	wait.until(presenceOfElementLocated(usernameField));
    	driver.findElement(usernameField).sendKeys(username);
    	
    	By passwordField = By.id("password");
    	wait.until(presenceOfElementLocated(passwordField));
		driver.findElement(passwordField).sendKeys(password);

    	By confirmPasswordField = By.id("confirmPassword");
    	wait.until(presenceOfElementLocated(confirmPasswordField));
    	driver.findElement(confirmPasswordField).sendKeys(password);

    	By signUpButton = By.xpath("//button[contains(., 'Sign Up')]");
    	wait.until(presenceOfElementLocated(signUpButton));
    	driver.findElement(signUpButton).click();
    	
    	wait.until(presenceOfElementLocated(By.xpath("//span[contains(., 'Home')]")));
    }
    
    @Test
    public void testLoginExpo() {
    	WebDriverWait wait = new WebDriverWait(driver, 30);
    	
    	driver.get("https://expo.io/");
    	
    	By loginButton = By.xpath("//a[contains(., 'Log In')]");
    	wait.until(presenceOfElementLocated(loginButton));
    	driver.findElement(loginButton).click();
    	
    	By usernameField = By.id("username");
    	wait.until(presenceOfElementLocated(usernameField));
    	driver.findElement(usernameField).sendKeys("edgindri1");

    	String password = "12345678@abc";
    	
    	By passwordField = By.id("password");
    	wait.until(presenceOfElementLocated(passwordField));
		driver.findElement(passwordField).sendKeys(password);

    	loginButton = By.xpath("//button[contains(., 'Log In')]");
    	wait.until(presenceOfElementLocated(loginButton));
    	driver.findElement(loginButton).click();
    	
    	wait.until(presenceOfElementLocated(By.xpath("//span[contains(., 'Home')]")));
    }
}