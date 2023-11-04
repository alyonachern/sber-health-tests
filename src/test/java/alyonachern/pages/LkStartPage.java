package alyonachern.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LkStartPage {

    private SelenideElement content = $("#root");

    private String titleOfNonReg = "Войдите, чтобы продолжить";

    @Step("Проверить текст для незарегистрированного пользователя")
    public void checkNonRegTitle() {
        content.shouldHave(text(titleOfNonReg));
    }
}
