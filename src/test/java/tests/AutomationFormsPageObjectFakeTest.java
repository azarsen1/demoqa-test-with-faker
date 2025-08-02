package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import utils.RandomTestData;

public class AutomationFormsPageObjectFakeTest extends TestBaseConfig {

    RegistrationFormPage RegistrationFormPage = new RegistrationFormPage();
    RandomTestData RandomTestData = new utils.RandomTestData();

    @Test
    void smokeFillFormTest() {

        RegistrationFormPage.openPage()
                .removeBanner()
                .setFirstName(RandomTestData.firstName)
                .setLastName(RandomTestData.lastName)
                .setUserEmail(RandomTestData.emailAddress)
                .setGender(RandomTestData.gender)
                .setUserNumber(RandomTestData.userNumber)
                .setDateOfBirth(RandomTestData.day, RandomTestData.month, RandomTestData.year)
                .setSubjects(RandomTestData.subjects)
                .setHobbiesCheckbox(RandomTestData.hobbiesCheckbox)
                .setUploadPicture(RandomTestData.uploadPicture)
                .setCurrentAddress(RandomTestData.currentAddress)
                .setState(RandomTestData.state)
                .setCity(RandomTestData.city)
                .clickSubmit();

        RegistrationFormPage.checkResult("Student Name", RandomTestData.firstName + " " + RandomTestData.lastName)
                .checkResult("Student Email", RandomTestData.emailAddress)
                .checkResult("Gender", RandomTestData.gender)
                .checkResult("Mobile", RandomTestData.userNumber)
                .checkResult("Date of Birth", RandomTestData.day + " " + RandomTestData.month + "," + RandomTestData.year)
                .checkResult("Subjects", RandomTestData.subjects)
                .checkResult("Hobbies", RandomTestData.hobbiesCheckbox)
                .checkResult("Picture", RandomTestData.uploadPicture)
                .checkResult("Address", RandomTestData.currentAddress)
                .checkResult("State and City", RandomTestData.state + " " + RandomTestData.city);


    }

    @Test
    void minFillFormTestTest() {
        RegistrationFormPage.openPage()
                .removeBanner()
                .setFirstName(RandomTestData.firstName)
                .setLastName(RandomTestData.lastName)
                .setUserEmail(RandomTestData.emailAddress)
                .setGender(RandomTestData.gender)
                .setUserNumber(RandomTestData.userNumber)
                .setDateOfBirth(RandomTestData.day, RandomTestData.month, RandomTestData.year)
                .clickSubmit();

        RegistrationFormPage.checkResult("Student Name", RandomTestData.firstName + " " + RandomTestData.lastName)
                .checkResult("Student Email", RandomTestData.emailAddress)
                .checkResult("Gender", RandomTestData.gender)
                .checkResult("Mobile", RandomTestData.userNumber)
                .checkResult("Date of Birth", RandomTestData.day + " " + RandomTestData.month + "," + RandomTestData.year);


    }

    @Test
    void negativeFillFormTestTest() {
        RegistrationFormPage.openPage()
                .removeBanner()
                .setFirstName(RandomTestData.invalidFirstName)
                .setLastName(RandomTestData.lastName)
                .setUserEmail(RandomTestData.emailAddress)
                .setGender(RandomTestData.gender)
                .setUserNumber(RandomTestData.userNumber)
                .setDateOfBirth(RandomTestData.day, RandomTestData.month, RandomTestData.year)
                .clickSubmit();

        RegistrationFormPage.shouldHaveFirstName(RandomTestData.invalidFirstName)
                .shouldHaveLastName(RandomTestData.lastName)
                .shouldHaveUserEmail(RandomTestData.emailAddress)
                .shouldHaveGender(RandomTestData.gender)
                .shouldHaveUserNumber(RandomTestData.userNumber)
                .shouldHaveDateOfBirth(RandomTestData.day + " " + RandomTestData.month + "," + RandomTestData.year);
    }

}
