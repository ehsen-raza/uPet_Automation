package Services;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class Utils {

    public static String getRandomNumbers() {
        Faker faker = new Faker();
        return faker.random().nextInt(99999) + "";
    }

    public static String getUserFirstName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public static String getUserLastName() {
        Faker faker = new Faker();
        return faker.name().lastName();
    }

    public static SelenideElement getSelElement(String value, String locator) {
        SelenideElement selElement = null;
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
            case "waitForDisappear":
                selElement.should(Condition.disappear, Duration.ofSeconds(30));
                break;
            case "upload":
                selElement.uploadFile(new File(textValue));
                break;

        }
    }

}
