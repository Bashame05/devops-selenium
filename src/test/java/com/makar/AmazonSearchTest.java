package com.makar;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AmazonSearchTest {

    @Test
    public void searchAmazonProduct() {

        WebDriver driver = new ChromeDriver();

        try {
            // Maximize browser window
            driver.manage().window().maximize();

            // Open Amazon India
            driver.get("https://www.amazon.in/");

            // Wait for search box to become visible
            WebDriverWait wait = new WebDriverWait(
                    driver, Duration.ofSeconds(15)
            );

            WebElement searchBox = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.id("twotabsearchtextbox")
                    )
            );

            // Search for laptop
            searchBox.sendKeys("laptop" + Keys.ENTER);

            // Wait for search results to appear
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector("div.s-main-slot")
                    )
            );

            // Verify search results page
            Assert.assertTrue(
                    driver.getTitle().toLowerCase().contains("laptop"),
                    "Search results page did not open correctly."
            );

            System.out.println("Amazon laptop search test passed.");

        } finally {
            // Close browser
            driver.quit();
        }
    }
}
