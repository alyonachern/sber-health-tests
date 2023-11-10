package alyonachern.tests;

import alyonachern.pages.LkLoginPage;
import alyonachern.pages.MainPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Feature("Вход в личный кабинет")
public class LkLoginTest extends BaseTest {

    MainPage mainPage = new MainPage();
    LkLoginPage lkStartPage = new LkLoginPage();

    private String errorWrongFormat = "Неверный формат номера телефона",
            errorEmptyField = "Вы не заполнили поле",
            phoneNumber = "0000000000";

    @Test
    @DisplayName("По нажатию кнопки \"Личный кабинет\" происходит переход на страницу авторизации")
    @Tags({@Tag("local"), @Tag("prod")})
    void checkAppointmentPageTest() {
        mainPage.openMainPage()
                .clickOnLkButton();

        lkStartPage.checkNonRegTitle();
    }

    @Test
    @DisplayName("При отправке на номер +7 000 000 0000 происходит ошибка валидации")
    @Tags({@Tag("local"), @Tag("prod")})
    void validationErrorWrongFormatTest() {
        mainPage.openMainPage()
                .clickOnLkButton();

        lkStartPage.setPhone(phoneNumber)
                .getCode()
                .checkValidationError(errorWrongFormat);
    }

    @Test
    @DisplayName("При сабмите формы с незаполненным номером происходит ошибка валидации")
    @Tags({@Tag("local"), @Tag("prod")})
    void validationErrorEmptyPhoneTest() {
        mainPage.openMainPage()
                .clickOnLkButton();

        lkStartPage.getCode()
                .checkValidationError(errorEmptyField);
    }
}
