package Screens;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ActivationCode.Driver;

public class FireTVScreen extends Driver implements XpathsForFireTVScreen  {

    public static void clickEnterOnSignInOrRegisterButton() {
        Actions action =new Actions(driver);
        WebElement SignInOrRegister=Object(XpathsForFireTVScreen.signInOrRegister);
        action.moveToElement(SignInOrRegister).sendKeys(Keys.ENTER).build().perform();
    }
    public static String getCodeFormActivationFiled() {
        return Object(XpathsForFireTVScreen.activationCodeField).getText();
    }
    public static boolean isContainerOfFeaturedTitlesDisplayed() {
        return Object(XpathsForFireTVScreen.containerOfFeaturedTitles).isDisplayed();
    }

}
