package alyonachern.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private final SelenideElement phoneOfContactCenter = $(".the-header__phone-number"),
            appPromotion = $(".download-mobile-app__wrapper"),
            lkButton = $("a.the-header__login");

    @Step("Открыть главную страницу")
    public MainPage openMainPage() {
        open(baseUrl);
        return this;
    }

    @Step("Проверить номер телефона контакт-центра")
    public void checkPhone(String phoneNumber) {
        phoneOfContactCenter.shouldHave(text(phoneNumber));
    }

    @Step("Проверить текст рекламы приложения")
    public void checkAppPromotion(String appPromotionText) {
        appPromotion.shouldHave(text(appPromotionText));
    }

    @Step("Кликнуть на кнопку личного кабинета")
    public void clickOnLkButton() {
        lkButton.click();
    }
}
