package tests;

import org.junit.jupiter.api.Test;
import pages.AskMaskMainPage;


public class AskMaskTests extends TestBase {

    AskMaskMainPage askMaskMainPage = new AskMaskMainPage();

    @Test
    public void mainPageElementsTest() {

        askMaskMainPage.openPage()
                .verifyElementsAreLoaded();
    }

    @Test
    public void officialDistributionBrandsAreShownInMenuTest() {
        //SelenideLogger.addListener("allure", new AllureSelenide());

        askMaskMainPage.openPage()
                .verifyOfficialDistributionBrandsArePresented();

    }

    @Test
    public void contactPageContainsActualInfoTest() {

        askMaskMainPage.openPage()
                .verifyContacts();
    }

    @Test
    public void subscriptionAvailableTest() {


        askMaskMainPage.openPage()
                .verifySubscription();
    }

    @Test
    public void searchForProductTest() {

        askMaskMainPage.openPage()
                .verifySearchForProduct();

    }

}