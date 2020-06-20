package io.github.bonigarcia.wdm.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class AugustoKlaicTest {

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
    public void testListVeterinarians() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get("http://10.32.161.142:8080/");
        driver.findElement(By.xpath("//*[@id=\"main-navbar\"]/ul/li[4]/a")).click();
        wait.until(presenceOfAllElementsLocatedBy(By.id("vets")));

        wait.until(textToBePresentInElementLocated(By.id("vets"),
                "James Carter"));
    }

    @Test
    public void testAddPet() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get("http://10.32.161.142:8080/");
        driver.findElement(By.xpath("//*[@id=\"main-navbar\"]/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"search-owner-form\"]/div[2]/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"owners\"]/tbody/tr[7]/td[1]/a")).click();
        driver.findElement(By.xpath("/html/body/div/div/a[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Cachorrinho");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"birthDate\"]")).sendKeys("2018-04-03");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"type\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"type\"]/option[3]")).click();
        driver.findElement(By.xpath("/html/body/div/div/form/div[2]/div/button")).click();
    }

}
