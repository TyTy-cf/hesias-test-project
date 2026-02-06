package fr.kevin.cap_enterprise.tests;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    protected void setUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        driver.set(new RemoteWebDriver(new URL("http://localhost:4444"), options));
        driver.get().manage().window().maximize();
    }

    @AfterMethod
    public void quit() {
        WebDriver webDriver = driver.get();
        if (webDriver != null) {
            try {
                saveScreenshot();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            webDriver.quit();
            driver.remove();
        }
    }

    @Attachment(fileExtension = ".png", type = "image/png", value = "Screenshot of the test")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) driver.get()).getScreenshotAs(OutputType.BYTES);
    }

    protected WebDriver getDriver() {
        return driver.get();
    }
}
