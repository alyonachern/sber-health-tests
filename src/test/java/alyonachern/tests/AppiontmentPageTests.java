package alyonachern.tests;

import alyonachern.pages.AppointmentPage;
import alyonachern.pages.MainPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Feature("Страница записи на приём к врачу")
public class AppiontmentPageTests extends BaseTest {

    MainPage mainPage = new MainPage();
    AppointmentPage appointmentPage = new AppointmentPage();

    @ParameterizedTest(name = "Проверка заголовка контента при сортировке по метро: {0}")
    @ValueSource(strings = {"Академическая", "Беляево"})
    void checkTitleSortedByMetroTest(String text) {
        mainPage.openMainPage()
                .clickOnAppoinmentLink();

        appointmentPage.setLocation(text)
                .submit()
                .checkTitleOfLocation(text);
    }

    @Test
    @DisplayName("При активации чекбокса \"Детский врач\" отображаются детские врачи")
    void selectChildDoctorTest() {
        mainPage.openMainPage()
                .clickOnAppoinmentLink();

        appointmentPage.activateKidCheckbox()
                .checkAdultDoctorsHidden()
                .checkKidTitleAppears();
    }
}
