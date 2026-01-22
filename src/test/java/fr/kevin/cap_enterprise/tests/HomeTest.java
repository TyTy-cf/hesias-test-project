package fr.kevin.cap_enterprise.tests;

import fr.kevin.cap_enterprise.pages.HomePage;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

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

        assertTrue(currentUrl.contains("term=Cyberpunk"));
    }


    @Test
    @Feature("Searchbar")
    @Story("As the user, I want to search 'Arc raider' on the website")
    @Description("Click on the search button, then type 'Arc raider' to search for it")
    @Severity(SeverityLevel.NORMAL)
    public void testSearchFailed() {
        String currentUrl = new HomePage(driver) // return HomePage
                .searchItem("Arc raider") // return SearchResultPage
                .getCurrentUrl(); // return the currentUrl (String)

        System.out.println(currentUrl);
        assertTrue(currentUrl.contains("term=Cyberpunk"));
    }

}
