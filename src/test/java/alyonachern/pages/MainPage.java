package alyonachern.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private String phoneNumber = "8 800 100 35 98",
    appPromotionText = "СберЗдоровье\n" + "Проверенные врачи у вас в телефоне",
    appointmentText = "Приём врача в клинике";

    private SelenideElement phoneOfContactCenter = $(".the-header__phone-number"),
    appPromotion = $(".download-mobile-app__wrapper"),
    lkButton = $("a.the-header__login"),
    headerLinks = $(".the-header__links");

    @Step("Открыть главную страницу")
    public MainPage openMainPage() {
        open(baseUrl);
        return this;
    }

    @Step("Проверить номер телефона контакт-центра")
    public void checkPhone() {
        phoneOfContactCenter.shouldHave(text(phoneNumber));
    }

    @Step("Проверить текст рекламы приложения")
    public void checkAppPromotion() {
        appPromotion.shouldHave(text(appPromotionText));
    }

    @Step("Кликнуть на кнопку личного кабинета")
    public void clickOnLkButton() {
        lkButton.click();
    }

    @Step("Кликнуть на кнопку \"Приём врача в клинике\"")
    public void clickOnAppoinmentLink() {
        headerLinks.find(withText(appointmentText)).click();
    }
}
