package Helpers;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;



public class IosWebDriverStart {

    static DesiredCapabilities capabilities = new DesiredCapabilities();
    public static IOSDriver inits() throws MalformedURLException {
         IOSDriver driver;
        //capabilities.setCapability("xcodeConfigFile","/Users/vburian/.xcconfig");
        capabilities.setCapability("xcodeOrgId", "3RT6Z533P8");
        capabilities.setCapability("xcodeSigningId","iPhone Developer");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"iOS");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME ,"XCUITest");
        capabilities.setCapability(MobileCapabilityType.UDID,"8ac60b225c69602a5c8729a6d83e6f8973199650");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Safari");
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),
                capabilities);
       // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;

    }}






