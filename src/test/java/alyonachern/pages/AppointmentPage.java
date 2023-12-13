package alyonachern.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class AppointmentPage {

    private final SelenideElement locationField = $("[data-testid=\"search-form__location-field\"]"),
            locationFieldDropdown = locationField.$("[aria-labelledby=\"search-form__location-field__input_combobox-title\"]"),
            locationHiddenDropdown = $("[id=\"search-form__location-field__input_combobox-select\"]"),
            submitButton = $("button[type=\"submit\"]"),
            titleMain = $(".hebs1ko"),
            titleOfAdultDoctors = $(".tu6cc6d").find(withText("Популярные специальности для взрослых")),
            kidReceptionCheckbox = $$("span").findBy(matchText("Детский врач"));

    @Step("Установить локацию {text}")
    public AppointmentPage setLocation(String text) {
        locationField.click();
        locationFieldDropdown.setValue(text);
        locationHiddenDropdown.shouldHave(exactText(text));
        locationHiddenDropdown.hover().click();
        return this;
    }

    @Step("Открыть страницу записи к врачу")
    public AppointmentPage openPage() {
        open("https://docdoc.ru/doctor");
        return this;
    }

    @Step("Нажать кнопку \"Найти\"")
    public AppointmentPage submit() {
        submitButton.hover().click();
        return this;
    }

    @Step("Проверить, что отображается заголовок для метро {text}")
    public void checkTitleOfLocation(String text) {
        titleMain.shouldHave(text("Все врачи рядом с метро " + text + ", Москва"), Duration.ofSeconds(10));
    }

    @Step("Активировать чекбокс \"Детский врач\"")
    public AppointmentPage activateKidCheckbox() {
        kidReceptionCheckbox.click();
        return this;
    }

    @Step("Проверить, что блок со специальностями для взрослых исчез")
    public AppointmentPage checkAdultDoctorsHidden() {
        titleOfAdultDoctors.should(disappear);
        return this;
    }

    @Step("Проверить, что отображается заголовок для детских врачей")
    public void checkKidTitleAppears() {
        titleMain.shouldHave(text("Все детские врачи"));
    }
}
