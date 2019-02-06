package com.united.automation.basic;
import org.junit.*;
import com.united.automation.selenium.BrowserLaunch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class FuelTests extends BrowserLaunch {
WebDriver driver;

    @Before
    public void setup() throws IOException {
        BrowserLaunch openBrowser = new BrowserLaunch();
        driver = openBrowser.signInApplication();
    }
    @After
    public void tearDown() {
       driver.quit();
    }

    @Test
    public void testSearch() {
        driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
        driver.findElement(By.id("searchStoreAdd")).click();
        driver.findElement(By.id("searchStoreAdd")).clear();
        driver.findElement(By.id("searchStoreAdd")).sendKeys("6025 Padbury");
        driver.findElement(By.className("btn btn-default store_find_submit")).click();
    }

    @Test
    public void tapOnFuelHeader() throws InterruptedException {
    driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[3]/header/div/nav/ul/li[2]/a")).click();
    driver.manage().wait(2000);
    String ActualHeader = driver.findElement(By.xpath("//h2[@class='g_title']")).getText();
    Assert.assertEquals("Fuel headers doesn't match", "United Fuels", ActualHeader);
    }
}
