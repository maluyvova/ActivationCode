package Screens;

public interface XpathForWebActivationSgnInScreen {
    String signInButton2="/html/body/div/div/div[2]/div/div[2]/div/div/div/div/button[1]";
    String signInButton="(//*[contains(text(), 'Sign In')])[2]";
    String emailField="//input[contains(@autocomplete,'email')]";
    String passwordFiled="//input[contains(@type,'password')]";
    String submitButoonForSignIn="//button[contains(@type,'submit')]";
    String SubmitButoonForSignInForIos="//button[contains(@type,'Sign In')]";
    String activationCodeField="//input[@name='activationCode']";
    String submitButtonForActivationCode="//button[@type='submit']";
    String homebuttonAfterActivationDevice="//button[@class='Button Button--large']";
    String containerWithFeaturetTitles="//div[@class='Container _3tFJDnyICc']";
    String settingForIos="//div[@class='_3iDYyWLnYp']";
    String signOutForios="//a[@data-reactid='94']";
}
