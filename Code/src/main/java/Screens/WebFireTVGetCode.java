package Screens;
import ActivationCode.URLS;
import ActivationCode.Driver;
import static ActivationCode.Driver.br;
public class WebFireTVGetCode extends Driver  {
    public static String   getCode(String browser) {
        driver=br(browser);
        driver.get(URLS.fireTV);
        FireTVScreen.clickEnterOnSignInOrRegisterButton();
        String code=FireTVScreen.getCodeFormActivationFiled();
        return code;
    }


}
