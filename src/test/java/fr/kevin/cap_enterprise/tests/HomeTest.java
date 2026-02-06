package fr.kevin.cap_enterprise.tests;

import fr.kevin.cap_enterprise.pages.HomePage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    @Test
    @Feature("Searchbar")
    @Story("As the user, I want to search 'Cybepunk' on the website")
    @Description("Click on the search button, then type 'Cyberpunk' to search for it")
    @Severity(SeverityLevel.NORMAL)
    public void testSearchSuccess() {
        String currentUrl = new HomePage(driver) // return HomePage
                .searchItem("Cyberpunk") // return SearchResultPage
                .getCurrentUrl(); // return the currentUrl (String)

        Assert.assertTrue(currentUrl.contains("term=Cyberpunk"));
    }

}
