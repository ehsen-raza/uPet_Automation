package uPet.StepDefs;

import PageObjectModel.home;
import PageObjectModel.signIn;
import PageObjectModel.signUp;
import PageObjectModel.userProfile;
import Services.BrowserStack;
import Services.Utils;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;

import static com.codeborne.selenide.Selenide.open;

public class imageUpload {

    String firstName, lastName, email, alphaNumericString;
    private final userProfile pgUserProfile = new userProfile();
    private final signIn pgSignIn = new signIn();
    private final signUp pgSignUp = new signUp();
    private final home pgHome = new home();

    @Before
    public void setUp() throws Exception {
        BrowserStack.setCap();
        BrowserStack.driver.setFileDetector(new LocalFileDetector());
    }

    @Given("uPet application is launched")
    public void setupEnvironment() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.startMaximized = true;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Configuration.browserCapabilities = capabilities;

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
        System.out.println(System.getProperty("URL"));
        pgHome.clickUserNameLabel();
        pgUserProfile.waitProfileImageButton()
                .uploadImageFile("src/test/resources/heic-image.HEIC")
                .clickSaveButton()
                .waitForSaveProcess();
    }

    @Then("Profile picture is updated")
    public void profileImageValidation() {
        pgUserProfile
                .validateProfileImage();
    }

    @After
    public void tearDown() throws Exception {
        BrowserStack.closeSession();
    }
}
