package alyonachern.tests;

import alyonachern.pages.AppointmentPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Feature("Страница записи на приём к врачу")
public class AppointmentPageTests extends BaseTest {

    AppointmentPage appointmentPage = new AppointmentPage();

    @ParameterizedTest(name = "Проверка заголовка контента при сортировке по метро: {0}")
    @ValueSource(strings = {"Академическая", "Беляево"})
    void checkTitleSortedByMetroTest(String text) {
       appointmentPage.openPage()
                .setLocation(text)
                .submit()
                .checkTitleOfLocation(text);
    }

    @Test
    @DisplayName("При активации чекбокса \"Детский врач\" отображаются детские врачи")
    void selectChildDoctorTest() {
        appointmentPage.openPage()
                .activateKidCheckbox()
                .checkAdultDoctorsHidden()
                .checkKidTitleAppears();
    }
}
