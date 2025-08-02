
package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
        import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Condition.value;


public class RegistrationFormPage {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationFormPage.class);


    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement userEmailInput = $("#userEmail");
    SelenideElement genderRadioButton = $("#genterWrapper");
    SelenideElement userNumberInput = $("#userNumber");
    SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    SelenideElement subjectsInput = $("#subjectsInput");
    SelenideElement hobbiesCheckbox = $("#hobbiesWrapper");
    SelenideElement uploadPictureInput = $("#uploadPicture");
    SelenideElement currentAddress = $("#currentAddress");
    SelenideElement stateInput = $("#state");
    SelenideElement cityInput = $("#city");
    SelenideElement buttonSubmit = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        logger.info("Открытие формы: https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }


    public RegistrationFormPage removeBanner() {
        $("#fixedban").shouldBe(visible);
        $("footer").shouldBe(visible);
        logger.info("Удаление баннеров со страницы");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }


    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setGender(String value) {
        genderRadioButton.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage setSubjects(String value) {
        subjectsInput.setValue(value);
        $$(".subjects-auto-complete__menu-list div").findBy(text(value)).click();
        return this;
    }

    public RegistrationFormPage setHobbiesCheckbox(String value) {
        hobbiesCheckbox.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setUploadPicture(String value) {
        uploadPictureInput.uploadFromClasspath(value);
        return this;
    }

    public RegistrationFormPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationFormPage setState(String value) {
        stateInput.click();
        $("#react-select-3-input").setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage setCity(String value) {
        cityInput.click();
        $("#react-select-4-input").setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage clickSubmit() {
        buttonSubmit.click();
        return this;


    }

    public RegistrationFormPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }
    public RegistrationFormPage shouldHaveFirstName(String expectedValue) {

        if (expectedValue.isEmpty()) {
            firstNameInput.shouldBe(Condition.empty);
        } else {
            firstNameInput.shouldHave(Condition.value(expectedValue));
        }

        return this;
    }

    public RegistrationFormPage shouldHaveLastName(String expectedValue) {

        if (expectedValue.isEmpty()) {
            lastNameInput.shouldBe(Condition.empty);
        } else {
            lastNameInput.shouldHave(Condition.value(expectedValue));
        }
        return this;
    }

    public RegistrationFormPage shouldHaveUserEmail(String expectedValue) {

        if (expectedValue.isEmpty()) {
            userEmailInput.shouldBe(Condition.empty);
        } else {
            userEmailInput.shouldHave(Condition.value(expectedValue));
        }
        return this;
    }

    public RegistrationFormPage shouldHaveGender(String expectedValue) {
        genderRadioButton.$("input[name='gender'][value='" + expectedValue + "']")
                .shouldBe(Condition.selected);

        return this;
    }

    public RegistrationFormPage shouldHaveDateOfBirth(String expectedDate) {
        $("#dateOfBirthInput").shouldHave(Condition.value(expectedDate));
        return this;
    }
}
