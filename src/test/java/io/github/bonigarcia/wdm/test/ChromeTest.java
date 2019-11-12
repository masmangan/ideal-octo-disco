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
    public void testAddNewOwner() {
        // Your test code here. For example:
        WebDriverWait wait = new WebDriverWait(driver, 300);
        driver.get("http://10.32.161.142:8080/owners/find");
        By btnAddOwners = By.linkText("Add Owner");
        wait.until(presenceOfElementLocated(btnAddOwners));
        wait.until(elementToBeClickable(btnAddOwners));
        driver.findElement(btnAddOwners).click();
        
        assertEquals("http://10.32.161.142:8080/owners/new", driver.getCurrentUrl());
        
        By fieldFirstName = By.id("firstName");
        By fieldLastName = By.id("lastName");
        By fieldAddress = By.id("address");
        By fieldCity = By.id("city");
        By fieldTelephone = By.id("telephone");
        btnAddOwners = By.xpath("//*[@id='add-owner-form']/div[2]/div/button");
        
        wait.until(presenceOfElementLocated(fieldTelephone));
        
        String firstNameVal = "Nome";
        String fieldLastNameVal = "Qualquer";
        String fieldAddressVal = "Endereço, 380";
        String fieldCityVal = "Porto Alegre";
        String fieldTelephoneVal = "999999";
        
        driver.findElement(fieldFirstName).sendKeys(firstNameVal);
        driver.findElement(fieldLastName).sendKeys(fieldLastNameVal);
        driver.findElement(fieldAddress).sendKeys(fieldAddressVal);
        driver.findElement(fieldCity).sendKeys(fieldCityVal);
        driver.findElement(fieldTelephone).sendKeys(fieldTelephoneVal);
        
        driver.findElement(btnAddOwners).click();
        
        By btnEditOwners = By.linkText("Edit Owner");
        wait.until(presenceOfElementLocated(btnEditOwners));
        wait.until(elementToBeClickable(btnEditOwners));
    }
    
    @Test
    public void testErrorPage() {
        // Your test code here. For example:
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get("http://10.32.161.142:8080/kkkkkk");  
        By text = By.tagName("h2");
        wait.until(presenceOfElementLocated(text));
        String errorText = driver.findElement(text).getText();
        
        assertEquals("Something happened...", errorText);
      
    }
    
    

}