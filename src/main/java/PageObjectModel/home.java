package PageObjectModel;

import Services.Utils;
import com.codeborne.selenide.SelenideElement;

public class home {

//----------------------------------------------------------------------------------------------------------------------
    /*
     * OBJECT REPOSITORY
     */
//----------------------------------------------------------------------------------------------------------------------
    /**
     * Getting UserName
     * @return SelenideElement
     */
    private SelenideElement labelUserName(){
        return Utils.getSelElement("//div[@id='userProfile']/div[2]/span", "xpath");
    }

//----------------------------------------------------------------------------------------------------------------------
    /*
     * Actions
     */
//----------------------------------------------------------------------------------------------------------------------
    /**
     * This method will wait until user profile is loaded
     */
    public home clickUserNameLabel() {
        Utils.actionOnElement(labelUserName(),"click", null);
        return this;
    }

}
