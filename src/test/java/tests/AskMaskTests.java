package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AskMaskMainPage;

@Feature("Smoke Tests")
public class AskMaskTests extends TestBase {

    AskMaskMainPage askMaskMainPage = new AskMaskMainPage();

    @DisplayName("Main Page test")
    @Tag("smoke")
    @Order(1)
    @Test
    public void mainPageElementsTest() {

        askMaskMainPage.openPage()
                .verifyElementsAreLoaded();
    }

    @DisplayName("Official brands test")
    @Tag("smoke")
    @Order(2)
    @Test
    public void officialDistributionBrandsAreShownInMenuTest() {

        askMaskMainPage.openPage()
                .verifyOfficialDistributionBrandsArePresented();

    }

    @DisplayName("Contact Page test")
    @Tag("smoke")
    @Order(3)
    @Test
    public void contactPageContainsActualInfoTest() {

        askMaskMainPage.openPage()
                .verifyContacts();
    }

    @DisplayName("Subscription test")
    @Tag("smoke")
    @Order(4)
    @Test
    public void subscriptionAvailableTest() {

        askMaskMainPage.openPage()
                .verifySubscription();
    }

    @DisplayName("Search product test")
    @Tag("smoke")
    @Order(5)
    @Test
    public void searchForProductTest() {

        askMaskMainPage.openPage()
                .verifySearchForProduct();

    }

}