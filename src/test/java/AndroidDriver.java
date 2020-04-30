import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriver {
    private AppiumDriverLocalService service;

    public static WebDriver GetAppiumDriver(String Package,String Activity) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName",GlobalVariableStorage.deviceName);
        cap.setCapability("udid",GlobalVariableStorage.DeviceId);
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion",GlobalVariableStorage.AndroidVersion);
        cap.setCapability("appPackage",Package);
        cap.setCapability("appActivity",Activity);
        cap.setCapability("automationName","UiAutomator1");
        URL url = new URL(GlobalVariableStorage.URLforAppium);
        return new io.appium.java_client.android.AndroidDriver<MobileElement>(url,cap);
    }

    public void startServer() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a "+GlobalVariableStorage.IP+" -p "+GlobalVariableStorage.port+" --session-override -dc \"{\"\"noReset\"\": \"\"false\"\"}\"\"");
            Thread.sleep(10000);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stopServer() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("taskkill /F /IM node.exe");
            runtime.exec("taskkill /F /IM cmd.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
