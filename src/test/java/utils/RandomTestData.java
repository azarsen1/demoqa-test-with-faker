package utils;

import com.github.javafaker.Faker;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class RandomTestData {

    private final Faker faker = new Faker(new Locale("en"));

    public String getFirstName() {
        return faker.name().firstName();
    }
    public String getInvalidFirstName() {
        return faker.options().option("", "   ", "1234", "#$%^?");
    }
    public String getLastName() {
        return faker.name().lastName();
    }
    public String getEmailAddress()  {
        return faker.internet().emailAddress();
    }
    public String getGender()  {
        return faker.options().option("Male", "Female", "Other");
    }
    public String getUserNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }
    public Date getRandomDate() {
        return faker.date().birthday(1, 100);
    }
    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    private String day;
    private String month;
    private String year;

    public RandomTestData() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getRandomDate());

        this.day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
        this.month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
        this.year = String.valueOf(cal.get(Calendar.YEAR));
    }

    public String getSubjects() {
        return faker.options().
                option("Hindi", "English", "Maths", "Physics", "Chemistry", "Biology", "Computer Science",
                        "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History", "Civics");
    }

    public String getHobbiesCheckbox() {
        return faker.options().option("Sports", "Reading", "Music");
    }
    public String getUploadPicture() {
        return faker.options().option("AGE_TEST.jpg", "arrow.png", "puzzle.webp");
    }
    public String getCurrentAddress() {
        return faker.address().streetAddressNumber();
    }
    public String getState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }
    public String getCity() {
        return getRandomCity(getState());
    }

    public String getRandomCity(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
            default:
                return "Unknown";

        }

    }


}
