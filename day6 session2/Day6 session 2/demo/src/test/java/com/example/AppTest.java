package com.example;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
// import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.devtools.v121.indexeddb.model.Key;
// import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://economictimes.indiatimes.com/et-now/results");
        WebElement ele = driver.findElement(By.linkText("Mutual Funds"));
        // Thread.sleep(5000);
        ele.click();
        // Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
        Select dp = new Select(driver.findElement(By.xpath("//*[@id='amcSelection']")));
        dp.selectByVisibleText("Canara Robeco");
        Thread.sleep(2000);
        Select dpb = new Select(driver.findElement(By.name("schemenm")));
        dpb.selectByVisibleText("Canara Robeco Bluechip Equity Direct-G");
        driver.findElement(By.linkText("Get Details")).click();
        String currTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(currTab)) {
                driver.switchTo().window(tab);
            }
        }
        driver.findElement(By.xpath("//*[@id='installment_type']/li/i")).click();
        driver.findElement(By.xpath("//*[@id='installment_type']/li/ul/li[1]/span")).click();
        driver.findElement(By.xpath("//*[@id='installment_amt']/li/i")).click();
        driver.findElement(By.xpath("//*[@id='installment_amt']/li/ul/li[3]/span")).click();
        driver.findElement(By.xpath("//*[@id='installment_period']/li/i")).click();
        driver.findElement(By.xpath("//*[@id='installment_period']/li/ul/li[3]/span")).click();
        driver.findElement(By.xpath("//*[@id='mfNav']/div/ul/li[2]")).click();
        WebElement table = driver.findElement(By.xpath("//*[@id='mfReturns']/div[2]/div[2]"));
        WebElement firstRow = table
                .findElement(By.xpath("//*[@id='mfReturns']/div[2]/div[2]/ul/li[1]/table/tbody/tr[1]"));
        try {
            List<WebElement> cells = firstRow.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                System.out.println(cell.getText() + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(true);
    }
}