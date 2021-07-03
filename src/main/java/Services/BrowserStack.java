package Services;

import com.codeborne.selenide.WebDriverRunner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileReader;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserStack {
    public static RemoteWebDriver driver;

    public static String username;
    public static String accessKey;
    public static String sessionId;

    public static void setCap() throws Exception {

        JSONParser parser = new JSONParser();
        JSONObject config = (JSONObject) parser.parse(new FileReader("src/test/resources/conf/single.conf.json"));

        username = (String) config.get("user");
        accessKey = (String) config.get("key");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "safari");
        caps.setCapability("browser_version", "14.0");
        caps.setCapability("os", "OS X");
        caps.setCapability("os_version", "Big Sur");
        caps.setCapability("build", "SignUp Test");
        caps.setCapability("project", "uPET Automation");
        caps.setCapability("browserstack.debug", "true");

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@" + config.get("server") + "/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        sessionId = driver.getSessionId().toString();

        WebDriverRunner.setWebDriver(driver);

    }

    /**
     * This method will use the close the session
     *
     * @throws Exception
     */
    public static void closeSession() {
        driver.quit();
    }

}
