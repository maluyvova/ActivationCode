package Helpers;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ActivationCode.URLS;
import Screens.FireTVScreen;
import Screens.WebActivationSighnInScreen;
import Screens.WebFireTVGetCode;
import Screens.XpathForWebActivationSgnInScreen;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AndroidWeb extends ApiumStart implements XpathForWebActivationSgnInScreen  {


  /*  public static WebElement waits(String xpath) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver=capabilities();
        WebDriverWait wait = new WebDriverWait (driver,500);
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }*/

    public static void androidWebChrome() throws MalformedURLException, InterruptedException {
        String code=WebFireTVGetCode.getCode("Firefox");
        AndroidDriver<AndroidElement> driver=capabilities();
        Actions action =new Actions(driver);
        WebDriverWait wait = new WebDriverWait (driver,500);
        driver.get(URLS.webUrl);
        WebElement signInButton=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathForWebActivationSgnInScreen.signInButton)));
        action.click(signInButton).build().perform();
        //action.click(waits(XpathForWebActivationSgnInScreen.signInButton)).click();
        WebElement emailField= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathForWebActivationSgnInScreen.emailField)));
        action.click(emailField).build().perform();
        action.sendKeys(emailField, "vburian@tubi.tv").build().perform();
        WebElement passwordlField= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathForWebActivationSgnInScreen.passwordFiled)));
        action.click(passwordlField).build().perform();
        action.sendKeys(passwordlField, "tubitv").build().perform();
        WebElement sumbitButtonForSignIn= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathForWebActivationSgnInScreen.submitButoonForSignIn)));
        action.click(sumbitButtonForSignIn).build().perform();
        WebElement activationCodeField= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathForWebActivationSgnInScreen.activationCodeField)));
        action.moveToElement(activationCodeField).build().perform();
        action.click(activationCodeField).build().perform();
        action.sendKeys(activationCodeField,code).build().perform();
        WebElement submitForActivationCodeField= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathForWebActivationSgnInScreen.submitButtonForActivationCode)));
        action.click(submitForActivationCodeField).build().perform();
        WebElement homeButtonAfterActivationDevice= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathForWebActivationSgnInScreen.homebuttonAfterActivationDevice)));
        action.click(homeButtonAfterActivationDevice).build().perform();
        ArrayList<WebElement> containerWithFeaturedTitles= (ArrayList<WebElement>) wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(XpathForWebActivationSgnInScreen.containerWithFeaturetTitles)));
        int size=containerWithFeaturedTitles.size();
        boolean ContainerFeaturedTitlesInFireTV=FireTVScreen.isContainerOfFeaturedTitlesDisplayed();
        Assert.assertTrue(ContainerFeaturedTitlesInFireTV, "Featured titles is not displayed in FireTVScreen after activation in AndroidChrome");
        Assert.assertEquals(1,size);
    }





}

