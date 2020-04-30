import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.*;
import org.openqa.selenium.By;
import java.net.MalformedURLException;
import java.util.logging.Logger;

public class MainActivityTests {
    static Logger log = (Logger) Logger.getLogger(String.valueOf(MainActivityTests.class));

    @BeforeClass
    public static void BeforeClass(){
        //Use if Appium desktop version is installed
        //AndroidDriver server = new AndroidDriver();
        //server.startServer();
    }

    @Before
    public void Before() throws MalformedURLException {
        WebDriverRunner.setWebDriver(AndroidDriver.GetAppiumDriver(GlobalVariableStorage.RedditPackage,GlobalVariableStorage.MainActivity));
    }

    @Test
    public void DeleteSearch(){
        log.info("Starting test for Search deletion");
        Selenide.$(By.id(LocatorsStorage.DefaultSearch)).sendKeys("Test");
        log.info("Asserting that Test has been entered in the search field and has the word present in the search field");
        Assert.assertTrue(Selenide.$(By.id("search")).getText().contains("Test"));
        Selenide.$(By.id(LocatorsStorage.DeleteIcon)).click();
        log.info("Asserting that clicking the clear icon clears the search parameters and the widget defaults the search bar to default value of Search Reddit");
        Assert.assertTrue(Selenide.$(By.id(LocatorsStorage.AfterSearch)).getText().matches("Search Reddit"));
    }

    @Test
    public void SearchTest(){
        PageObjects SearchTest = new PageObjects();
        log.info("Searching for r/COVID Cryteria");
        String text = "r/COVID";
        SearchTest.Search(text);
        log.info("Asserting that the system searched for the Cryteria and returned the results for the search term");
        Assert.assertTrue(Selenide.$(By.id(LocatorsStorage.SearchResult)).waitUntil(Condition.visible,5000).getText().contains(text));

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
