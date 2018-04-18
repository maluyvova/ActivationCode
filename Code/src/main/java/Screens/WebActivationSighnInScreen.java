package Screens;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;

import ActivationCode.Driver;
import Helpers.ApiumStart;

public class WebActivationSighnInScreen extends Driver implements XpathForWebActivationSgnInScreen {
    public static void clickOnSignInButton() throws MalformedURLException  {
        Object(XpathForWebActivationSgnInScreen.signInButton2).click();
    }
    public static void sendTextToEmailField(String text) throws MalformedURLException {
        Object(XpathForWebActivationSgnInScreen.emailField).click();
        Object(XpathForWebActivationSgnInScreen.emailField).sendKeys(text);
    }
    public static void sendTextToPasswordField(String text) throws MalformedURLException {
        Object(XpathForWebActivationSgnInScreen.passwordFiled).click();
        Object(XpathForWebActivationSgnInScreen.passwordFiled).sendKeys(text);
    }
    public static void clickOnSubmitForSignInScreen() throws MalformedURLException {
        Object(XpathForWebActivationSgnInScreen.submitButoonForSignIn).click();
    }
    public static void sendTextToActivationFiled(String text) throws MalformedURLException {
        Object(XpathForWebActivationSgnInScreen.activationCodeField).sendKeys(text);
    }
    public static void clickOnSubmitButtonForActivationCode() throws MalformedURLException {
        Object(XpathForWebActivationSgnInScreen.submitButtonForActivationCode).click();
    }
    public static void clickOnHomeButtonAfterActivationCode() throws MalformedURLException {
        Object(XpathForWebActivationSgnInScreen.homebuttonAfterActivationDevice).click();
    }
    public static boolean isContainerWithFeaturetTitlesDisplayed() throws MalformedURLException {
        return Object(XpathForWebActivationSgnInScreen.containerWithFeaturetTitles).isDisplayed();
    }}

