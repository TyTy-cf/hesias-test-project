package fr.kevin.cap_enterprise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeEach
    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    public void quit() {
        driver.quit();
    }

    protected WebElement waitUntil(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    @Test
    public void testAccessPage() {
        driver.get("https://www.instant-gaming.com/fr/");

        WebElement searchIcon = waitUntil(By.cssSelector("div.icon-search-input"));
        searchIcon.click();

        WebElement inputSearch = waitUntil(By.cssSelector("input#ig-header-search-box-input"));
        inputSearch.sendKeys("World");

        // Check title
        WebElement title = waitUntil(By.cssSelector("h2.search-quantity-result"));
        assertEquals("646 résultats", title.getText());

        // Check items on page
        List<WebElement> allCardGames = driver.findElements(By.cssSelector("article.force-badge"));
        assertEquals(60, allCardGames.size());

        // Click link - check forward to url
        WebElement link = waitUntil(By.cssSelector("a[title='Accueil']"));
        link.click();
        assertEquals("https://www.instant-gaming.com/fr/", driver.getCurrentUrl());
    }

}