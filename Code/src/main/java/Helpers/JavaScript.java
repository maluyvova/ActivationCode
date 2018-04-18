package Helpers;

import org.openqa.selenium.JavascriptExecutor;

import ActivationCode.Driver;

public class JavaScript extends Driver{


    public static void OpenNewTab() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
    }

}
