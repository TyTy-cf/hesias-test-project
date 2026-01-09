package fr.kevin.cap_enterprise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean isUrlContains(String query) {

        return getCurrentUrl().contains(query);
    }

}
