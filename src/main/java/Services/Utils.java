package Services;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class Utils {

    /**
     * Private constructor
     */

    private Utils() {
    }

    /**
     * This method will get the random number
     *
     * @return String
     */
    public static String getRandomNumbers() {
        Faker faker = new Faker();
        return faker.random().nextInt(99999) + "";
    }

    /**
     * This method get the random user first name
     *
     * @return String
     */
    public static String getUserFirstName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    /**
     * This method get the random user last name
     *
     * @return String
     */
    public static String getUserLastName() {
        Faker faker = new Faker();
        return faker.name().lastName();
    }

    /**
     * A wrapper function for Selenide get elements
     *
     * @return SelenideElement
     */
    public static SelenideElement getSelElement(String value, String locator) {
        SelenideElement selElement;
        switch (locator) {
            case "xpath":
                selElement = $(By.xpath(value)).should(Condition.visible);
                break;
            case "css":
                selElement = $(By.cssSelector(value)).should(Condition.visible);
                break;
            default:
                selElement = $(value).should(Condition.visible);
                break;
        }
        return selElement;
    }

    /**
     * A wrapper function for actions on Selenide elements
     */
    public static void actionOnElement(SelenideElement selElement, String actionType, String textValue) {
        switch (actionType) {
            case "click":
                selElement.click();
                break;
            case "type":
                selElement.setValue(textValue);
                break;
            case "waitForVisibility":
                selElement.should(Condition.visible);
                break;
            case "waitFor30Sec":
                selElement.should(Condition.visible, Duration.ofSeconds(30));
                break;
            case "waitForDisappear":
                selElement.should(Condition.disappear, Duration.ofSeconds(30));
                break;
            case "upload":
                selElement.uploadFile(new File(textValue));
                break;
            default:
                break;
        }
    }
}
