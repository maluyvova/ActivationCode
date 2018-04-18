
import java.net.MalformedURLException;
import java.util.ArrayList;

import ActivationCode.URLS;
import Helpers.iOS;
import org.testng.annotations.*;
import ActivationCode.Driver;
import Helpers.AndroidWeb;
import Helpers.JavaScript;
import Screens.FireTVScreen;
import Screens.WebActivationSighnInScreen;
import Screens.WebFireTVGetCode;
import junit.framework.Assert;




public class ActivationCode extends Driver {
    public static void Activation(String browser) throws InterruptedException, MalformedURLException{
        String code=WebFireTVGetCode.getCode(browser);
        Helpers.JavaScript.OpenNewTab();
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(URLS.webUrl);
        WebActivationSighnInScreen.clickOnSignInButton();
        Thread.sleep(2000);
        WebActivationSighnInScreen.sendTextToEmailField("vburian@tubi.tv");
        WebActivationSighnInScreen.sendTextToPasswordField("tubitv");
        WebActivationSighnInScreen.clickOnSubmitForSignInScreen();
        WebActivationSighnInScreen.sendTextToActivationFiled(code);
        WebActivationSighnInScreen.clickOnSubmitButtonForActivationCode();
        WebActivationSighnInScreen.clickOnHomeButtonAfterActivationCode();
        boolean ContainerFeaturedTitlesInWeb= WebActivationSighnInScreen.isContainerWithFeaturetTitlesDisplayed();
        driver.switchTo().window(tabs.get(0));
        boolean ContainerFeaturedTitlesInFireTV=FireTVScreen.isContainerOfFeaturedTitlesDisplayed();
        Assert.assertTrue("Featured titles is not displayed in WebScreen",ContainerFeaturedTitlesInWeb);
        Assert.assertTrue("Featured titles is not displayed in FireTVScreen",ContainerFeaturedTitlesInFireTV);
        driver.close();
        driver.quit();
    }
    @Test
    public static void fireFox() throws MalformedURLException, InterruptedException {
        Activation("Firefox");
    }
    @Test
    public static void iOS() throws MalformedURLException, InterruptedException {
        iOS.iOS();
    }
    @Test
    public static void chrome() throws MalformedURLException, InterruptedException {
        Activation("Chrome");
    }
    @Test
    public static void  android()throws MalformedURLException, InterruptedException{
        AndroidWeb.androidWebChrome();
    }


    @AfterTest
    public static void closeBrowser() {
        driver.quit();
      //  driver.close();

    }


}
