package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import utils.RandomTestData;

public class AutomationFormsPageObjectFakeTest extends TestBaseConfig {

    RegistrationFormPage RegistrationFormPage = new RegistrationFormPage();
    RandomTestData RandomTestData = new utils.RandomTestData();

    String firstName = RandomTestData.getFirstName();
    String lastName = RandomTestData.getLastName();
    String emailAddress = RandomTestData.getEmailAddress();
    String gender = RandomTestData.getGender();
    String userNumber = RandomTestData.getUserNumber();
    String day = RandomTestData.getDay();
    String month = RandomTestData.getMonth();
    String year = RandomTestData.getYear();
    String subjects = RandomTestData.getSubjects();
    String hobbiesCheckbox = RandomTestData.getHobbiesCheckbox();
    String uploadPicture = RandomTestData.getUploadPicture();
    String currentAddress = RandomTestData.getCurrentAddress();
    String state = RandomTestData.getState();
    String city = RandomTestData.getCity();

    @Test
    void smokeFillFormTest() {


        RegistrationFormPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(emailAddress)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(day, month, year)
                .setSubjects(subjects)
                .setHobbiesCheckbox(hobbiesCheckbox)
                .setUploadPicture(uploadPicture)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        RegistrationFormPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", emailAddress)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbiesCheckbox)
                .checkResult("Picture", uploadPicture)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);


    }

    @Test
    void minFillFormTestTest() {
        RegistrationFormPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(emailAddress)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(day, month, year)
                .clickSubmit();

        RegistrationFormPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", emailAddress)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", day + " " + month + "," + year);


    }

    @Test
    void negativeFillFormTestTest() {
        RegistrationFormPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(emailAddress)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(day, month, year)
                .clickSubmit();

        RegistrationFormPage.shouldHaveFirstName(firstName)
                .shouldHaveLastName(lastName)
                .shouldHaveUserEmail(emailAddress)
                .shouldHaveGender(gender)
                .shouldHaveUserNumber(userNumber);
    }

}
