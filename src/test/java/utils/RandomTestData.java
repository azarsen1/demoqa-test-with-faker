package utils;

import com.github.javafaker.Faker;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class RandomTestData {

    Faker faker = new Faker(new Locale("en"));
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String emailAddress = faker.internet().emailAddress();
    public String gender = faker.options().option("Male", "Female", "Other");
    public String userNumber = faker.phoneNumber().subscriberNumber(10);
    public Date randomDate = faker.date().birthday(1, 100);

    public String day;
    public String month;
    public String year;

    public RandomTestData() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(randomDate);
    }

    public String subjects = faker.options().
            option("Hindi", "English", "Maths", "Physics", "Chemistry", "Biology", "Computer Science",
                    "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History", "Civics");

    public String hobbiesCheckbox = faker.options().option("Sports", "Reading", "Music");
    public String uploadPicture = faker.options().option("AGE_TEST.jpg", "arrow.png", "puzzle.webp");
    public String currentAddress = faker.address().streetAddressNumber();
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = getRandomCity(state);

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
