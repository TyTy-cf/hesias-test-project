package fr.kevin.cap_enterprise.tests;

import fr.kevin.cap_enterprise.pages.HomePage;
import fr.kevin.cap_enterprise.pages.SearchResultPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchResultTest extends BaseTest {

    @Test
    @Feature("Filters")
    @Story("As the user, I want to change the filters 'Prix croissant' on the website")
    @Severity(SeverityLevel.NORMAL)
    public void testChangeFilters() {
        SearchResultPage rsp = new HomePage(getDriver()) // return HomePage
                .searchItem("Cyberpunk") // return SearchResultPage
                .changeFilters();

        Assert.assertTrue(rsp.getCurrentUrl().contains("sort_by=Price_ASC"));
    }

}
