package PageObjectModel;

import Services.Utils;
import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.junit.SoftAsserts;
import org.openqa.selenium.By;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;

public class userProfile {
//----------------------------------------------------------------------------------------------------------------------
    /**
     * OBJECT REPOSITORY
     */
//----------------------------------------------------------------------------------------------------------------------

    /**
     * Getting Profile Image Button
     *
     * @return SelenideElement
     */
    private SelenideElement btProfileImage() {
        return Utils.getSelElement("//img[@alt='profile image']/..//button", "xpath");
    }

    /**
     * Getting Upload Object
     *
     * @return SelenideElement
     */
    private SelenideElement uploadPhoto() {
        return Utils.getSelElement("#uploadPhoto", "default");
    }

    /**
     * Getting Save button
     *
     * @return SelenideElement
     */
    private SelenideElement btSave() {
        return Utils.getSelElement("//button[@label='Save']", "xpath");
    }

    /**
     * Getting Dialog Box and Wait
     *
     * @return SelenideElement
     */
    private SelenideElement dgWaitFor() {
        return $(By.xpath("//div[@role='dialog']")).shouldNotBe(Condition.visible, Duration.ofSeconds(30));
    }
    /**
     * Getting Save button
     *
     * @return SelenideElement
     */
    private SelenideElement msgSuccess() {
        return Utils.getSelElement("//*[@id='successMessage']/div", "xpath").should(Condition.visible, Duration.ofSeconds(60));
    }

    /**
     * Getting profile image container
     *
     * @return SelenideElement
     */
    private SelenideElement imgProfileImage() {
        return Utils.getSelElement("//input[@id='uploadPhoto']//parent::div//parent::section/img", "xpath");
    }

//----------------------------------------------------------------------------------------------------------------------
    /**
     * Actions
     */
//----------------------------------------------------------------------------------------------------------------------
    /**
     * This method will help to click on profile image button
     */
    public userProfile waitProfileImageButton() {
        Utils.actionOnElement(btProfileImage(), "waitForVisibility", null);
        return this;
    }

    /**
     * This method will help to upload an image file
     */
    public userProfile uploadImageFile(String path) {
        $("#uploadPhoto").uploadFile(new File(path));
        //Utils.actionOnElement(uploadPhoto(), "upload", path);
        return this;
    }

    /**
     * This method will help to click on save button
     */
    public userProfile clickSaveButton() {
        Utils.actionOnElement(btSave(), "click", null);
        return this;
    }

    /**
     * This method will help to click on save button
     */
    public userProfile waitForSaveProcess() {
        dgWaitFor();
        return this;
    }

//----------------------------------------------------------------------------------------------------------------------
    /**
     * Validation
     */
//----------------------------------------------------------------------------------------------------------------------
    /**
     * This method will wait until success message appears
     */
    public userProfile waitForDialog() {
        Utils.actionOnElement(msgSuccess(), "waitForVisibility", null);
        return this;
    }

    /**
     * This method will validate the image is attached with the profile
     */
    public userProfile validateProfileImage() {
        refresh();
        String expectedValue = "cloudfront.net/imagenes/upet/pets";
        imgProfileImage().has(Condition.image);

        return this;
    }


}
