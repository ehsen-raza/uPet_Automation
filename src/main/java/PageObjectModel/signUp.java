package PageObjectModel;

import Services.Utils;
import com.codeborne.selenide.SelenideElement;

public class signUp {

//----------------------------------------------------------------------------------------------------------------------
    /**
     * OBJECT REPOSITORY
     */
//----------------------------------------------------------------------------------------------------------------------

    /**
     * Getting First Name TextBox
     *
     * @return SelenideElement
     */
    private SelenideElement tbFirstName() {
        return Utils.getSelElement("//input[@name='name']", "xpath");
    }

    /**
     * Getting Last Name TextBox
     *
     * @return SelenideElement
     */
    private SelenideElement tbLastName() {
        return Utils.getSelElement("//input[@name='lastName']", "xpath");
    }

    /**
     * Getting Email TextBox
     *
     * @return SelenideElement
     */
    private SelenideElement tbEmail() {
        return Utils.getSelElement("//input[@name='email']", "xpath");
    }

    /**
     * Getting Password TextBox
     *
     * @return SelenideElement
     */
    private SelenideElement tbPassword() {
        return Utils.getSelElement("//input[@name='password']", "xpath");
    }

    /**
     * Getting Submit Button
     *
     * @return SelenideElement
     */
    private SelenideElement btSubmit() {
        return Utils.getSelElement("//button[@type='submit']", "xpath");
    }

    /**
     * Getting main FORM
     *
     * @return SelenideElement
     */
    private SelenideElement formMain() {
        return Utils.getSelElement("//form[@class='center']", "xpath");
    }

//----------------------------------------------------------------------------------------------------------------------
    /*
     * Actions
     */
//----------------------------------------------------------------------------------------------------------------------

    /**
     * This method will type first name in the textbox
     *
     * @param value: A string value of first name
     */
    public signUp enterFirstName(String value) {
        Utils.actionOnElement(tbFirstName(), "type", value);
        return this;
    }

    /**
     * This method will type last name in the textbox
     *
     * @param value: A string value of last name
     */
    public signUp enterLastName(String value) {
        Utils.actionOnElement(tbLastName(), "type", value);
        return this;
    }

    /**
     * This method will type email in the textbox
     *
     * @param value: A string value of email
     */
    public signUp enterEmail(String value) {
        Utils.actionOnElement(tbEmail(), "type", value);
        return this;
    }

    /**
     * This method will type password in the textbox
     *
     * @param value: A string value of password
     */
    public signUp enterPassword(String value) {
        Utils.actionOnElement(tbPassword(), "type", value);
        return this;
    }

    /**
     * This method will help to click on submit button
     */
    public signUp clickSubmitButton() {
        Utils.actionOnElement(btSubmit(), "click", null);
        return this;
    }

    /**
     * This method will help to click on submit button
     */
    public signUp waitForFormDisappear() {
        Utils.actionOnElement(formMain(), "waitForDisappear", null);
        return this;
    }
}
