package Services;

import com.codeborne.selenide.WebDriverRunner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserStack {
    public static RemoteWebDriver driver;

    private static String username;
    private static String accessKey;

    /**
     * Private constructor
     */
    private BrowserStack(){}

    /**
     * This method will set the capabilities for BrowserStack
     */

    public static void setCap() {

        JSONParser parser = new JSONParser();
        JSONObject config = null;
        try {
            config = (JSONObject) parser.parse(new FileReader("src/test/resources/conf/single.conf.json"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        try {
            assert config != null;
            username = (String) config.get("user");
            accessKey = (String) config.get("key");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("os", "OS X");
        caps.setCapability("os_version", "Catalina");
        caps.setCapability("browser", "Safari");
        caps.setCapability("browser_version", "13.0");
        caps.setCapability("build", "SignUp Test");
        caps.setCapability("project", "uPET Automation");
        caps.setCapability("browserstack.debug", "true");

        try {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@" + config.get("server") + "/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebDriverRunner.setWebDriver(driver);

    }

    /**
     * The same WebDriver instance should be passed that is being used to run the test in the calling function
     * @param status Pass or Fail
     * @param reason Reason of failure
     */
    public static void markTestStatus(boolean status, String reason) {
        String st = status? "pass":"fail";
        JavascriptExecutor jse = driver;
        jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+st+"\", \"reason\": \""+reason+"\"}}");
    }

    /**
     * This method will use the close the session
     */
    public static void closeSession() {
        driver.quit();
    }

}
