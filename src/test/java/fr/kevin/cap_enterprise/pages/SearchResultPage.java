package fr.kevin.cap_enterprise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage {

    private final By filterBtn = By.cssSelector("button#sort_by_trigger");
    private final By filterPriceAsc = By.cssSelector("a#Price_ASC");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean isUrlContains(String query) {
        return getCurrentUrl().contains(query);
    }

    public SearchResultPage changeFilters() {
        waitClick(filterBtn).click();
        waitClick(filterPriceAsc).click();
        return this;
    }

}
