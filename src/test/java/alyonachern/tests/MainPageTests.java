package alyonachern.tests;

import alyonachern.pages.LkStartPage;
import alyonachern.pages.MainPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Главная страница")
public class MainPageTests extends BaseTest {

    MainPage mainPage = new MainPage();
    LkStartPage lkStartPage = new LkStartPage();

    @Test
    @DisplayName("На главной странице есть номер телефона контакт-центра")
    void checkPhoneNumberTest() {
        mainPage.openMainPage()
                .checkPhone();
    }

    @Test
    @DisplayName("На главной странице есть реклама приложения")
    void checkAppPromotionTest() {
        mainPage.openMainPage()
                .checkAppPromotion();
    }

    @Test
    @DisplayName("По нажатию кнопки \"Личный кабинет\" происходит переход на страницу авторизации")
    void checkAppointmentPageTest() {
        mainPage.openMainPage()
                .clickOnLkButton();

        lkStartPage.checkNonRegTitle();
    }
}