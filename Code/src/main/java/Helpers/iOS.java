package Helpers;

import ActivationCode.URLS;
import Screens.FireTVScreen;
import Screens.WebFireTVGetCode;
import Screens.XpathForWebActivationSgnInScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.RemoteExecuteMethod;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class iOS {



    public static void iOS () throws MalformedURLException, InterruptedException {
        IOSDriver driver=IosWebDriverStart.inits();
         Actions action =new Actions(driver);
        WebDriverWait wait = new WebDriverWait (driver,500);
       String code=WebFireTVGetCode.getCode("Firefox");
        driver.get(URLS.webUrl);
        WebElement signInButton=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathForWebActivationSgnInScreen.signInButton)));
        signInButton.click();
        WebElement emailField= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathForWebActivationSgnInScreen.emailField)));
        emailField.click();
        emailField.sendKeys("vburian@tubi.tv");
        WebElement passwordlField= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathForWebActivationSgnInScreen.passwordFiled)));
        passwordlField.click();
        Thread.sleep(2000);
        passwordlField.sendKeys("tubitv");
        Thread.sleep(2000);
        WebElement sumbitButtonForSignIn= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[2]/div/div[1]/div/div/div/form/div[3]/div/button/div[1]")));
        sumbitButtonForSignIn.click();
        WebElement activationCodeField= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathForWebActivationSgnInScreen.activationCodeField)));
        activationCodeField.click();
        activationCodeField.sendKeys(code);
        WebElement submitForActivationCodeField= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathForWebActivationSgnInScreen.submitButtonForActivationCode)));
        submitForActivationCodeField.click();
        WebElement homeButtonAfterActivationDevice= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathForWebActivationSgnInScreen.homebuttonAfterActivationDevice)));
        homeButtonAfterActivationDevice.click();
        ArrayList<WebElement> containerWithFeaturedTitles= (ArrayList<WebElement>) wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(XpathForWebActivationSgnInScreen.containerWithFeaturetTitles)));
        int size=containerWithFeaturedTitles.size();
        WebElement settings=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathForWebActivationSgnInScreen.settingForIos)));
        settings.click();
        WebElement signOut=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathForWebActivationSgnInScreen.signOutForios)));
        signOut.click();
        boolean ContainerFeaturedTitlesInFireTV=FireTVScreen.isContainerOfFeaturedTitlesDisplayed();
        driver.close();
        Assert.assertTrue(ContainerFeaturedTitlesInFireTV, "Featured titles is not displayed in FireTVScreen after activation in AndroidChrome");
        Assert.assertEquals(1,size);
    }

}
