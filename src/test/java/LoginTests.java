import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.*;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.util.logging.Logger;

public class LoginTests {
    static Logger log = (Logger) Logger.getLogger(String.valueOf(LoginTests.class));

    @BeforeClass
    public static void BeforeClass(){
        //Use if Appium desktop version is installed
        //AndroidDriver server = new AndroidDriver();
        //server.startServer();
    }

    @Before
    public void Before() throws MalformedURLException {
        WebDriverRunner.setWebDriver(AndroidDriver.GetAppiumDriver(GlobalVariableStorage.RedditPackage,GlobalVariableStorage.SignIn));
    }

    @Test
    public void LoginTestFail(){
        PageObjects LoginTest = new PageObjects();
        LoginTest.Login(GlobalVariableStorage.username,GlobalVariableStorage.password);
        Selenide.sleep(2000);
        log.info("Asserting that the credentials entered are not correct and the system will not log you in");
        Assert.assertTrue(Selenide.$(By.id(LocatorsStorage.auth_Container)).exists());

    }

    @After
    public void After(){
        WebDriverRunner.closeWebDriver();
    }

    @AfterClass
    public static void AfterClass(){
        //Use if Appium desktop version is installed
        //AndroidDriver server = new AndroidDriver();
        //server.stopServer();
    }
}
