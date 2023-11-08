package alyonachern.tests;

import alyonachern.pages.MainPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Feature("Главная страница")
public class MainPageTests extends BaseTest {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("На главной странице есть номер телефона контакт-центра")
    @Tags({@Tag("local"), @Tag("prod")})
    void checkPhoneNumberTest() {
        mainPage.openMainPage()
                .checkPhone();
    }

    @Test
    @DisplayName("На главной странице есть реклама приложения")
    @Tags({@Tag("local"), @Tag("prod")})
    void checkAppPromotionTest() {
        mainPage.openMainPage()
                .checkAppPromotion();
    }
}