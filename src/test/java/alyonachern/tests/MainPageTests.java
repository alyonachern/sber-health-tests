package alyonachern.tests;

import alyonachern.pages.MainPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Feature("Главная страница")
public class MainPageTests extends BaseTest {

    private final String phoneNumber = "8 800 100 35 98",
            appPromotionText = "СберЗдоровье\n" + "Проверенные врачи у вас в телефоне";

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("На главной странице есть номер телефона контакт-центра")
    @Owner("a.chernyakova")
    @Tags({@Tag("local"), @Tag("prod")})
    void checkPhoneNumberTest() {
        mainPage.openMainPage()
                .checkPhone(phoneNumber);
    }

    @Test
    @DisplayName("На главной странице есть реклама приложения")
    @Owner("a.chernyakova")
    @Tags({@Tag("local"), @Tag("prod")})
    void checkAppPromotionTest() {
        mainPage.openMainPage()
                .checkAppPromotion(appPromotionText);
    }
}