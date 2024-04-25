package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.SubscriptionFormComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class AskMaskMainPage {
    private final SelenideElement logo =  $(".logo-block"),
                                mainMenu = $(".table-menu"),
                                searchBar = $("#title-search_fixed"),
                                categories = $(".items"),
                                newItems = $("[data-class=catalog_tab_drag]"),
                                saleItems = $("[data-class=sale_drag]"),
                                blogArticles = $("[data-class=blog_drag]"),
                                subscribeButton = $(".subscribe_button"),
                                searchField = $("#title-search-input_fixed");
                                String productTitle = "Dr. Ceuracle, Крем с витамином С";


    ContactPage contactPage = new ContactPage();
    SubscriptionFormComponent subscriptionFormComponent = new SubscriptionFormComponent();
    CatalogPage catalogPage = new CatalogPage();
    ProductPage productPage = new ProductPage();

    public AskMaskMainPage openPage() {
        open("/");
        logo.shouldBe(visible);
        return this;
    }

    public void verifyElementsAreLoaded() {

        mainMenu.shouldHave(text("Успей купить"));
        searchBar.shouldBe(visible);
        categories.shouldBe(visible);
        newItems.shouldHave(text("Новинки"));
        saleItems.shouldHave(text("Акции"));
        blogArticles.shouldHave(text("Последнее в блоге"));

    }

    public void verifyOfficialDistributionBrandsArePresented() {

        mainMenu.$(byText("Бренды")).hover();
        $(withText("Dr.Ceuracle")).should(Condition.exist);
        $(withText("Blithe")).should(Condition.exist);
        $(withText("Sioris")).should(Condition.exist);
        $(withText("Uteki")).should(Condition.exist);

    }

    public void verifySubscription() {

        subscribeButton.click();
        subscriptionFormComponent.verifySubscriptionForm();
    }

    public void verifyContacts(){

        mainMenu.$(byText("Контакты")).click();
        contactPage.verifyContactPageData();

    }

    public void verifySearchForProduct() {

        searchField.setValue(productTitle).pressEnter();
        catalogPage.verifyCatalogPage();
        productPage.verifyProductPage();

    }

}
