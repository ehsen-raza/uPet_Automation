package uPet.StepDefs;

import PageObjectModel.home;
import PageObjectModel.signIn;
import PageObjectModel.signUp;
import PageObjectModel.userProfile;
import Services.BrowserStack;
import Services.Utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.LocalFileDetector;

import static com.codeborne.selenide.Selenide.open;

public class imageUpload {

    String firstName, lastName, email, alphaNumericString;
    boolean testStatus = false;
    private final userProfile pgUserProfile = new userProfile();
    private final signIn pgSignIn = new signIn();
    private final signUp pgSignUp = new signUp();
    private final home pgHome = new home();

    @Before
    public void setUp() {
        BrowserStack.setCap();
        BrowserStack.driver.setFileDetector(new LocalFileDetector());
    }

    @Given("uPet application is launched")
    public void invokeApplication() {
        open("https://test.app.upet.co");
    }


    @When("A new user is registered")
    public void userRegistration() {
        alphaNumericString = Utils.getRandomNumbers();
        firstName = Utils.getUserFirstName();
        lastName = Utils.getUserLastName();
        email = firstName + "-" + lastName + "-" + alphaNumericString + "@upet.co";

        pgSignIn.clickCreateAccountLink();

        pgSignUp.enterFirstName(firstName)
                .enterLastName(lastName)
                .enterEmail(email)
                .enterPassword("123Abc!@#")
                .clickSubmitButton()
                .waitForFormDisappear();
    }

    @And("Uploaded a profile picture")
    public void profileImageUpload() {
        pgHome.clickUserNameLabel();
        pgUserProfile.waitProfileImageButton()
                .uploadImageFile("src/test/resources/heic-image.HEIC")
                .clickSaveButton()
                .waitForSaveProcess();
    }

    @Then("Validate profile picture is updated")
    public void profileImageValidation() {
        testStatus = pgUserProfile
                        .validateProfileImage();
    }

    @After
    public void tearDown() {
        BrowserStack.markTestStatus(testStatus, "Image is not uploaded");
        BrowserStack.closeSession();
    }
}
