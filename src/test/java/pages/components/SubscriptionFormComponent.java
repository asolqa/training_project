package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class SubscriptionFormComponent {
        private final SelenideElement subscribeForm = $(".subscribe_frame"),
                                      subscribeFormTitle = $(".form_head"),
                                      emailForSubscriptionField = $("[type=email]"),
                                      submitSubscription = $("[name=web_form_submit]"),
                                      subscriptionError = $("#POPUP_EMAIL-error"),
                                      closeSubscription =$(".close");


        public void verifySubscriptionForm() {

            subscribeForm.should(appear);
            subscribeFormTitle.shouldHave(text("Подписка на рассылку"));
            emailForSubscriptionField.shouldBe(visible);
            submitSubscription.shouldBe(visible).click();
            subscriptionError.shouldHave(text("Заполните это поле"));
            closeSubscription.shouldBe(visible).click();
            subscribeForm.shouldNotBe(visible);

        }
}
