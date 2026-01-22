package fr.kevin.cap_enterprise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By inputSearch = By.cssSelector("input[placeholder='Rechercher dans le magasin']");
    private By submitBtn = By.cssSelector("button[class='_1Yo-ZsBr-KbVMyAMXEYszd']");
    private By refuseCookies = By.cssSelector("div[id='rejectAllButton']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage searchItem(String search) {
        goTo(ROOT_URL); // Go to the URL page
        String headless = System.getenv("HEADLESS");
        if ("true".equalsIgnoreCase(headless)) {
            waitClick(refuseCookies).click(); // wait for the "refuseCookie" button to be clickable and click it
        }
        type(inputSearch, search); // type into the search input
        waitClick(submitBtn).click(); // wait for the submit btn to be clikable and click it
        return new SearchResultPage(this.driver); // after we've done the search, redirect top SearchResultPage
    }

}