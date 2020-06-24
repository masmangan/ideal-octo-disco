/*
 *
 (C) Copyright 2016 Boni Garcia (http://bonigarcia.github.io/)
 *
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 *
   http://www.apache.org/licenses/LICENSE-2.0
 *
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 Test with Chrome.
 *
 @author Boni Garcia (boni.gg@gmail.com)
 @since 1.0.0
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
		public void testCadastro() {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			driver.get("https://kahoot.com/"); 
			
			
			By signButton = By.linkText("Sign up");
			wait.until(elementToBeClickable(signButton));
			driver.findElement(signButton).click();

			By cadButton = By.className("fZfUwC");
			wait.until(elementToBeClickable(cadButton));
			driver.findElement(cadButton).click();

			By selectorMonth = By.id("month");
			wait.until(presenceOfElementLocated(selectorMonth));
			driver.findElement(selectorMonth).click();
			driver.findElement(By.cssSelector("#month>option[value='1']")).click(); 
			
			By selectorDay = By.id("day");
			wait.until(presenceOfElementLocated(selectorDay));
			driver.findElement(selectorDay).click();
			driver.findElement(By.cssSelector("#day>option[value='10']")).click();
			
			By selectorYear = By.id("year");
			wait.until(presenceOfElementLocated(selectorYear));
			driver.findElement(selectorYear).click();
			driver.findElement(By.cssSelector("#year>option[value='1990']")).click();
			
			By btnContinue = By.className("eQGcdF");
			wait.until(presenceOfElementLocated(btnContinue));
			driver.findElement(btnContinue).click();
			
			By username = By.id("generate-username");
			wait.until(presenceOfElementLocated(username));
			driver.findElement(username).click();
			
			By btnUser = By.className("username-card__SubmitButton-unbvyw-6");
			wait.until(presenceOfElementLocated(btnUser));
			driver.findElement(btnUser).click();
			
			By email = By.id("email");
			wait.until(presenceOfElementLocated(email));
			driver.findElement(email).sendKeys("umemaildealuno@testess.com.br");

			By pass = By.id("password");
			wait.until(presenceOfElementLocated(pass));
			driver.findElement(pass).sendKeys("umaSenhaSegura");
			
			By btnCreate = By.className("submit-button__SubmitButton-ymfytr-0");
			wait.until(presenceOfElementLocated(btnCreate));
			driver.findElement(btnCreate).click();
			
			wait.until(textToBePresentInElementLocated(By.className("profile-add-button__AddInterestButton-sc-124ggrk-0"),
			"Add name"));
		}

}