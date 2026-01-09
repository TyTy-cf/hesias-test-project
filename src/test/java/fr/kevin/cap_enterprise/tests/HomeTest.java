package fr.kevin.cap_enterprise.tests;

import fr.kevin.cap_enterprise.pages.HomePage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeTest extends BaseTest {

    @Test
    public void testSearchSuccess() {
        String currentUrl = new HomePage(driver) // return HomePage
                .searchItem("Cyberpunk") // return SearchResultPage
                .getCurrentUrl(); // return the currentUrl (String)

        assertTrue(currentUrl.contains("/search?term=Cyberpunk"));
    }

}
