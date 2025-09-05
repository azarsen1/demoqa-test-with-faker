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
                .setFirstName(RandomTestData.getFirstName())
                .setLastName(RandomTestData.getLastName())
                .setUserEmail(RandomTestData.getEmailAddress())
                .setGender(RandomTestData.getGender())
                .setUserNumber(RandomTestData.getUserNumber())
                .setDateOfBirth(RandomTestData.day, RandomTestData.month, RandomTestData.year)
                .setSubjects(RandomTestData.getSubjects())
                .setHobbiesCheckbox(RandomTestData.getHobbiesCheckbox())
                .setUploadPicture(RandomTestData.getUploadPicture())
                .setCurrentAddress(RandomTestData.getCurrentAddress())
                .setState(RandomTestData.getState())
                .setCity(RandomTestData.getCity())
                .clickSubmit();

        RegistrationFormPage.checkResult("Student Name", RandomTestData.getFirstName() + " " + RandomTestData.getLastName())
                .checkResult("Student Email", RandomTestData.getEmailAddress())
                .checkResult("Gender", RandomTestData.getGender())
                .checkResult("Mobile", RandomTestData.getUserNumber())
                .checkResult("Date of Birth", RandomTestData.day + " " + RandomTestData.month + "," + RandomTestData.year)
                .checkResult("Subjects", RandomTestData.getSubjects())
                .checkResult("Hobbies", RandomTestData.getHobbiesCheckbox())
                .checkResult("Picture", RandomTestData.getUploadPicture())
                .checkResult("Address", RandomTestData.getCurrentAddress())
                .checkResult("State and City", RandomTestData.getState() + " " + RandomTestData.getCity());


    }

    @Test
    void minFillFormTestTest() {
        RegistrationFormPage.openPage()
                .removeBanner()
                .setFirstName(RandomTestData.getFirstName())
                .setLastName(RandomTestData.getLastName())
                .setUserEmail(RandomTestData.getEmailAddress())
                .setGender(RandomTestData.getGender())
                .setUserNumber(RandomTestData.getUserNumber())
                .setDateOfBirth(RandomTestData.day, RandomTestData.month, RandomTestData.year)
                .clickSubmit();

        RegistrationFormPage.checkResult("Student Name", RandomTestData.getFirstName() + " " + RandomTestData.getLastName())
                .checkResult("Student Email", RandomTestData.getEmailAddress())
                .checkResult("Gender", RandomTestData.getGender())
                .checkResult("Mobile", RandomTestData.getUserNumber())
                .checkResult("Date of Birth", RandomTestData.day + " " + RandomTestData.month + "," + RandomTestData.year);


    }

    @Test
    void negativeFillFormTestTest() {
        RegistrationFormPage.openPage()
                .removeBanner()
                .setFirstName(RandomTestData.getInvalidFirstName())
                .setLastName(RandomTestData.getLastName())
                .setUserEmail(RandomTestData.getEmailAddress())
                .setGender(RandomTestData.getGender())
                .setUserNumber(RandomTestData.getUserNumber())
                .setDateOfBirth(RandomTestData.day, RandomTestData.month, RandomTestData.year)
                .clickSubmit();

        RegistrationFormPage.shouldHaveFirstName(RandomTestData.getInvalidFirstName())
                .shouldHaveLastName(RandomTestData.getLastName())
                .shouldHaveUserEmail(RandomTestData.getEmailAddress())
                .shouldHaveGender(RandomTestData.getGender())
                .shouldHaveUserNumber(RandomTestData.getUserNumber());
    }

}
