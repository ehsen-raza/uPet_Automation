package PageObjectModel;

import Services.Utils;
import com.codeborne.selenide.SelenideElement;

public class signIn {

//----------------------------------------------------------------------------------------------------------------------
    /**
     * OBJECT REPOSITORY
     */
//----------------------------------------------------------------------------------------------------------------------

    /**
     * Getting UserName
     *
     * @return SelenideElement
     */
    private SelenideElement linkCreateAccount() {
        return Utils.getSelElement("//button[@label='NEWBIE? CREATE ACCOUNT']", "xpath");
    }
//----------------------------------------------------------------------------------------------------------------------
    /**
     * Actions
     */
//----------------------------------------------------------------------------------------------------------------------

    /**
     * This method will help to click on create an accounts link
     */
    public signIn clickCreateAccountLink() {
        Utils.actionOnElement(linkCreateAccount(), "click", null);
        return this;
    }

}
