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
                .checkResult("Date of Birth", RandomTestData.day + " " + RandomTestData.month + " " + RandomTestData.year)
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
                .setFirstName("A")
                .setLastName("A")
                .setUserEmail("a@m.ru")
                .setGender("Male")
                .setUserNumber("8937342615")
                .setDateOfBirth("21", "April", "1996")
                .clickSubmit();

        RegistrationFormPage.checkResult("Student Name", "A A")
                .checkResult("Student Email", "a@m.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8937342615")
                .checkResult("Date of Birth", "21 April,1996");


    }

    @Test
    void negativeFillFormTestTest() {
        RegistrationFormPage.openPage()
                .removeBanner()
                .setFirstName("")
                .setLastName("A")
                .setUserEmail("a@m.ru")
                .setGender("Male")
                .setUserNumber("8937342615")
                .setDateOfBirth("21", "April", "1996")
                .clickSubmit();

        RegistrationFormPage.shouldHaveFirstName("")
                .shouldHaveLastName("A")
                .shouldHaveUserEmail("a@m.ru")
                .shouldHaveGender("Male")
                .shouldHaveDateOfBirth("21 Apr 1996")
        ;
    }

}
