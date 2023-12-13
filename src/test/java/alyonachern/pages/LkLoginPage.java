package alyonachern.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LkLoginPage {

    private final SelenideElement content = $("#root"),
            phoneErrorAlert = $("[data-testid=\"login-page-phone-error\"]"),
            phoneField = $("#phone"),
            submitButton = $("[data-testid=\"login-page-submit-button\"]");

    private final String titleOfNonReg = "Войдите, чтобы продолжить";

    @Step("Проверить текст для незарегистрированного пользователя")
    public void checkNonRegTitle() {
        content.shouldHave(text(titleOfNonReg));
    }

    @Step("Ввести номер телефона: {phone}")
    public LkLoginPage setPhone(String phone) {
        phoneField.click();
        phoneField.setValue(phone);
        return this;
    }

    @Step("Нажать \"Получить код\"")
    public LkLoginPage getCode() {
        submitButton.click();
        return this;
    }

    @Step("Проверить появление ошибки валидации: {validationError}")
    public void checkValidationError(String validationError) {
        phoneErrorAlert.shouldHave(text(validationError));
    }
}
