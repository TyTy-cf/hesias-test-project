package fr.kevin.cap_enterprise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private By inputSearch = By.cssSelector("input[name='term']");
    private By submitBtn = By.cssSelector("button[class='_1Yo-ZsBr-KbVMyAMXEYszd']");
    private By refuseCookies = By.cssSelector("div[id='rejectAllButton']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage searchItem(String search) {
        goTo(ROOT_URL); // Go to the URL page
        try {
            WebElement cookiesBtn = wait.until(ExpectedConditions.elementToBeClickable(refuseCookies));
            cookiesBtn.click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(refuseCookies));
        } catch (TimeoutException e) {
            // Les cookies ont peut-être déjà été acceptés dans une session précédente
        }
        type(inputSearch, search); // type into the search input
        waitClick(submitBtn).click(); // wait for the submit btn to be clikable and click it
        return new SearchResultPage(this.driver); // after we've done the search, redirect top SearchResultPage
    }

}